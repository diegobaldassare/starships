package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.model.Starship;
import processing.core.PGraphics;

import java.awt.*;

/**
 * Created by Diego Baldassare on 2018-10-25.
 */
public class StarshipView extends GameObjectView {

    private static final int WIDTH = 92;
    private static final int HEIGHT = 81;

    private final String color;
    private Starship model;

    public StarshipView(Starship model, String color) {
//        super(model);
        this.model = model;
        this.color = color;
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        super.image = imageLoader.load(Constants.IMAGES_PATH + "starship-" + color + ".png");
        super.image.resize(WIDTH, HEIGHT);
    }

//    @Override
//    public void collisionedWith(GameObjectView collisionable) {
//        collisionable.model.damage((Starship) model);
//    }

//    @Override
//    public void collisionedWith(GameObjectView<Starship> collisionable) {
//        collisionable.model.damage(model);
//    }

//    @Override
//    public void collisionedWith(Harmful collisionable) {
//        collisionable.damage(model);
//    }


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

    @Override
    public void draw(PGraphics graphics) {
        super.draw(graphics);
        graphics.text("Life: " + model.getLife(), model.getPosition().getX(), model.getPosition().getY() + model.getHeight() + 1);
    }
}
