/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license.
 */

package org.pointyware.xyz.site.home

import kotlinx.html.ScriptType
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.footer
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.p
import kotlinx.html.script
import kotlinx.html.style
import org.pointyware.xyz.site.dsl.DirectoryScope
import org.pointyware.xyz.site.dsl.css

/**
 * Renders the home page of the site.
 */
fun DirectoryScope.homePage() {
    val centerClass = "center"
    val privacyPolicyLinkClass = "privacy-policy-link"
    val termsOfServiceLinkClass = "terms-of-service-link"
    index {
        // Consider: https://github.com/allangomes/kotlinwind.css/tree/dev in place of kotlinx.css
        head {
            style {
                css {
                    body {
                        backgroundColor = "#f0f0f0"
                        fontFamily = "Arial, sans-serif"
                        margin = "0"
                        padding = "20px"
                    }
                    h1 {
                        color = "#333"
                    }
                    p {
                        color = "#666"
                    }
                    centerClass.cls {
                        this.textAlign = "center"
                    }
                    privacyPolicyLinkClass.cls {
                    }
                    termsOfServiceLinkClass.cls {
                    }
                }
            }
            script(
                type = ScriptType.textJavaScript,
            ) {
//                unsafe {
//                    raw("""
//                                console.log("Hello, World!");
//                            """.trimIndent())
//                }
            }
        }
        body {
            div(
                classes = centerClass
            ) {
                h1 {
                    text("XYZ - Get your X from Y to Z")
                }

                p {
                    text("XYZ is attempting to cut out the middleman, Uber, to provide more compensation to drivers and lower prices for riders. We want to allow drivers to legitimately be their own boss, instead of being a cog in the Uber machine – and \"legit\" means \"legal\" – so we're also helping drivers navigate the complexity of starting and running their own business, including managing assets, revenue, taxes, employees, and on. We are not a rideshare company, we are a rideshare platform.")
                }

                p {
                    text("Our mission is ultimately to operate our service for drivers and riders at-cost, and to be a community-driven project.")
                }
            }

            footer {
                p {
                    text("© 2025 Pointyware LLC")
                }
                p {
                    text("This site is powered by Kotlin and kotlinx.html. - view the source code on GitHub: ")
                    a(
                        href = "https://github.com/Pointyware/XYZ"
                    ) {
                        text("github.com/Pointyware/XYZ")
                    }
                }
                p {
                    a(
                        href = "./privacy-policy",
                        classes = privacyPolicyLinkClass
                    ) {
                        text("Privacy Policy")
                    }
                }
                p {
                    a(
                        href = "./terms-of-service",
                        classes = termsOfServiceLinkClass
                    ) {
                        text("Terms of Service")
                    }
                }
            }
        }
    }
}
