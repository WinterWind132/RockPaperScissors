package org.core;

import java.util.Arrays;
import java.util.Optional;

public enum Field {
    ROCK("Камень"),
    PAPER("Бумага"),
    SCISSORS("Ножницы");

    private final String name;

    Field(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Optional<Field> fromString(String input) {
        String normalizedInput = input.trim().toLowerCase();

        return Arrays.stream(Field.values())
                .filter(field -> field.getName()
                        .toLowerCase()
                        .equals(normalizedInput))
                        .findFirst();
    }
}