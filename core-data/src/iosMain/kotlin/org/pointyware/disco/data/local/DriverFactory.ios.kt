/*
 * Copyright (c) 2025 Pointyware. Use of this software is governed by the Apache 2.0 license. See project root for full text.
 */

package org.pointyware.disco.data.local

import app.cash.sqldelight.db.SqlDriver
import org.pointyware.disco.local.DriverFactory

class IosDriverFactory: DriverFactory {
    override fun createSqlDriver(path: String): SqlDriver {
        TODO("Not yet implemented")
    }
}
