package edu.austral.starship.controller.commands;

import edu.austral.starship.model.Player;
import edu.austral.starship.model.Starship;
import edu.austral.starship.utils.Constants;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class ChangeWeaponCommand implements Command {

    private final Player player;
    private long lastTimeExecuted = 0;

    public ChangeWeaponCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        if (System.currentTimeMillis() - lastTimeExecuted > Constants.DEBOUNCE_TIME) {
            lastTimeExecuted = System.currentTimeMillis();
            Starship starship = (Starship) player.getManageableObject();
            starship.setCurrent(starship.getCurrent().getNext());
        }
    }
}
