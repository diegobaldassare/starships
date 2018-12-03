package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Player;
import edu.austral.starship.model.Starship;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class ChangeWeaponCommand implements Command {

    private final Player player;

    public ChangeWeaponCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        Starship starship = (Starship) player.getManageableObject();
        starship.setCurrent(starship.getCurrent().getNext());
    }
}
