/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.evolution

import kotlin.experimental.ExperimentalNativeApi
import kotlin.test.Test

@OptIn(ExperimentalNativeApi::class)
class AminoAcidUnitTest {

    @Test
    fun verify_no_short_code_overlaps() {
        val confirmed = mutableSetOf<String>()
        AminoAcid.entries.forEach { aminoAcid ->
            val shortName = aminoAcid.shortCode
            assert(!confirmed.contains(shortName)) {
                "Duplicate short code: $shortName"
            }
            confirmed.add(shortName)
        }
    }
}
