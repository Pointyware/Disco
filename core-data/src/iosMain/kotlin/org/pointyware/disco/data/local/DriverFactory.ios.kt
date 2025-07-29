package org.pointyware.disco.data.local

import app.cash.sqldelight.db.SqlDriver
import org.pointyware.disco.local.DriverFactory

class IosDriverFactory: DriverFactory {
    override fun createSqlDriver(path: String): SqlDriver {
        TODO("Not yet implemented")
    }
}
