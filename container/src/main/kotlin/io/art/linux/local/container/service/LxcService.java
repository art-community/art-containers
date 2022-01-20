package io.art.linux.local.container.service;

import static io.art.linux.local.container.graal.GraalLxc.*;
import static org.graalvm.nativeimage.c.type.CTypeConversion.*;

public class LxcService {
    public static String version() {
        return toJavaString(INSTANCE.lxc_get_version());
    }

    public static String getGlobalConfiguration(String key) {
        try (CCharPointerHolder pin = toCString(key)) {
            return toJavaString(INSTANCE.lxc_get_global_config_item(pin.get()));
        }
    }
}
