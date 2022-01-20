package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.core.checker.TerminalChecker.terminalSupportColors
import io.art.core.context.Context.context
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.meta.MetaContainer
import io.art.linux.local.container.model.Configuration
import io.art.linux.local.container.registry.ART_VERSION
import io.art.linux.local.container.registry.LXC_VERSION
import io.art.logging.colorizer.AnsiColorizer
import io.art.logging.colorizer.AnsiColorizer.additional
import io.art.logging.colorizer.AnsiColorizer.success
import io.art.meta.kotlin.meta
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport
import io.art.yaml.kotlin.toYaml
import io.art.yaml.kotlin.yaml
import java.nio.file.Files.list
import kotlin.streams.asSequence

fun printOutput(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + success(message))
    else -> println("(art.local): $message")
}

fun printError(message: String) = when {
    terminalSupportColors() -> println(additional("(art.local): ") + AnsiColorizer.error(message))
    else -> println("(art.local): $message")
}

fun main(arguments: Array<String>) = activator(arguments) {
    meta(::MetaContainer)
    transport()
    scheduler()
    configurator()
    yaml()
    onLaunch {
        val input = context().configuration().arguments

        if (input.size() == 0) {
            printOutput("ART Version: $ART_VERSION")
            printOutput("LXC Version: $LXC_VERSION")
            printOutput("YAML: ${Configuration(ART_VERSION, LXC_VERSION).toYaml()}")
            return@onLaunch
        }

        if (input.size() == 1 && input[0] == "version") {
            printOutput("ART Version: $ART_VERSION")
            printOutput("LXC Version: $LXC_VERSION")
            printOutput("YAML: ${Configuration(ART_VERSION, LXC_VERSION).toYaml()}")
            return@onLaunch
        }

        if (input.size() == 1 && input[0] == "list") {
            printOutput(list(context().configuration().workingDirectory).asSequence().toList().toYaml())
            return@onLaunch
        }

        printError("Wrong arguments. Please go to: https://animego.org/ for some brains")
    }
    launch()
}
