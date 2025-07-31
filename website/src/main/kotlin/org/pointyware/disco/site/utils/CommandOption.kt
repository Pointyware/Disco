/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site.utils

import org.pointyware.xyz.site.dsl.ProgramOutput
import java.io.File

/**
 * Defines individual program options for the command line interface.
 */
enum class CommandOption(
    val longName: String,
    val shortName: String,
    val description: String,
    val defaultValue: String,
    val onMatch: (Iterator<String>, ProgramInputs)->ProgramInputs
) {
    /**
     * Program option for specifying the output file or stream.
     */
    Output(
        longName = "out",
        shortName = "o",
        description = "[filename|--] Determines the output file or stream. Defaults to System.out, which has the alias \"--\".",
        defaultValue = "--",
        onMatch = { args, inputs ->
            if (args.hasNext()) {
                val next = args.next()
                when (next) {
                    "--" -> inputs.copy(output = ProgramOutput.PrintOutput("/", System.out))
                    else -> inputs.copy(output = ProgramOutput.FileOutput(File(next)))
                }
            } else {
                throw IllegalArgumentException("Missing argument for ${Output.longName}")
            }
        }
    )
}

/**
 * Consumes arguments provided by a string iterator and updates the program inputs accordingly.
 */
fun Iterator<String>.consumeArgs(inputs: ProgramInputs): ProgramInputs {
    var latestInputs = inputs
    var unrecognizedArgs = mutableListOf<String>()
    while (hasNext()) { // Continue to consume command options until all args are consumed
        val arg = next()
        when {
            arg.startsWith("--") -> {
                val longOption = arg.substring(2)
                CommandOption.entries.forEach {
                    if (it.longName == longOption) {
                        latestInputs = it.onMatch(this, latestInputs)
                        return@forEach
                    }
                }
            }
            arg.startsWith("-") -> {
                val shortOption = arg.substring(1)
                CommandOption.entries.forEach {
                    if (it.shortName == shortOption) {
                        latestInputs = it.onMatch(this, latestInputs)
                        return@forEach
                    }
                }
            }
            else -> {
                unrecognizedArgs += arg
            }
        }
    }
    if (unrecognizedArgs.isNotEmpty()) {
        println("Unrecognized arguments: ${unrecognizedArgs.joinToString(", ")}")
    }
    return latestInputs
}
