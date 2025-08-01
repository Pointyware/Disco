/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license. See project root for full text.
 */

package org.pointyware.disco.site

import org.pointyware.disco.site.dsl.ProgramOutput
import org.pointyware.disco.site.dsl.site
import org.pointyware.disco.site.home.homePage

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
