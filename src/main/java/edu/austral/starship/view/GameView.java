package edu.austral.starship.view;

import edu.austral.starship.base.collision.CollisionEngine;
import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.utils.Constants;
import edu.austral.starship.model.*;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Diego Baldassare on 2018-10-29.
 */
public class GameView extends View{

    private final Game model;
    private final List<GameObjectView> gameObjectViews = new ArrayList<>();
    private PImage backgroundImage;
    private PImage pausedImage;
    private PImage asteroidImage;
    private PImage laserImage;

    public GameView(Game model) {
        this.model = model;
    }

    @Override
    public void setup(ImageLoader imageLoader) {
        backgroundImage = imageLoader.load(Constants.RESOURCES_PATH + "/images/background.jpeg");
        pausedImage = imageLoader.load(Constants.RESOURCES_PATH + "/images/paused.jpeg");
        asteroidImage = imageLoader.load(Constants.RESOURCES_PATH + "/images/asteroid-brown.png");
        laserImage = imageLoader.load(Constants.RESOURCES_PATH + "/images/bullet-laser.png");
        final String[] colors =  {"red", "blue", "green", "purple", "yellow"};
        int i = 0;
        for (ManageableObject m: model.getStarships()) {
            gameObjectViews.add(new StarshipView((Starship) m, colors[i]));
            i++;
        }

//        for (Asteroid a: model.getAsteroids()) {
//            gameObjectViews.add(new AsteroidView(a, "brown"));
//        }


        for (GameObjectView v : gameObjectViews) {
            v.setup(imageLoader);
        }
    }

    @Override
    public void draw(PGraphics graphics) {
        if (model.isEnded()) {
            printGameOver(graphics);
            printWinner(graphics);
//            printStatistics(graphics);
            return;
        }
        if (model.isPaused()) {
            printPaused(graphics);
            return;
        }
        backgroundImage.resize(graphics.width, graphics.height);
        graphics.background(backgroundImage);

        final CollisionEngine collisionEngine = new CollisionEngine();
        // noinspection unchecked
        collisionEngine.checkCollisions(gameObjectViews);

        //sacar objetos muertos
        gameObjectViews.removeIf(v -> v.getModel().getLife() <= 0);  //estaria repitiendo la logica del modelo

        //actualizar la vista
        gameObjectViews.forEach(v -> v.draw(graphics));
    }

    public void createAsteroids(final List<Asteroid> asteroids) {
        asteroids.forEach(a -> { gameObjectViews.add(new AsteroidView(a, "brown", asteroidImage)); });
    }

    public void createBullet(final Bullet bullet) {
        gameObjectViews.add(new BulletView(bullet, "laser", laserImage));
    }

    private void printPaused(PGraphics graphics) {
        pausedImage.resize(graphics.width, graphics.height);
        graphics.pushMatrix();
        graphics.imageMode(PConstants.CORNER);
        graphics.image(pausedImage, 0, 0);

        float x = (float) Constants.MAP_WIDTH / 2 - 20;
        float y = (float) Constants.MAP_HEIGHT / 2 + 300;
        graphics.fill(Color.WHITE.getRGB());

        graphics.textSize(20);
        graphics.textAlign(PConstants.CENTER);
        graphics.text("CONFIGURED CONTROLS", x, y);

        graphics.textAlign(PConstants.LEFT);

        y += 10;
        x = x - 450;
        graphics.textSize(16);
        graphics.text("Player 1", x, y + 30);
        graphics.textSize(12);
        graphics.text("Shoot: ENTER", x, y + 50);
        graphics.text("Move Forward: UP", x, y + 70);
        graphics.text("Rotate left: LEFT", x, y + 90);
        graphics.text("Rotate right: RIGHT", x, y + 110);
        graphics.text("Change weapon: DOWN", x, y + 130);

        x = x + 200;
        graphics.textSize(16);
        graphics.text("Player 2", x, y + 30);
        graphics.textSize(12);
        graphics.text("Shoot: TAB", x, y + 50);
        graphics.text("Move Forward: 2", x, y + 70);
        graphics.text("Rotate left: 3", x, y + 90);
        graphics.text("Rotate right: 1", x, y + 110);
        graphics.text("Change weapon: A", x, y + 130);

        x = x + 200;
        graphics.textSize(16);
        graphics.text("Player 3", x, y + 30);
        graphics.textSize(12);
        graphics.text("Shoot: DELETE", x, y + 50);
        graphics.text("Move Forward: 9", x, y + 70);
        graphics.text("Rotate left: 0", x, y + 90);
        graphics.text("Rotate right: 8", x, y + 110);
        graphics.text("Change weapon: MINUS", x, y + 130);

        x = x + 200;
        graphics.textSize(16);
        graphics.text("Player 4", x, y + 30);
        graphics.textSize(12);
        graphics.text("Shoot: 7", x, y + 50);
        graphics.text("Move Forward: 5", x, y + 70);
        graphics.text("Rotate left: 4", x, y + 90);
        graphics.text("Rotate right: 6", x, y + 110);
        graphics.text("Change weapon: T", x, y + 130);

        x = x + 200;
        graphics.textSize(16);
        graphics.text("Player 5", x, y + 30);
        graphics.textSize(12);
        graphics.text("Shoot: SHIFT", x, y + 50);
        graphics.text("Move Forward: X", x, y + 70);
        graphics.text("Rotate left: Z", x, y + 90);
        graphics.text("Rotate right: C", x, y + 110);
        graphics.text("Change weapon: V", x, y + 130);

        graphics.popMatrix();
    }

    private void printStatistics(PGraphics graphics) {
        final float x = (float) Constants.MAP_WIDTH / 2;
        final float y = (float) Constants.MAP_HEIGHT / 2 + 50;

        graphics.fill(Color.GREEN.getRGB());
        graphics.textAlign(PConstants.CENTER);

        graphics.textSize(30);
        graphics.text("Player     Score", x, y + 100);

        graphics.textSize(20);
        graphics.textAlign(PConstants.LEFT);
        model.getPlayers().sort(Comparator.comparingInt(Player::getScore));
        int i = 1;
        for (Player p: model.getPlayers()) {
            graphics.text(p.getName(), x - 100, y + 120 + 30 * i);
            graphics.text(p.getScore(), x + 60, y + 120 + 30 * i);
            i++;
        }

        graphics.noFill();
    }

    private void printGameOver(PGraphics graphics) {
        final float x = (float) Constants.MAP_WIDTH / 2;
        final float y = (float) Constants.MAP_HEIGHT / 2 - 100;

        graphics.fill(Color.GREEN.getRGB());
        graphics.textAlign(PConstants.CENTER);

        graphics.textSize(150);
        graphics.text("GAME OVER", x, y);
    }

    private void printWinner(PGraphics graphics) {
        final float x = (float) Constants.MAP_WIDTH / 2;
        final float y = (float) Constants.MAP_HEIGHT / 2;

        graphics.fill(Color.GREEN.getRGB());
        graphics.textAlign(PConstants.CENTER);

        graphics.textSize(50);

        //multiplayer
        if (model.getPlayers().size() > 1) {
            model.getPlayers().forEach(p -> {
                if(((Starship) p.getManageableObject()).getColor().equals(model.getStarships().get(0).getColor()))
                    graphics.text(p.getName() + " win!", x, y);
            });
        }

        //single player
        else {
            if (model.getAsteroids().isEmpty()) graphics.text("You win!", x, y);
            else                                graphics.text("You lost.", x, y);
        }
    }

    public List<GameObjectView> getGameObjectViews() {
        return gameObjectViews;
    }
}
