/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rgu;


/**
 * Creates Tourist class that is composed of name, country, the preferred
 * language
 *
 * @author astel - 13/12/220
 */
public class Tourist {

    private String name;
    private String country;
    private AudioLanguage audioLanguage;

 

    public Tourist(String name, String country, AudioLanguage audioLanguage) {
        this.name = name;
        this.country = country;
        this.audioLanguage = audioLanguage;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    /**
     * Creates public methods to retrieve the the data
     *
     * @author astel/13/12/220
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public AudioLanguage getAudioLanguage() {
        return audioLanguage;
    }

    public void setAudioLanguage(AudioLanguage audioLanguage) {
        this.audioLanguage = audioLanguage;
    }
    
    

    @Override
    public String toString() {
        return name + " from " + country + " preferred language is " + audioLanguage;
    }
}
