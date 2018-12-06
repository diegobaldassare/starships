package edu.austral.starship.model.state;

import edu.austral.starship.controller.LevelController;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.asteroids.AsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.SmallAsteroidBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Strategy Pattern
 *
 * Performs as the AsteroidBuilder Director as well.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public class LevelOne extends Level {

    public LevelOne(Game game, LevelController controller) {
        super(game, 1, controller);
    }

    @Override
    public void start() {
        final AsteroidBuilder asteroidBuilder = new SmallAsteroidBuilder();
        final List<Asteroid> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            result.add(asteroidBuilder.construct());
            asteroidBuilder.build();
            asteroidBuilder.sendFromNext();
        }
        notifyLevelController(result);
    }

    @Override
    public void next() {
        game.setLevel(new LevelTwo(game, controller));
    }
}
