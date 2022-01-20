package io.art.linux.local.container.service

import io.art.linux.local.container.graal.GraalLxc.lxc_get_global_config_item
import io.art.linux.local.container.graal.GraalLxc.lxc_get_version
import org.graalvm.nativeimage.c.type.CTypeConversion.toCString
import org.graalvm.nativeimage.c.type.CTypeConversion.toJavaString

object LxcService {
    fun version(): String = toJavaString(lxc_get_version())

    fun configuration() = Configuration

    object Configuration {
        operator fun get(key: String): String {
            toCString(key).use { pin ->
                val pinValue = pin.get()
                val itemValue = lxc_get_global_config_item(pinValue)
                return toJavaString(itemValue)
            }
        }
    }
}
