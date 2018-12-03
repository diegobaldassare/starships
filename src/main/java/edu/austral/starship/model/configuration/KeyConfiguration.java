package edu.austral.starship.model.configuration;

import edu.austral.starship.controller.GameController;
import edu.austral.starship.controller.commands.*;
import edu.austral.starship.model.Player;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Initiates and saves in memory the key configurations.
 *
 * Created by Diego Baldassare on 2018-10-31.
 */
public class KeyConfiguration {

    public static void loadCommands(GameController gameController, CommandController commandController) {
        final List<Player> players = gameController.getGame().getPlayers();
        final int n = players.size();

        //Player 1
        commandController.addCommand(KeyEvent.VK_UP, new MoveForwardCommand(players.get(0)));
        commandController.addCommand(KeyEvent.VK_DOWN, new ChangeWeaponCommand((players.get(0))));
        commandController.addCommand(KeyEvent.VK_RIGHT, new RotateRightCommand(players.get(0)));
        commandController.addCommand(KeyEvent.VK_LEFT, new RotateLeftCommand(players.get(0)));
        commandController.addCommand(KeyEvent.VK_ENTER, new ShootCommand(players.get(0)));

        if (n > 1) {
            //Player 2
            commandController.addCommand(KeyEvent.VK_2, new MoveForwardCommand(players.get(1)));
            commandController.addCommand(KeyEvent.VK_A, new ChangeWeaponCommand(players.get(1)));
            commandController.addCommand(KeyEvent.VK_3, new RotateRightCommand(players.get(1)));
            commandController.addCommand(KeyEvent.VK_1, new RotateLeftCommand(players.get(1)));
            commandController.addCommand(KeyEvent.VK_TAB, new ShootCommand(players.get(1)));

            if (n > 2) {
                //Player 3
                commandController.addCommand(KeyEvent.VK_8, new RotateLeftCommand(players.get(2)));
                commandController.addCommand(KeyEvent.VK_MINUS, new ChangeWeaponCommand(players.get(2)));
                commandController.addCommand(KeyEvent.VK_9, new MoveForwardCommand(players.get(2)));
                commandController.addCommand(KeyEvent.VK_0, new RotateRightCommand(players.get(2)));
                commandController.addCommand(KeyEvent.VK_DELETE, new ShootCommand(players.get(2)));

                if (n > 3) {
                    //Player 4
                    commandController.addCommand(KeyEvent.VK_4, new RotateLeftCommand(players.get(3)));
                    commandController.addCommand(KeyEvent.VK_5, new MoveForwardCommand(players.get(3)));
                    commandController.addCommand(KeyEvent.VK_6, new RotateRightCommand(players.get(3)));
                    commandController.addCommand(KeyEvent.VK_7, new ShootCommand(players.get(3)));

                    if (n > 4) {
                        //Player 5
                        commandController.addCommand(KeyEvent.VK_Z, new RotateLeftCommand(players.get(3)));
                        commandController.addCommand(KeyEvent.VK_X, new MoveForwardCommand(players.get(3)));
                        commandController.addCommand(KeyEvent.VK_C, new RotateRightCommand(players.get(3)));
                        commandController.addCommand(KeyEvent.VK_SHIFT, new ShootCommand(players.get(3)));
                    }
                }
            }
        }

        commandController.addCommand(KeyEvent.VK_SPACE, new PauseCommand(gameController.getGame()));
    }
}
