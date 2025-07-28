package org.pointyware.disco

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.pointyware.disco.shared.di.sharedModule

/**
 * Disco-specific implementation of the Android Application class.
 *
 * Start-up tasks:
 * - Initialize Koin with application context
 */
class DiscoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DiscoApplication)
            modules(sharedModule())
        }
    }
}
