package edu.austral.starship.console.view;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.Starship;

/**
 * Created by Diego Baldassare on 2018-12-04.
 */
public class GameViewConsole {



    public void draw(Game model) {
        if (model.isEnded()) System.out.println("Game over");
        if (model.isPaused()) System.out.println("model.isPaused() = " + model.isPaused());
        for (Starship s : model.getStarships()) {
//            .draw(s);
        }
    }
}
