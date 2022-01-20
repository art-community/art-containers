package io.art.linux.local.container.graal

import io.art.core.graal.GraalSingleLibrary
import org.graalvm.nativeimage.c.CContext
import org.graalvm.nativeimage.c.function.CFunction

@CContext(GraalLxc.Directives::class)
object GraalLxc {
    class Directives : CContext.Directives {
        private val directive = GraalSingleLibrary.singleLibrary()
                .libraryFileName("lxc")
                .headerFileName("lxc")
                .build()
                .directive()
                .build()

        override fun getHeaderFiles(): MutableList<String> {
            return directive.headers
        }

        override fun getLibraries(): MutableList<String> {
            return directive.libraries
        }

        override fun getLibraryPaths(): MutableList<String> {
            return directive.libraryPaths
        }
    }

    @CFunction(value = "lxc_get_version")
    external fun lxc_get_version(): String
}
