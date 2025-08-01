/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Affero GPL-3.0 license. See project root for full text.
 */

package org.pointyware.disco.site.home

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
import org.pointyware.disco.site.dsl.DirectoryScope
import org.pointyware.disco.site.dsl.css

/**
 * Renders the home page of the site.
 */
fun DirectoryScope.homePage() {
    val centerClass = "center"
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
            div {
                h1 {
                    text("Docs")
                }
                val sourceLink = "docs/"
                a(
                    href = "https://$sourceLink"
                ) {
                    text(sourceLink)
                }
            }

            footer {
                p {
                    text("© 2025 Pointyware LLC")
                }
                p {
                    text("This site is powered by Kotlin and kotlinx.html. - view the source code on GitHub: ")
                    val sourceLink = "github.com/Pointyware/Disco/website/"
                    a(
                        href = "https://$sourceLink"
                    ) {
                        text(sourceLink)
                    }
                }
            }
        }
    }
}
