package edu.austral.starship.view;

import edu.austral.starship.base.collision.Collisionable;
import edu.austral.starship.model.GameObject;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Diego Baldassare on 2018-10-28.
 */
public abstract class GameObjectView extends View implements Collisionable<GameObjectView> {
    //<T extends GameObjectView<T>>

//    protected final Shape shape;
    protected PImage image;
//    protected GameObject model;

//    GameObjectView() {
//        shape = initShape();
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

    /**
     * TODO: init shape must be done just once in the constructor.
     */
//    @Override
//    public Shape getShape() {
//        return initShape();
//    }

    protected Shape initShape() {
        final Path2D.Float path = new Path2D.Float();
        path.append(getRelativeShape(), false);
        return path;
    }

    private Shape getRelativeShape() {
        return new Rectangle2D.Float(
                getModel().getPosition().getX(),
                getModel().getPosition().getY(),
                getModel().getWidth(),
                getModel().getHeight());
    }
}
