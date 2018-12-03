package edu.austral.starship.controller;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.Player;
import edu.austral.starship.model.Starship;
import edu.austral.starship.view.GameView;
import processing.core.PGraphics;

import java.util.List;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class GameController extends Controller {

    private Game game;
    private GameView gameView;

    public GameController() {
        this.game = new Game();
        this.gameView = new GameView(game);
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        game.setup();
        gameView.setup(imageLoader);
    }

    @Override
    public void update(PGraphics graphics, float timeSinceLastDraw) {
        game.update(timeSinceLastDraw);
        gameView.draw(graphics);







        final CollisionEngine collisionEngine = new CollisionEngine();

        // noinspection unchecked
        collisionEngine.checkCollisions(gameView.getGameObjectViews());
    }

    public Game getGame() {
        return game;
    }
}
