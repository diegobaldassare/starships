package edu.austral.starship.model.strategy;

import edu.austral.starship.model.Game;

/**
 * Strategy Pattern
 * All levels know its next() level and its start() algorithm.
 *
 * Created by Diego Baldassare on 2018-11-18.
 */
public abstract class Level {

    Game game;
    private final int levelNumber;

    Level(Game game, int levelNumber) {
        this.game = game;
        this.levelNumber = levelNumber;
        start();
    }

    public abstract void start();
    public abstract void next();

    public int getLevelNumber() {
        return levelNumber;
    }
}
