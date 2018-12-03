package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Player;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class ShootCommand implements Command {

    private final Player player;

    public ShootCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.shoot();
    }
}
