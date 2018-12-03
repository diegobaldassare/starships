package edu.austral.starship.model.builder.asteroids;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.view.AsteroidView;

/**
 * Builder Pattern optimized.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public abstract class AsteroidBuilder {

    Asteroid asteroid;
    private FromDirection last = FromDirection.TOP;

    AsteroidBuilder() {}

    public Asteroid getAsteroid() {
        return asteroid;
    }

    abstract void buildLife();
    abstract void buildRadius();
    abstract void buildSpeed();
    abstract void buildDamage();

    /**
     * Template Pattern
     */
    public void build() {
        buildLife();
        buildRadius();
        buildSpeed();
        buildDamage();
    }

    public Asteroid construct() {
        asteroid = new Asteroid();
        return asteroid;
    }

    public void sendFromNext() {
        switch (last) {
            case TOP: sendFromDown();
            break;

            case DOWN: sendFromRight();
            break;

            case RIGHT: sendFromLeft();
            break;

            case LEFT: sendFromTop();
            break;
        }
    }

    public void sendFromTop() {
        last = FromDirection.TOP;
        asteroid.setPosition(Vector2.vector((float) Math.random() * Constants.MAP_WIDTH,
                                            - asteroid.getHeight() - 1));
        asteroid.setDirection(Vector2.vector(0, 1).rotate((float) Math.random()));
    }

    public void sendFromDown() {
        last = FromDirection.DOWN;
        asteroid.setPosition(Vector2.vector((float) Math.random() * Constants.MAP_WIDTH,
                                            Constants.MAP_HEIGHT + asteroid.getHeight()+ 1));
        asteroid.setDirection(Vector2.vector(0, -1).rotate((float) Math.random()));
    }

    public void sendFromRight() {
        last = FromDirection.RIGHT;
        asteroid.setPosition(Vector2.vector(Constants.MAP_WIDTH + asteroid.getWidth() + 1,
                                            (float) Math.random() * Constants.MAP_HEIGHT));
        asteroid.setDirection(Vector2.vector(-1, 0).rotate((float) Math.random()));
    }

    public void sendFromLeft() {
        last = FromDirection.LEFT;
        asteroid.setPosition(Vector2.vector(- asteroid.getWidth() - 1,
                                            (float) Math.random() * Constants.MAP_HEIGHT));
        asteroid.setDirection(Vector2.vector(1, 0).rotate((float) Math.random()));
    }

    private enum FromDirection {
        TOP, DOWN, RIGHT, LEFT;
    }
}
