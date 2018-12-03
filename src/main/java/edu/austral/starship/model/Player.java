package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.builder.asteroids.Asteroid;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class Player extends Shooter {

    private static final float ROTATION_SPEED = 0.05f;
    private int score;
    private ManageableObject starship;
    private final String name;
    private final static int STARSHIP_POINTS = 50;
    private final static int ASTEROID_POINTS = 100;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void shoot() {
        starship.action(this);
    }

    @Override
    public void hitted(Starship target) {
        score += STARSHIP_POINTS;
    }

    @Override
    public void hitted(Asteroid target) {
        score += ASTEROID_POINTS;
    }

    @Override
    public Vector2 getPosition() {
        return starship.getPosition();
    }

    @Override
    public Vector2 getDirection() {
        return starship.getDirection();
    }

    @Override
    public int getWidth() {
        return starship.getWidth();
    }

    @Override
    public int getHeight() {
        return starship.getHeight();
    }

    public void moveForwards() {
        starship.accelerate();
    }
    public void rotateRight() {
        starship.rotate(ROTATION_SPEED);
    }
    public void rotateLeft() {
        starship.rotate(- ROTATION_SPEED);
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public ManageableObject getManageableObject() {
        return starship;
    }

    public void setManageableObject(ManageableObject movable) {
        this.starship = movable;
    }

    @Override
    public void setup() {
    }

    @Override
    public void update(float timeSinceLastDraw) {

    }


//    @Override
//    public void moveUp() {
//        this.position = position.substract(Vector2.vector(0, VELOCITY));
//    }
//
//    @Override
//    public void moveDown() {
//        setPosition(getPosition().add(Vector2.vector(0, VELOCITY)));
//    }
//
//    @Override
//    public void rotateRight() {
//        setPosition(getPosition().add(Vector2.vector(VELOCITY, 0)));
//    }
//
//    @Override
//    public void rotateLeft() {
//        setPosition(getPosition().substract(Vector2.vector(VELOCITY, 0)));
//    }




}
