package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.utils.Constants;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.GameObject;
import processing.core.PGraphics;
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
        super.image = imageLoader.load(Constants.RESOURCES_PATH + "/images/asteroid-" + color + ".png");
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

    @Override
    public void draw(PGraphics graphics) {
        super.draw(graphics);

//        graphics.fill(50, 205, 50);
//        final Vector2 v = getModel().getPosition().add(Vector2.vector(
//                - (float) Math.cos(getModel().getDirection().angle()) * model.getWidth(),
//                - (float) Math.sin(getModel().getDirection().angle()) * model.getHeight()));
//        graphics.rect(v.getX(),v.getY(), getModel().getLife() / getModel().getLife() * 50,10);
//        graphics.noFill();
    }
}
