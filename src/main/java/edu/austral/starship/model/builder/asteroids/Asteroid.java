package edu.austral.starship.model.builder.asteroids;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.model.Starship;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class Asteroid extends GameObject implements Harmful {

    private static final int RADIUS_RELATION = 25;
    private int width;
    private int height;
    private int damage;

    Asteroid() {}

    Asteroid(int life, Vector2 position, Vector2 direction) {
        super(life, position);
        setDirection(direction);
    }

    @Override
    public void setup() {

    }

    @Override
    public void update(float timeSinceLastDraw) {
        this.accelerate();
    }

    @Override
    public void damage(Starship visitable) {
        visitable.setLife(visitable.getLife() - damage);
    }

    @Override
    public void damage(Asteroid visitable) {
        //Nothing happens here.
    }

    @Override
    public void damage(Bullet visitable) {
        visitable.setLife(0);
    }

    @Override
    public void accept(Harmful visitor) {
        visitor.damage(this);
    }

    @Override
    public void accept(Helpful visitor) {
        //Nothing can be done here.
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDamage() {
        return damage;
    }

    public void setRadius(int radius) {
        this.width = radius * RADIUS_RELATION;
        this.height = radius * RADIUS_RELATION;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
