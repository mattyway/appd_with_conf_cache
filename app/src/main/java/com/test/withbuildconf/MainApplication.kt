package com.test.withbuildconf

import android.app.Application
import android.util.Log
import com.appdynamics.eumagent.runtime.AgentConfiguration
import com.appdynamics.eumagent.runtime.Instrumentation


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val agentConfiguration = AgentConfiguration.builder()
            .withContext(this)
            .withScreenshotsEnabled(false)
            .withLoggingLevel(Instrumentation.LOGGING_LEVEL_VERBOSE)
            .withJSAgentInjectionEnabled(false)
            .withAppKey(APPD_API_KEY)
            .withCollectorURL(APPD_COLLECTOR_URL)
            .withCompileTimeInstrumentationCheck(false)
            .build()
        Instrumentation.start(agentConfiguration)
        Log.d("AppD Test", "Application onCreate, AppD initialised and started")
    }

    companion object {
        const val APPD_COLLECTOR_URL = "<REPLACEME>"
        const val APPD_API_KEY = "<REPLACEME>"

    }

}