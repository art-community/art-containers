package io.art.linux.local.container.model;

import lombok.*;
import lombok.experimental.*;
import static io.art.linux.local.container.graal.GraalLxc.Directives.*;
import static org.graalvm.nativeimage.c.type.CTypeConversion.*;

public class LxcContainer {
    @Getter
    @Accessors(fluent = true)
    private final String name;
    private final lxc_container owner;

    public LxcContainer(lxc_container owner) {
        this.name = toJavaString(owner.name());
        this.owner = owner;
    }

    public boolean defined() {
        return owner.is_defined().invoke(owner);
    }
}
