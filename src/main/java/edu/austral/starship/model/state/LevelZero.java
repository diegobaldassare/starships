package edu.austral.starship.model.state;

import edu.austral.starship.controller.LevelController;
import edu.austral.starship.model.Game;

/**
 * Strategy Pattern
 *
 * Performs as the AsteroidBuilder Director as well.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public class LevelZero extends Level {

    public LevelZero(Game game, LevelController controller) {
        super(game, 0, controller);
    }

    @Override
    public void start() {
        //nothing
    }

    @Override
    public void next() {
        game.setLevel(new LevelOne(game, controller));
    }
}
