package edu.austral.starship.model.configuration;

import edu.austral.starship.controller.GameController;
import edu.austral.starship.model.Player;
import edu.austral.starship.model.Starship;

/**
 * Initiates and saves in memory the key configurations.
 *
 * Created by Diego Baldassare on 2018-10-31.
 */
public class PlayerConfiguration {

    public static void loadPlayers(GameController gameController, int quantity) {
        final Player player1 = new Player("Diego");
        final Player player2 = new Player("Brian");
        final Player player3 = new Player("Tomas");
        final Player player4 = new Player("Pedro");
        final Player player5 = new Player("Pato");


        player1.setManageableObject(new Starship());
        player2.setManageableObject(new Starship());
        player3.setManageableObject(new Starship());
        player4.setManageableObject(new Starship());
        player5.setManageableObject(new Starship());
        player1.setScore(102);

        gameController.getModel().getPlayers().add(player1);
        if (quantity > 2) {
            gameController.getModel().getPlayers().add(player2);
            if (quantity > 3) {
                gameController.getModel().getPlayers().add(player3);
                if (quantity > 4) {
                    gameController.getModel().getPlayers().add(player4);
                    if (quantity > 5) {
                        gameController.getModel().getPlayers().add(player5);
                    }
                }
            }
        }
    }
}
