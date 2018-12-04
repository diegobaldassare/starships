package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.console.controller.GameConsoleController;
import edu.austral.starship.controller.commands.CommandController;
import edu.austral.starship.controller.GameController;
import edu.austral.starship.model.configuration.PlayerConfiguration;
import edu.austral.starship.model.configuration.KeyConfiguration;
import edu.austral.starship.utils.Constants;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomGameFramework implements GameFramework {

    private final GameController gameController = new GameController();
    private final GameConsoleController gameConsoleController = new GameConsoleController();
    private final CommandController commandController = new CommandController();
    private final Map<Integer, Long> lastTimePressed = new HashMap<>();

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .fullScreen();
//            .setSize(5000, 5000);

        //Si cambio el orden se caga todoo
        PlayerConfiguration.loadPlayers(gameController, 1);
        gameController.setup(imageLoader);
//        gameConsoleController.setup();
        KeyConfiguration.loadCommands(gameController, commandController);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        keySet.forEach(commandController::invoke);
        gameController.update(graphics, timeSinceLastDraw);
//        gameConsoleController.update(timeSinceLastDraw);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        //unnecessary
    }

    @Override
    public void keyReleased(KeyEvent event) {
        //unnecessary
    }
}
