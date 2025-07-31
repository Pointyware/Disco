/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site.dsl

import kotlinx.html.HTML
import kotlinx.html.dom.createHTMLDocument
import kotlinx.html.dom.write
import kotlinx.html.html
import org.pointyware.xyz.site.utils.sanitizeHtmlFileName
import java.io.File

/**
 * The main unit of our DSL API.
 */
interface BranchScope {
    /**
     * Controls the abstract location of this branch within the larger hierarchy.
     */
    val location: ProgramOutput

    fun branch(
        segment: String,
        block: BranchScope.() -> Unit
    ) {
        val branch = location.branch(segment)
        DirectoryScope(branch).block()
    }

    /**
     * Creates an html page resource with the standard index.html file name.
     */
    fun index(
        block: HTML.() -> Unit
    ) = page(name = "index.html", block = block)

    /**
     * Copies the resource file indicated by [resourceFile] into a file named index.html.
     */
    fun index(resourceFile: String) = page(name = "index.html", resourceFile = resourceFile)

    /**
     * Creates an html page resource with the standard error.html file name.
     */
    fun error(
        block: HTML.() -> Unit
    ) = page(name = "error.html", block = block)

    /**
     * Copies the resource file indicated by [resourceFile] into a file named error.html.
     */
    fun error(resourceFile: String) = page(name = "error.html", resourceFile = resourceFile)

    /**
     * Creates an html page resource with the given file name. First ensures that the filename
     * does not contain certain characters and ends with .html; see [sanitizeHtmlFileName].
     */
    fun page(
        name: String,
        block: HTML.() -> Unit
    ) {
        val sanitizedFileName = sanitizeHtmlFileName(name)

        val doc = createHTMLDocument().html(block = block)

        when (val capture = location) {
            is ProgramOutput.FileOutput -> {
                val pageFile = File(capture.file, sanitizedFileName)
                pageFile.outputStream().bufferedWriter().use {
                    it.write(document = doc)
                }
            }
            is ProgramOutput.PrintOutput -> {
                capture.stream.println("Printing page: ${capture.path}")
                capture.stream.bufferedWriter().let {
                    it.write(document = doc)
                    it.flush() // ensure buffer is cleared because we'll just let GC clean up since we don't want to close the underlying stream
                }
            }
        }
    }

    /**
     * Copies the resource file indicated by [resourceFile] into a file with the given [name].
     */
    fun page(
        name: String,
        resourceFile: String
    ) {
        val sanitizedFileName = sanitizeHtmlFileName(name)
        val sourceInputStream = this.javaClass.classLoader.getResourceAsStream(resourceFile)
            ?: throw IllegalArgumentException("Resource file not found: $resourceFile")

        when (val capture = location) {
            is ProgramOutput.FileOutput -> {
                val pageFile = File(capture.file, sanitizedFileName)
                pageFile.outputStream().use { outputStream ->
                    sourceInputStream.use { fileStream ->
                        fileStream.copyTo(outputStream)
                    }
                }
            }
            is ProgramOutput.PrintOutput -> {
                capture.stream.println("Printing page: ${capture.path}")
                capture.stream.let { printStream ->
                    sourceInputStream.use { fileStream ->
                        fileStream.copyTo(printStream)
                    }
                    printStream.flush() // ensure buffer is cleared because we'll just let GC clean up since we don't want to close the underlying stream
                }
            }
        }
    }

    /**
     * Copies the resource file indicated by [resourceFile] into a file with the given [name],
     * unsanitized.
     */
    fun file(
        name: String,
        resourceFile: String
    ) {
        val sourceInputStream = this.javaClass.classLoader.getResourceAsStream(resourceFile)
            ?: throw IllegalArgumentException("Resource file not found: $resourceFile")

        when (val capture = location) {
            is ProgramOutput.FileOutput -> {
                val pageFile = File(capture.file, name)
                pageFile.outputStream().use { outputStream ->
                    sourceInputStream.use { fileStream ->
                        fileStream.copyTo(outputStream)
                    }
                }
            }
            is ProgramOutput.PrintOutput -> {
                capture.stream.println("Printing file: ${capture.path}/$name")
                capture.stream.let { printStream ->
                    sourceInputStream.use { fileStream ->
                        fileStream.copyTo(printStream)
                    }
                    printStream.flush() // ensure buffer is cleared because we'll just let GC clean up since we don't want to close the underlying stream
                }
            }
        }
    }
}

/**
 * Represents each branch as a directory in the file system (or virtual path in the case of [ProgramOutput.PrintOutput].
 */
data class DirectoryScope(
    override val location: ProgramOutput
): BranchScope

/**
 * Returns the root scope for our custom DSL API. The Kotlin HTML DSL allows us to build a single
 * HTML page, and our DSL wraps this API to allow us to build a hierarchy of endpoints.
 *
 * When the output is a directory, each terminal endpoint is printed out to a separate index.html
 * file along some directory path described by the hierarchy. When the output is System.out, since
 * all the pages are printed out to the same stream, they are delimited by descriptors that include
 * the path to the endpoint and the page name.
 *
 * What we want to achieve is the ability to determine the root of a folder hierarchy, and then
 * build up a hierarchy of endpoints, where each terminal endpoint contains at least one page
 * (usually an index.html file).
 */
fun site(root: ProgramOutput, block: DirectoryScope.() -> Unit) {
    val site = DirectoryScope(root)
    site.block()
}
