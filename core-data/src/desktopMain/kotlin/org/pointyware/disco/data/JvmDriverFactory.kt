package org.pointyware.disco.data
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.pointyware.disco.local.DriverFactory

/**
 *
 */
class JvmDriverFactory : DriverFactory {
    override fun createSqlDriver(path: String): SqlDriver {
        return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY + path)
    }
}
