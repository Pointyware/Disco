/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.data

/**
 * Describes the interactions available on all text completion services.
 */
interface TextCompletionService {
    suspend fun complete(prompt: String): String
}
