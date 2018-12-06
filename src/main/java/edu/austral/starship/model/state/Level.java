package edu.austral.starship.model.state;

import edu.austral.starship.controller.LevelController;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.Asteroid;

import java.util.List;

/**
 * Strategy Pattern
 * All levels know its next() level and its start() algorithm.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public abstract class Level {

    protected Game game;
    protected LevelController controller;
    private final int levelNumber;

    Level(Game game, int levelNumber, LevelController controller) {
        this.game = game;
        this.levelNumber = levelNumber;
        this.controller = controller;
        start();
    }

    public abstract void start();
    public abstract void next();

    public int getLevelNumber() {
        return levelNumber;
    }

    void notifyLevelController(List<Asteroid> asteroids) {
        controller.updateAsteroids(asteroids);
    }

    public void addObserver(LevelController levelController) {
        controller = levelController;
    }
}
