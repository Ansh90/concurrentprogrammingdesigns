package com.misc.misc.immutable;

import java.util.Date;

public final class ImmutableClass {

    private final String name;
    private final int val;
    private final Date sysDate;

    public String getName() {
        return name;
    }

    public int getVal() {
        return val;
    }

    public Date getSysDate() {
        return new Date(sysDate.getTime());
    }

    public ImmutableClass(String name, int val, Date sysDate) {
        this.name = name;
        this.val = val;
        // not storing mutable objects directly into immutable class.
        this.sysDate = new Date(sysDate.getTime());
    }

}
