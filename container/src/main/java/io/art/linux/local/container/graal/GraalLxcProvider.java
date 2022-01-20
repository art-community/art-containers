package io.art.linux.local.container.graal;

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
}
