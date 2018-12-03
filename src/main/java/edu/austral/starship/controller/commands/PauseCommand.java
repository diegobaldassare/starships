package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Game;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class PauseCommand implements Command {

    private final Game game;

    public PauseCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.setPaused();
    }
}
