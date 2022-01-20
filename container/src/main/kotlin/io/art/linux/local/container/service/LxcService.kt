package io.art.linux.local.container.service

import io.art.linux.local.container.graal.GraalLxc.lxc_get_version
import org.graalvm.nativeimage.c.type.CTypeConversion.toJavaString

object LxcService {
    fun version(): String = toJavaString(lxc_get_version())
}
