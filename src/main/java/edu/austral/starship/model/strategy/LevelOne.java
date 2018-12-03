package edu.austral.starship.model.strategy;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.AsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.SmallAsteroidBuilder;

/**
 * Strategy Pattern
 *
 * Performs as the AsteroidBuilder Director as well.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public class LevelOne extends Level {

    public LevelOne(Game game) {
        super(game, 1);
    }

    @Override
    public void start() {
        final AsteroidBuilder asteroidBuilder = new SmallAsteroidBuilder();

        for (int i = 0; i < 1; i++) {
            game.getNewAsteroids().add(asteroidBuilder.construct());
            asteroidBuilder.build();
            asteroidBuilder.sendFromNext();
        }
    }

    @Override
    public void next() {
        game.setLevel(new LevelTwo(game));
    }
}
