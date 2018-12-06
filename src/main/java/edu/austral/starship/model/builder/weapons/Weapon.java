package edu.austral.starship.model.builder.weapons;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.*;
import edu.austral.starship.model.builder.bullets.BulletBuilder;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public abstract class Weapon extends GameObject implements Helpful {

    private String name;
    private int bulletCapacity;
    private int bulletQuantity;
    private long lastReloadTime;

    public Weapon(int width, int height, int life, Vector2 position) {
        super(width, height, life, position);
    }

    Weapon() {}

    @Override
    public void setup() {

    }

    @Override
    public void update(float timeSinceLastDraw) {

    }

    public abstract void shoot(Shooter shooter);

    @Override
    public void help(Starship visitable) {
        visitable.setCurrent(this);
    }

    public abstract Weapon getNext();

    @Override
    public void accept(Harmful visitor) {

    }

    @Override
    public void accept(Helpful visitor) {

    }
}
