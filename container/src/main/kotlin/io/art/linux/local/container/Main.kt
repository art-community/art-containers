package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.graal.GraalLxcProvider
import io.art.linux.local.container.graal.GraalLxcProvider.getGlobalConfiguration
import io.art.logging.kotlin.logger
import io.art.logging.kotlin.logging
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport

fun main() = activator {
    logging()
    transport()
    scheduler()
    configurator()
    silent(true)
    onLaunch {
        logger {
            info("Hello, ART with lxc: ${GraalLxcProvider.version()}")
            info("LXC Value: ${getGlobalConfiguration("lxc.lxcpath")}")
        }
    }
    launch()
}
