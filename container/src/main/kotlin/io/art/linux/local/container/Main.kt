package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.service.LxcService
import io.art.linux.local.container.service.LxcService.getGlobalConfiguration
import io.art.logging.kotlin.logger
import io.art.logging.kotlin.logging
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport

fun main() = activator {
    logging()
    transport()
    scheduler()
    configurator()
    silent()
    onLaunch {
        logger {
            info("Hello, ART with lxc: ${LxcService.version()}")
            info("LXC Value: ${getGlobalConfiguration("lxc.net.0.link")}")
        }
    }
    launch()
}
