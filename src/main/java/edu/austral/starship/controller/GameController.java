package edu.austral.starship.controller;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.view.GameView;
import processing.core.PGraphics;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class GameController extends Controller {

    private Game model;
    private GameView view;

    public GameController() {
        this.model = new Game();
        this.view = new GameView(model);
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

        for (GameObject o: model.getGameObjects()) {

        }





        final CollisionEngine collisionEngine = new CollisionEngine();

        // noinspection unchecked
        collisionEngine.checkCollisions(view.getGameObjectViews());
    }

    public Game getModel() {
        return model;
    }
}
