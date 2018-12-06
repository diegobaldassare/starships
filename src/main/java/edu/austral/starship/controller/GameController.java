package edu.austral.starship.controller;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.view.GameView;
import processing.core.PGraphics;

import java.util.List;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class GameController extends Controller {

    private final Game model;
    private final GameView view;

    public GameController() {
        this.model = new Game();
        this.view = new GameView(model);
        new LevelController(model, view);
        new ShooterController(model, view);
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        model.setup();
        view.setup(imageLoader);
    }

    @Override
    public void update(PGraphics graphics, float timeSinceLastDraw) {
        model.update(timeSinceLastDraw);
        view.draw(graphics);
    }

    public Game getModel() {
        return model;
    }
}
