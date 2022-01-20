package io.art.linux.local.container.graal;

import io.art.linux.local.container.model.*;
import lombok.experimental.*;
import static io.art.linux.local.container.graal.GraalLxc.Directives.*;
import static org.graalvm.nativeimage.c.type.CTypeConversion.*;
import static org.graalvm.word.WordFactory.*;

@UtilityClass
public class GraalLxcProvider {
    public static String version() {
        return toJavaString(lxc_get_version());
    }

    public static String getGlobalConfiguration(String key) {
        try (CCharPointerHolder pin = toCString(key)) {
            return toJavaString(lxc_get_global_config_item(pin.get()));
        }
    }

    public static LxcContainer createLxcContainer(String name) {
        try (CCharPointerHolder pin = toCString(name)) {
            return new LxcContainer(lxc_container_new(pin.get(), nullPointer()));
        }
    }
}
