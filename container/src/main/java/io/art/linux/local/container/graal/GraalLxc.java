package io.art.linux.local.container.graal;

import io.art.core.graal.*;
import org.graalvm.nativeimage.c.*;
import org.graalvm.nativeimage.c.function.*;
import org.graalvm.nativeimage.c.type.*;
import static io.art.core.graal.GraalSingleLibrary.*;
import java.util.*;

@CContext(GraalLxc.Directives.class)
public class GraalLxc {
    public static final class Directives implements CContext.Directives {
        private final GraalNativeDirective directive = singleLibrary()
                .libraryFileName("lxc")
                .headerFileName("lxc")
                .build()
                .directive()
                .build();

        public List<String> getHeaderFiles() {
            return directive.getHeaders();
        }

        public List<String> getLibraries() {
            List<String> libraries = directive.getLibraries();
            libraries.add("ssl");
            libraries.add("crypto");
            libraries.add("selinux");
            libraries.add("util");
            return libraries;
        }

        public List<String> getLibraryPaths() {
            return directive.getLibraryPaths();
        }

        @CFunction(value = "lxc_get_version")
        public static native CCharPointer lxc_get_version();

        @CFunction(value = "lxc_get_global_config_item")
        public static native CCharPointer lxc_get_global_config_item(CCharPointer key);
    }
}
