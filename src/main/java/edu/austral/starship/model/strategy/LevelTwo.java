package edu.austral.starship.model.strategy;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.AsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.MediumAsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.SmallAsteroidBuilder;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class LevelTwo extends Level {

    public LevelTwo(Game game) {
        super(game, 2);
    }

    @Override
    public void start() {
        final AsteroidBuilder asteroidBuilder = new MediumAsteroidBuilder();

        for (int i = 0; i < 3; i++) {
            game.getNewAsteroids().add(asteroidBuilder.construct());
            asteroidBuilder.build();
            asteroidBuilder.sendFromNext();
        }
    }

    @Override
    public void next() {
        game.setLevel(new LevelThree(game));
    }
}
