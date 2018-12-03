package edu.austral.starship.model.builder.bullets;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.Shooter;
import edu.austral.starship.model.repository.BulletsRepository;

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
        BulletsRepository.getInstance().create(bullet);
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
        bullet.setPosition(shooter.getPosition().add(Vector2.vector(
                (float) Math.cos(shooter.getDirection().angle()) * (shooter.getWidth() + 1),
                (float) Math.sin(shooter.getDirection().angle()) * (shooter.getHeight() + 1))));
        bullet.setShotFrom(shooter.getPosition());
        bullet.setDirection(shooter.getDirection());
    }


}
