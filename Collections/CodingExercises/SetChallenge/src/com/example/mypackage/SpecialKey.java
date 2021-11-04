package com.example.mypackage;

import java.util.Objects;

public final class SpecialKey {
    // special key for Map, holding two fields
    private final String name;
    private final String bodyType;

    public SpecialKey(HeavenlyBody obj) {
        this.name = obj.getName();
        this.bodyType = obj.getBodyType();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        SpecialKey that = (SpecialKey) obj;

        return this.name.equals(that.name) && this.bodyType.equals(that.bodyType);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + bodyType.hashCode() +57;
    }
}
