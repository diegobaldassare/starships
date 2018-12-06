package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;
import edu.austral.starship.model.builder.weapons.LaserWeapon;
import edu.austral.starship.model.builder.weapons.Weapon;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Diego Baldassare on 25/10/2018.
 */
public class Starship extends ManageableObject implements Harmful {

    private static final int INITIAL_LIFE = 50;
    private static final int WIDTH = 92;
    private static final int HEIGHT = 81;

    private String color;

    private Weapon current;

    public Starship(Vector2 initialPosition) {
        super(WIDTH, HEIGHT, INITIAL_LIFE, initialPosition);
        this.current = new LaserWeapon();
        this.setSpeed(5);
        setDirection(Vector2.vector(0, -1));
    }

    //sacar
    public Starship() {
        this(Vector2.vector(500, 500));
    }

    @Override
    public void setup() {

    }

    @Override
    public void update(float timeSinceLastDraw) {

    }

    @Override
    public void damage(Starship visitable) {
        if (visitable.getLife() > this.getLife()) this.setLife(0);
        else visitable.setLife(0);
    }

    @Override
    public void damage(Asteroid visitable) {
        visitable.setLife(0);
    }

    @Override
    public void damage(Bullet visitable) {
        visitable.setLife(0);
    }

//    @Override
//    public void move(Vector2 direction) {
//        setDirection(direction);
//        setPosition(getPosition().add(direction.multiply(SPEED)));
//    }


    /**
     * The starship only knows to make an action,
     * since its a Movable Player Object. It delegates
     * the weapon to perform the shooting behaviour
     * depending on the current weapon it is using.
     * The last is known as the State Patten.
     */
    public void action(Player player) {
        current.shoot(player);
    }

    public Weapon getCurrent() {
        return current;
    }

    public void setCurrent(Weapon current) {
        this.current = current;
    }


    @Override
    public void accept(Harmful visitor) {
        visitor.damage(this);
    }

    @Override
    public void accept(Helpful visitor) {
        visitor.help(this);
    }

    public String getColor() {
        return color;
    }

    public static int getInitialLife() {
        return INITIAL_LIFE;
    }
}
