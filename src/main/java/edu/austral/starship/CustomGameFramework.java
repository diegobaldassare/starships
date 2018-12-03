package edu.austral.starship;

import edu.austral.starship.base.framework.GameFramework;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.base.framework.WindowSettings;
import edu.austral.starship.controller.commands.CommandController;
import edu.austral.starship.controller.GameController;
import edu.austral.starship.model.configuration.PlayerConfiguration;
import edu.austral.starship.model.configuration.KeyConfiguration;
import processing.core.PGraphics;
import processing.event.KeyEvent;

import java.util.HashSet;
import java.util.Set;

public class CustomGameFramework implements GameFramework {

    private Set<Integer> myKeySet = new HashSet<>();
    private final GameController gameController = new GameController();
    private final CommandController commandController = new CommandController();

    @Override
    public void setup(WindowSettings windowsSettings, ImageLoader imageLoader) {
        windowsSettings
                .fullScreen();
//            .setSize(5000, 5000);

        //Si cambio el orden se caga todoo
        PlayerConfiguration.loadPlayers(gameController, 1);
        gameController.setup(imageLoader);
        KeyConfiguration.loadCommands(gameController, commandController);
    }

    @Override
    public void draw(PGraphics graphics, float timeSinceLastDraw, Set<Integer> keySet) {
        keySet.addAll(myKeySet);
        keySet.forEach(commandController::invoke);
        gameController.update(graphics, timeSinceLastDraw);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        myKeySet.add(event.getKeyCode());
//        commandController.invoke(event.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent event) {
        myKeySet.remove(event.getKeyCode());
    }
}
