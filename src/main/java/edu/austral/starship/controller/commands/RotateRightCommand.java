package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Player;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class RotateRightCommand implements Command {

    private final Player player;

    public RotateRightCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.rotateRight();
    }
}
