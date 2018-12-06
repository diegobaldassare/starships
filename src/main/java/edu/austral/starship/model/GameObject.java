package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.visitor.Visitable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public abstract class GameObject extends Model implements Visitable {

    //hacer final y sacar protected (momentaneamente por asteroids)
    protected int width;
    protected int height;

    private int life;
    private Vector2 position;
    private Vector2 direction;
    private float speed;

    // momentaneamente por asteroid builder
    public GameObject() {}

    public GameObject(int width, int height, int life, Vector2 position) {
        this.width = width;
        this.height = height;
        this.life = life;
        this.position = position;

        // The y coordinate y is negative because processing system of coordinates
        // start at the up-left corner of the screen and increase downwards.
//        this.direction = Vector2.vector(0, -1);
        if (direction == null) this.direction = Vector2.vector(0, 0);
    }

//    public GameObject(int life, Vector2 position) {
//        this.life = life;
//        this.position = position;
//        /*
//         * The y coordinate y is negative because processing system of coordinates
//         * start at the up-left corner of the screen and increase downwards.
//         */
//        this.direction = Vector2.vector(0, -1);
//    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public Vector2 getDirection() {
        return direction;
    }
    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }
    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void accelerate() {
        position =  position.add(direction.multiply(speed));
    }

    public void rotate(float angle) {
        direction = direction.rotate(angle);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}