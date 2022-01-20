package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.core.checker.TerminalChecker.terminalSupportColors
import io.art.core.context.Context.context
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.graal.GraalLxcProvider.version
import io.art.logging.colorizer.AnsiColorizer
import io.art.logging.colorizer.AnsiColorizer.additional
import io.art.logging.colorizer.AnsiColorizer.success
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport

fun printOutput(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + success(message))
    else -> println("(art.local): $message")
}

fun printError(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + AnsiColorizer.error(message))
    else -> println("(art.local): $message")
}

fun main(arguments: Array<String>) = activator(arguments) {
    transport()
    scheduler()
    configurator()
    onLaunch {
        val arguments = context().configuration().arguments

        if (arguments.size() == 0) {
            printOutput("ART Version: main")
            printOutput("LXC Version: ${version()}")
            return@onLaunch
        }

        if (arguments.size() == 1 && arguments[0] == "version") {
            printOutput("ART Version: main")
            printOutput("LXC Version: ${version()}")
            return@onLaunch
        }

        printError("Wrong arguments count. Please go to: https://animego.org/ for some brains")
    }
    launch()
}
