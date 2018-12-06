package edu.austral.starship.model.state;

import edu.austral.starship.controller.LevelController;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class LevelThree extends Level {

    public LevelThree(Game game, LevelController controller) {
        super(game, 3, controller);
    }

    @Override
    public void start() {
//        final AsteroidBuilder smallAsteroidBuilder = new SmallAsteroidBuilder();
        final AsteroidBuilder mediumAsteroidBuilder = new MediumAsteroidBuilder();
//        final AsteroidBuilder bigAsteroidBuilder = new BigAsteroidBuilder();
        final List<Asteroid> result = new ArrayList<>();

//        for (int i = 0; i < 15; i++) {
//            result.add(smallAsteroidBuilder.construct());
//            smallAsteroidBuilder.build();
//            smallAsteroidBuilder.sendFromNext();
//        }

        for (int i = 0; i < 10; i++) {
            result.add(mediumAsteroidBuilder.construct());
            mediumAsteroidBuilder.build();
            mediumAsteroidBuilder.sendFromNext();
        }

//        for (int i = 0; i < 3; i++) {
//            result.add(bigAsteroidBuilder.construct());
//            bigAsteroidBuilder.build();
//            bigAsteroidBuilder.sendFromNext();
//        }
        notifyLevelController(result);
    }

    @Override
    public void next() {
        game.end();
    }
}
