package edu.austral.starship.view;

import edu.austral.starship.base.framework.ImageLoader;
import edu.austral.starship.gameUtils.Constants;
import edu.austral.starship.model.*;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.repository.BulletsRepository;
import edu.austral.starship.view.configuration.AsteroidConfiguration;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.Iterator;
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
        backgroundImage = imageLoader.load(Constants.IMAGES_PATH + "background.jpeg");
        pausedImage = imageLoader.load(Constants.IMAGES_PATH + "paused.jpeg");
        asteroidImage = imageLoader.load(Constants.IMAGES_PATH + "asteroid-brown.png");
        laserImage = imageLoader.load(Constants.IMAGES_PATH + "bullet-laser.png");
        final String[] colors =  {"red", "blue", "green", "purple", "yellow"};
        int i = 0;
        for (ManageableObject m: model.getManegeableObjects()) {
            gameObjectViews.add(new StarshipView((Starship) m, colors[i]));
            i++;
        }

        for (Asteroid a: model.getAsteroids()) {
            gameObjectViews.add(new AsteroidView(a, "brown"));
        }


        for (GameObjectView v : gameObjectViews) {
            v.setup(imageLoader);
        }
    }

    @Override
    public void draw(PGraphics graphics) {
        if (model.isEnded()) {
            graphics.text("GAME OVER - Score: 72", 500, 500);
        }
        backgroundImage.resize(graphics.width, graphics.height);
        graphics.background(backgroundImage);
        if (model.isPaused()) {
            pausedImage.resize(graphics.width, graphics.height);
            graphics.pushMatrix();
            graphics.imageMode(PConstants.CORNER);
            graphics.image(pausedImage, 0, 0);
            graphics.popMatrix();
            return;
        }
        if (model.isEnded()) {
            // Print Game over or players with score
        }

        //agregar la vista de asteroides nuevos
        for (Asteroid a: model.getNewAsteroids()) {
            gameObjectViews.add(new AsteroidView(a, "brown", asteroidImage));
        }
        model.getNewAsteroids().clear();

        for (Bullet b: model.getNewBullets()) {
            gameObjectViews.add(new BulletView(b, "laser", laserImage));
        }
        model.getNewBullets().clear();


        gameObjectViews.removeIf(v -> !model.getGameObjects().contains(v.getModel()));
        for (GameObjectView v: gameObjectViews) {
            v.draw(graphics);
        }
    }

    public List<GameObjectView> getGameObjectViews() {
        return gameObjectViews;
    }
}
