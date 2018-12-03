package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public abstract class Shooter extends Model {

    private List<Bullet> bullets = new ArrayList<>();

    public abstract void shoot();
    public abstract void hitted(Starship target);
    public abstract void hitted(Asteroid target);

    public List<Bullet> getBullets() {
        return bullets;
    }

    public abstract Vector2 getPosition();
    public abstract Vector2 getDirection();
    public abstract int getWidth();
    public abstract int getHeight();
}
