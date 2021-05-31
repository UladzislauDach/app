package by.dach.app.model;

import java.util.Locale;

public enum BodyType {
    sedan,
    universal,
    truck;

    public static BodyType parseFromString(String str) {
        if (str == null) throw new IllegalArgumentException("Empty string in enum parser");
        return BodyType.valueOf(str.toLowerCase());
    }
}
