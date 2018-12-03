package edu.austral.starship.view.configuration;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.view.View;
import processing.core.PGraphics;
import processing.core.PImage;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class AsteroidConfiguration {

    private PImage asteroidImage;


    public void setup(ImageLoader imageLoader) {
        asteroidImage = imageLoader.load(Constants.IMAGES_PATH + "asteroid-brown.png");
    }

    public PImage getAsteroidImage() {
        return asteroidImage;
    }
}
