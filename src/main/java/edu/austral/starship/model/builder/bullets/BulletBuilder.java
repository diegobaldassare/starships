package edu.austral.starship.model.builder.bullets;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.controller.ShooterController;
import edu.austral.starship.model.Shooter;

/**
 * Builder Pattern optimized.
 *
 * Created by Diego Baldassare on 2018-11-20.
 */
public abstract class BulletBuilder {

    Bullet bullet;

    BulletBuilder() {}

    public Bullet getBullet() {
        return bullet;
    }

    public void construct() {
        bullet = new Bullet();
        ShooterController.getInstance().createBullet(bullet);
    }

    /**
     * Template Pattern
     */
    public void build() {
        buildLife();
        buildSize();
        buildSpeed();
        buildDamage();
        buildName();
    }

    public abstract void buildName();
    public abstract void buildLife();
    public abstract void buildSize();
    public abstract void buildSpeed();
    public abstract void buildDamage();

    public void assignShooter(Shooter shooter) {
        //Se dispara una distancia de 35 mas lejos porque sino la bala colsiona con el que esta disparando.
        bullet.setPosition(shooter.getPosition().add(Vector2.vector(
                (float) Math.cos(shooter.getDirection().angle()) * (shooter.getWidth()),
                (float) Math.sin(shooter.getDirection().angle()) * (shooter.getHeight()))));
        bullet.setShotFrom(shooter.getPosition());
        bullet.setDirection(shooter.getDirection());
    }


}
