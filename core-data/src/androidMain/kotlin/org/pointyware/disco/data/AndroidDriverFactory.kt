/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.pointyware.disco.data.hosts.db.HostDb
import org.pointyware.disco.local.DriverFactory

/**
 *
 */
class AndroidDriverFactory(private val context: Context): DriverFactory {
    override fun createSqlDriver(path: String): SqlDriver {
        return if (path.isEmpty()) {
            AndroidSqliteDriver(HostDb.Schema, context)
        } else {
            AndroidSqliteDriver(HostDb.Schema, context, path)
        }
    }
}
