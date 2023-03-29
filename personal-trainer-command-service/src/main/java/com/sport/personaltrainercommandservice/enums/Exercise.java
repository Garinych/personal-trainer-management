package com.sport.personaltrainercommandservice.enums;

public enum Exercise {

    SQUATTING("Squatting"),
    PUSH_UP("Push-up"),
    PLANK("Plank");

    private final String description;

    Exercise(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
