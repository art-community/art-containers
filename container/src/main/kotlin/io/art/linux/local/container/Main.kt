package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.core.checker.TerminalChecker.terminalSupportColors
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.graal.GraalLxcProvider
import io.art.linux.local.container.graal.GraalLxcProvider.LxcContainer
import io.art.linux.local.container.graal.GraalLxcProvider.getGlobalConfiguration
import io.art.logging.colorizer.AnsiColorizer
import io.art.logging.colorizer.AnsiColorizer.additional
import io.art.logging.colorizer.AnsiColorizer.success
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport

fun log(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + success(message))
    else -> println("(art.local): $message")
}

fun error(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + AnsiColorizer.error(message))
    else -> println("(art.local): $message")
}

fun main() = activator {
    transport()
    scheduler()
    configurator()
    onLaunch {
        log("Hello, ART with lxc: ${GraalLxcProvider.version()}")
        log("LXC Value: ${getGlobalConfiguration("lxc.lxcpath")}")
        log("LXC Container with name connect.local defined: ${LxcContainer("connect.local").defined()}")
    }
    launch()
}
