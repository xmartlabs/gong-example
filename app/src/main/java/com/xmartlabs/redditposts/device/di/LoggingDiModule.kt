package com.xmartlabs.redditposts.device.di

import com.xmartlabs.redditposts.LoggerTools
import org.koin.core.module.Module

/**
 * Created by mirland on 25/04/20.
 */
object LoggingDiModule {
    val logging: Module = LoggerTools.provideKoinDebugModule()
}
