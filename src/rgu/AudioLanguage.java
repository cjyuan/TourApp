/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;

/**
 * Creates AudioLanguage enum file to be referenced in Tourist Interface
 * application
 *
 * @author astel-14/12/2020
 */
public enum AudioLanguage {
    ENGLISH("English"),
    SPANISH("Spanish"),
    FRENCH("French"),
    RUSSIAN("Russian");

    private final String displayName;

    AudioLanguage(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

