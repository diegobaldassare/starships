package edu.austral.starship.model.builder.bullets;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.Shooter;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class MultilaserBulletBuilder extends BulletBuilder {

    @Override
    public void buildName() { bullet.setName("Multilaser");}

    @Override
    public void buildLife() { bullet.setLife(1);}

    @Override
    public void buildSize() { bullet.setSize(1);}

    @Override
    public void buildSpeed() { bullet.setSpeed(7);}

    @Override
    public void buildDamage() { bullet.setDamage(1);}

    public void assignShooter(Shooter shooter) {
        bullet.setPosition(shooter.getPosition().add(Vector2.vector(
                (float) Math.cos(shooter.getDirection().angle()) * (shooter.getWidth() + 1),
                (float) Math.sin(shooter.getDirection().angle()) * (shooter.getHeight() + 1))));
        bullet.setShotFrom(shooter.getPosition());
        bullet.setDirection(shooter.getDirection());
    }
}
