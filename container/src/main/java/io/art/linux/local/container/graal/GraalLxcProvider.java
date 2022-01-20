package io.art.linux.local.container.graal;

import org.graalvm.word.*;
import static io.art.linux.local.container.graal.GraalLxc.Directives.*;
import static org.graalvm.nativeimage.c.type.CTypeConversion.*;

public class GraalLxcProvider {
    public static String version() {
        return toJavaString(lxc_get_version());
    }

    public static String getGlobalConfiguration(String key) {
        try (CCharPointerHolder pin = toCString(key)) {
            return toJavaString(lxc_get_global_config_item(pin.get()));
        }
    }


    public static class LxcContainer {
        private final String name;
        private final lxc_container owner;

        public LxcContainer(String name) {
            this.name = name;
            try (CCharPointerHolder pin = toCString(name)) {
                this.owner = lxc_container_new(pin.get(), WordFactory.nullPointer());
            }
        }

        public LxcContainer(lxc_container owner) {
            this.name = toJavaString(owner.name());
            this.owner = owner;
        }

        public boolean defined() {
            return owner.is_defined().is_defined(owner);
        }

        public String name() {
            return name;
        }
    }
}
