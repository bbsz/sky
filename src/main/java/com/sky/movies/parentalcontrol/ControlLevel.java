package com.sky.movies.parentalcontrol;

import java.util.stream.Stream;

public enum ControlLevel {
    U("U"), PG("PG"), AGE_12("12"), AGE_15("15"), AGE_18("18");

    private String value;

    private ControlLevel(String value) {
        this.value = value;
    }

    public static ControlLevel resolve(String controlLevel) {
        return Stream.of(ControlLevel.values()).filter(cl -> cl.value.equals(controlLevel)).findFirst().orElse(null);
    }

    public boolean canWatch(ControlLevel controlLevel) {
        return this.ordinal() >= controlLevel.ordinal();
    }
}
