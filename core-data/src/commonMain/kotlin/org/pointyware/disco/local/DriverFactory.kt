/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.local
import app.cash.sqldelight.db.SqlDriver


internal const val DATABASE_NAME = "ontology.db"

/**
 *
 */
interface DriverFactory {
    /**
     * Create a SqlDriver based on the path. If the path is empty, an in-memory database is created.
     */
    fun createSqlDriver(path: String = ""): SqlDriver

    /**
     * Create a SqlDriver based on the persistence type.
     */
    fun createSqlDriver(persistence: Persistence = Persistence.File): SqlDriver {
        return when (persistence) {
            Persistence.InMemory -> createSqlDriver("")
            Persistence.File -> createSqlDriver(DATABASE_NAME)
        }
    }
}

enum class Persistence {
    InMemory,
    File
}
