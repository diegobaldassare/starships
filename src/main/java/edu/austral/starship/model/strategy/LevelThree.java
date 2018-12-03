package edu.austral.starship.model.strategy;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.AsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.BigAsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.MediumAsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.SmallAsteroidBuilder;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class LevelThree extends Level {

    public LevelThree(Game game) {
        super(game, 3);
    }

    @Override
    public void start() {
        final AsteroidBuilder smallAsteroidBuilder = new SmallAsteroidBuilder();
        final AsteroidBuilder mediumAsteroidBuilder = new MediumAsteroidBuilder();
        final AsteroidBuilder bigAsteroidBuilder = new BigAsteroidBuilder();

        for (int i = 0; i < 5; i++) {
            game.getNewAsteroids().add(smallAsteroidBuilder.construct());
            smallAsteroidBuilder.build();
            smallAsteroidBuilder.sendFromNext();
        }

        for (int i = 0; i < 3; i++) {
            game.getNewAsteroids().add(mediumAsteroidBuilder.construct());
            mediumAsteroidBuilder.build();
            mediumAsteroidBuilder.sendFromNext();
        }

        for (int i = 0; i < 2; i++) {
            game.getNewAsteroids().add(bigAsteroidBuilder.construct());
            bigAsteroidBuilder.build();
            bigAsteroidBuilder.sendFromNext();
        }
    }

    @Override
    public void next() {
        game.end();
    }
}
