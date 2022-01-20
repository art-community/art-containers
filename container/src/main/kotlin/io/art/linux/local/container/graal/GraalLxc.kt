package io.art.linux.local.container.graal

import io.art.core.graal.GraalSingleLibrary
import org.graalvm.nativeimage.c.CContext
import org.graalvm.nativeimage.c.function.CFunction
import org.graalvm.nativeimage.c.type.CCharPointer

@CContext(GraalLxc.Directives::class)
object GraalLxc {
    class Directives : CContext.Directives {
        private val directive = GraalSingleLibrary.singleLibrary()
                .libraryFileName("lxc")
                .headerFileName("lxc")
                .build()
                .directive()
                .build()

        override fun getHeaderFiles(): MutableList<String> = directive.headers

        override fun getLibraries(): MutableList<String> = directive.libraries.toMutableList().apply {
            add("ssl")
            add("crypto")
            add("selinux")
            add("util")
        }

        override fun getLibraryPaths(): MutableList<String> = directive.libraryPaths.toMutableList()
    }

    @CFunction(value = "lxc_get_version")
    external fun lxc_get_version(): CCharPointer

    @CFunction(value = "lxc_get_global_config_item")
    external fun lxc_get_global_config_item(key: CCharPointer): CCharPointer
}
