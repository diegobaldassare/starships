package edu.austral.starship.console.controller;

import edu.austral.starship.console.view.GameViewConsole;
import edu.austral.starship.model.Game;

/**
 * Created by Diego Baldassare on 2018-12-04.
 */
public class GameConsoleController {

    private Game model;
    private GameViewConsole view;

    public void setup() {
        model.setup();
    }

    public void update(float timeSinceLastDraw) {
        model.update(timeSinceLastDraw);
        view.draw(model);
    }
}
