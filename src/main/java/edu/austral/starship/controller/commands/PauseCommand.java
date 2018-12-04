package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Game;
import edu.austral.starship.utils.Constants;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class PauseCommand implements Command {

    private final Game game;
    private long lastTimeExecuted = 0;

    public PauseCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        if (System.currentTimeMillis() - lastTimeExecuted > Constants.DEBOUNCE_TIME) {
            lastTimeExecuted = System.currentTimeMillis();
            game.setPaused();
        }
    }
}
