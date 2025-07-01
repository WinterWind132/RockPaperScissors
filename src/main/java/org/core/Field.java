package org.core;

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
}