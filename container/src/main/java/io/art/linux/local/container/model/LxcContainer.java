package io.art.linux.local.container.model;

public class LxcContainer {
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
