package edu.austral.starship.model.state;

import edu.austral.starship.controller.LevelController;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.asteroids.AsteroidBuilder;
import edu.austral.starship.model.builder.asteroids.MediumAsteroidBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class LevelTwo extends Level {

    public LevelTwo(Game game, LevelController controller) {
        super(game, 2, controller);
    }

    @Override
    public void start() {
        final AsteroidBuilder asteroidBuilder = new MediumAsteroidBuilder();
        final List<Asteroid> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            result.add(asteroidBuilder.construct());
            asteroidBuilder.build();
            asteroidBuilder.sendFromNext();
        }
        notifyLevelController(result);
    }

    @Override
    public void next() {
        game.setLevel(new LevelThree(game, controller));
    }
}
