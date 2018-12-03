package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.view.configuration.AsteroidConfiguration;
import processing.core.PImage;

import java.awt.*;

/**
 * Created by Diego Baldassare on 2018-10-30.
 */
public class AsteroidView extends GameObjectView {

    private final String color;
    private final Asteroid model;

    public AsteroidView(Asteroid model, String color) {
//        super(model);
        this.model = model;
        this.color = color;
    }

    public AsteroidView(Asteroid model, String color, PImage image) {
        this.color = color;
        this.model = model;
        this.image = image;
        this.image.resize(model.getWidth(), model.getWidth());
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        super.image = imageLoader.load(Constants.IMAGES_PATH + "asteroid-" + color + ".png");
        super.image.resize(model.getWidth(), model.getHeight());
    }

    @Override
    public Shape getShape() {
        final Rectangle result =  new Rectangle(model.getWidth(), model.getHeight());
        result.x = (int) model.getPosition().getX();
        result.y = (int) model.getPosition().getY();
        return result;
    }

    @Override
    public void collisionedWith(GameObjectView collisionable) {
        collisionable.getModel().accept(model);
    }

    @Override
    public GameObject getModel() {
        return model;
    }
}
