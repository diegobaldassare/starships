package edu.austral.starship.view.configuration;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.utils.Constants;
import processing.core.PImage;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class AsteroidConfiguration {

    private PImage asteroidImage;


    public void setup(ImageLoader imageLoader) {
        asteroidImage = imageLoader.load(Constants.RESOURCES_PATH + "/images/asteroid-brown.png");
    }

    public PImage getAsteroidImage() {
        return asteroidImage;
    }
}
