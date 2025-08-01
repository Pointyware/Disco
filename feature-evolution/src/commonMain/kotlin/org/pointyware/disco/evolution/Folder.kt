/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.evolution

/**
 * Folders abstract away all the chemical and mechanical details of protein folding
 * for their respective dynamics.
 */
interface Folder<Output> {
    fun fold(polypeptides: List<List<AminoAcid>>): Output
}
