/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site

import org.pointyware.xyz.site.dsl.ProgramOutput
import org.pointyware.xyz.site.dsl.site
import org.pointyware.xyz.site.home.homePage

/**
 * The main entry point for the site generation.
 */
fun buildSite(
    output: ProgramOutput
) {
    // no setup needed, just call the site function
    site(output) {
        homePage()
        branch("privacy-policy") {
            index(resourceFile = "docs/privacy-policy.html")
        }

        branch("terms-of-service") {
            index(resourceFile = "docs/terms-of-service.html")
        }
        file("CNAME", "CNAME")
        file("robots.txt", "robots.txt")
    }
}
