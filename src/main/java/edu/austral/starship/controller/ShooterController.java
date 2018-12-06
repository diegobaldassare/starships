package edu.austral.starship.controller;

import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.view.GameView;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class ShooterController {

    private final Game model;
    private final GameView view;

    private static ShooterController instance = null;

    public static ShooterController getInstance() {
        return instance;
    }

    ShooterController(Game model, GameView view) {
        this.model = model;
        this.view = view;
        this.instance = this;
//        BulletsRepository.getInstance().addObserver(this);
    }

    public void createBullet(Bullet bullet) {
        model.getBullets().add(bullet);
        view.createBullet(bullet);
    }

}
