package edu.austral.starship.model.builder.bullets;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.GameObject;
import edu.austral.starship.model.Shooter;
import edu.austral.starship.model.Starship;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Created by Diego Baldassare on 2018-10-31.
 */
public class Bullet extends GameObject implements Harmful {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private int size;
    private int damage;
    private String name;
    private Shooter shooter;
    private Vector2 shotFrom;

    //se deberia sacar
    Bullet() {}

    public Bullet(Shooter shooter, int life, Vector2 position) {
        super(WIDTH, HEIGHT, life, position);
        this.shooter = shooter;
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
//        shooter.hitted(visitable);                            ///arreglarrrrr
    }

    @Override
    public void damage(Asteroid visitable) {
        visitable.setLife(visitable.getLife() - damage);
//        shooter.hitted(visitable);                        //ARREGLAR!!

        //Ya se, es horrible....
        if (name.equals("Frozen"))
            visitable.setSpeed(0.5f);
    }

    @Override
    public void damage(Bullet visitable) {
        //Do nothing
    }

    @Override
    public void accept(Harmful visitor) {
        visitor.damage(this);
    }

    @Override
    public void accept(Helpful visitor) {
        //Nothing can be done here.
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shooter getShooter() {
        return shooter;
    }

    public void setShooter(Shooter shooter) {
        this.shooter = shooter;
    }

    public Vector2 getShotFrom() {
        return shotFrom;
    }

    public void setShotFrom(Vector2 shotFrom) {
        this.shotFrom = shotFrom;
    }
}
