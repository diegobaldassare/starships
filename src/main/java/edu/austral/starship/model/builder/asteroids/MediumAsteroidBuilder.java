package edu.austral.starship.model.builder.asteroids;

/**
 * Created by Diego Baldassare on 2018-11-19.
 */
public class MediumAsteroidBuilder extends AsteroidBuilder {

    @Override
    public void buildLife() {
        asteroid.setLife(5);
    }

    @Override
    public void buildRadius() {
        asteroid.setRadius(5);
    }

    @Override
    public void buildSpeed() {
        asteroid.setSpeed(7);
    }

    @Override
    public void buildDamage() {
        asteroid.setDamage(5);
    }
}
