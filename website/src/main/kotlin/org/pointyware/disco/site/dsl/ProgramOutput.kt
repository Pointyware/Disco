/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site.dsl

import java.io.File
import java.io.PrintStream

/**
 * Defines the available program outputs.
 * To control with program arguments, see [org.pointyware.xyz.site.utils.CommandOption.Output].
 */
sealed interface ProgramOutput {
    fun branch(segment: String): ProgramOutput
    data class FileOutput(val file: File): ProgramOutput {

        init {
            if (!file.exists()) {
                file.mkdirs()
            }
        }

        override fun branch(segment: String): ProgramOutput {
            val branchFile = File(file, segment)
            return FileOutput(branchFile)
        }
    }
    data class PrintOutput(val path: String, val stream: PrintStream): ProgramOutput {
        override fun branch(segment: String): ProgramOutput {
            return PrintOutput(path = "$path/$segment", stream = stream)
        }
    }
}
