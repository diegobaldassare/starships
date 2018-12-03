package edu.austral.starship.view;

import edu.austral.starship.base.vector.Vector2;

import java.awt.*;

/**
 * Created by Diego Baldassare on 2018-10-28.
 */
public abstract class Shape2 implements Shape {

    private Vector2 center;

    public Vector2 getCenter() {
        return center;
    }

    public void setCenter(Vector2 center) {
        this.center = center;
    }
}
