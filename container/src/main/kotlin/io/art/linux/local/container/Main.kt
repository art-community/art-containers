package io.art.linux.local.container

import io.art.configurator.kotlin.configurator
import io.art.launcher.kotlin.activator
import io.art.linux.local.container.graal.GraalLxc.lxc_get_version
import io.art.logging.kotlin.logger
import io.art.logging.kotlin.logging
import io.art.scheduler.kotlin.scheduler
import io.art.transport.kotlin.transport
import org.graalvm.nativeimage.c.type.CTypeConversion.toJavaString

fun main() = activator {
    logging()
    transport()
    scheduler()
    configurator()
    onLaunch {
        logger { info("Hello, ART with lxc: ${toJavaString(lxc_get_version())}") }
    }
    launch()
}
