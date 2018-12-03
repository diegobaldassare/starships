package edu.austral.starship.model.builder.asteroids;

/**
 * Created by Diego Baldassare on 2018-11-19.
 */
public class BigAsteroidBuilder extends AsteroidBuilder {

    @Override
    public void buildLife() {
        asteroid.setLife(10);
    }

    @Override
    public void buildRadius() {
        asteroid.setRadius(10);
    }

    @Override
    public void buildSpeed() {
        asteroid.setSpeed(2);
    }

    @Override
    public void buildDamage() {
        asteroid.setDamage(10);
    }
}
