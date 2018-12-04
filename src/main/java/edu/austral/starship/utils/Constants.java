package edu.austral.starship.utils;

/**
 * General constants.
 * Can't be specific things such as velocity or initial life.
 * Must be generic things such as velocity factor
 * (if the velocity defined in every class is too low,
 * then everything is multiplied by this factor).
 * Another example may be the gravity factor.
 *
 * Created by Diego Baldassare on 2018-10-29.
 */
public class Constants {

    //Hardcoded values
    public static final int MAP_WIDTH = 1680;
    public static final int MAP_HEIGHT= 1050;

    public static final String RESOURCES_PATH = "/Users/diegobaldassare/projects/starships/src/main/resources";

    public static final long DEBOUNCE_TIME = 500;
}
