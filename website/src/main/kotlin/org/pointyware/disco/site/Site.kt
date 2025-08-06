/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license. See project root for full text.
 */

package org.pointyware.disco.site

import org.pointyware.weaver.dsl.ProgramOutput
import org.pointyware.weaver.dsl.site
import org.pointyware.weaver.home.homePage

/**
 * The main entry point for the site generation.
 */
fun buildSite(
    output: ProgramOutput
) {
    // no setup needed, just call the site function
    site(output) {
        homePage()
        file("CNAME")
        file("robots.txt")
    }
}
