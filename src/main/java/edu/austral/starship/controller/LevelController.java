package edu.austral.starship.controller;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.state.LevelZero;
import edu.austral.starship.view.GameView;

import java.util.List;

/**
 * Created by Diego Baldassare on 2018-11-02.
 */
public class LevelController {

    private final Game model;
    private final GameView view;

    LevelController(Game model, GameView view) {
        this.model = model;
        this.view = view;
        model.setLevel(new LevelZero(model, this));
//        model.getLevel().addObserver(this);
    }

    public void updateAsteroids(List<Asteroid> asteroids) {
        model.getAsteroids().addAll(asteroids);
        view.createAsteroids(asteroids);
    }
}
