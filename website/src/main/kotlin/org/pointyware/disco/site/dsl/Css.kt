/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site.dsl

import kotlinx.html.STYLE
import kotlinx.html.StyleType
import kotlinx.html.unsafe

/**
 * Configures a style tag for cascading stylesheets and the given [mediaType], then executes the
 * given [block] in the context of a [CssScope] before outputting the result to the [STYLE] tag.
 */
fun STYLE.css(
    throwOnConflict: Boolean = true,
    mediaType: CssMediaType = CssMediaType.ALL,
    block: CssScope.() -> Unit,
) {
    type = StyleType.textCss
    media = mediaType.value
    unsafe {
        // Construct receiver data structure
        val ast = AbstractStylesheet(throwOnConflict = throwOnConflict)
        // Process DSL to build up AST
        CssScope(ast).block()
        // Output final AST
        raw(ast.stylesheet())
    }
}

/**
 * Represents one of the available HTML media-presentation optimization types.
 */
enum class CssMediaType(val value: String) {
    /**
     * The default media type, used when no other media type is specified.
     */
    ALL("all"),

    /**
     * Optimized for presentation on screens, tablets, etc.
     */
    SCREEN("screen"),

    /**
     * Optimized for print previews and printing.
     */
    PRINT("print")
}

/**
 * An abstract representation of a cascading stylesheet.
 */
class AbstractStylesheet(
    private val throwOnConflict: Boolean,
) {
    val outputMap = mutableMapOf<String, StyleScope>()

    fun add(key: String, styles: StyleScope) {
        if (throwOnConflict) {
            if (outputMap.containsKey(key)) {
                throw IllegalStateException("Duplicate key: $key")
            }
        }
        outputMap[key] = styles
    }

    fun stylesheet(): String {
        return outputMap.entries.joinToString("\n") { (key, value) ->
            "$key {\n${value.styleBlock()}\n}"
        }
    }
}

/**
 * Defines the root scope of our Css DSL.
 */
class CssScope(
    private val output: AbstractStylesheet
) {
    fun body(styles: StyleScope.() -> Unit) {
        tag("body", styles)
    }

    fun p(styles: StyleScope.() -> Unit) {
        tag("p", styles)
    }

    fun h1(styles: StyleScope.() -> Unit) {
        tag("h1", styles)
    }

    fun tag(name: String, styles: StyleScope.() -> Unit) {
        val styleScope = StyleScope()
        styleScope.styles()
        output.add(name, styleScope)
    }

    fun String.cls(styles: StyleScope.() -> Unit) {
        tag(".$this", styles)
    }

    fun String.id(styles: StyleScope.() -> Unit) {
        tag("#$this", styles)
    }
}

class StyleScope() {
    var color: String? = null
    var backgroundColor: String? = null
    var textAlign: String? = null
    var fontSize: String? = null
    var fontFamily: String? = null
    var margin: String? = null
    var padding: String? = null
    var border: String? = null
    var display: String? = null

    fun styleBlock(): String {
        return listOfNotNull(
            color?.let { "color: $it;" },
            backgroundColor?.let { "background-color: $it;" },
            textAlign?.let { "text-align: $it;" },
            fontSize?.let { "font-size: $it;" },
            fontFamily?.let { "font-family: $it;" },
            margin?.let { "margin: $it;" },
            padding?.let { "padding: $it;" },
            border?.let { "border: $it;" },
            display?.let { "display: $it;" }
        ).joinToString("\n") + "\n"
    }
}
