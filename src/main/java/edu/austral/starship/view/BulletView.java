package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.GameObject;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;

/**
 * Created by Diego Baldassare on 2018-10-30.
 */
public class BulletView extends GameObjectView {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final Bullet model;
    private final String color;

    public BulletView(Bullet model, String color, PImage image) {
        this.model = model;
        this.color = color;
        this.image = image;
        this.image.resize(WIDTH, HEIGHT);
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        super.image = imageLoader.load(Constants.IMAGES_PATH + "bullet-" + color + ".png");
        super.image.resize(WIDTH, HEIGHT);
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
    public Shape getShape() {
        final Rectangle result =  new Rectangle(WIDTH, HEIGHT);
        result.x = (int) model.getPosition().getX();
        result.y = (int) model.getPosition().getY();
        return result;
    }
}
