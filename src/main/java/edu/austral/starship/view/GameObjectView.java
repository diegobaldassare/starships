package edu.austral.starship.view;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.model.GameObject;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;

/**
 * Created by Diego Baldassare on 2018-10-28.
 */
public abstract class GameObjectView extends View implements Collisionable<GameObjectView> {
    //<T extends GameObjectView<T>>


    protected Shape shape;
    protected PImage image;
//    protected final GameObject model;

//    GameObjectView(GameObject model) {
//        this.model = model;
//    }

    public abstract GameObject getModel();

    @Override
    public void draw(PGraphics graphics) {
        graphics.pushMatrix();
        graphics.translate(getModel().getPosition().getX(), getModel().getPosition().getY());
        graphics.rotate(getModel().getDirection().angle() + PConstants.PI / 2);
        graphics.imageMode(PConstants.CENTER);
        graphics.image(image, 0, 0);
        graphics.popMatrix();
    }
}
