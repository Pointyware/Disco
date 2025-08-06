/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license. See project root for full text.
 */

package org.pointyware.disco.site

import org.pointyware.weaver.dsl.ProgramOutput.PrintOutput
import org.pointyware.weaver.utils.ProgramInputs
import org.pointyware.weaver.utils.consumeArgs

/**
 * How to use:
 * --out <filepath> | the default is System.out with a virtual root at "/"
 *
 */
fun main(vararg args: String) {
    // Declare Program defaults explicitly for parity with documentation 👍
    var inputs = ProgramInputs(
        output = PrintOutput("/", System.out)
    )

    // Process Arguments
    inputs = args.iterator().consumeArgs(inputs)

    // Render Site
    buildSite(inputs.output)
}
