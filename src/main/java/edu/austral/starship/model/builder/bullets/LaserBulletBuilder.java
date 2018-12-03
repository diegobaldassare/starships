package edu.austral.starship.model.builder.bullets;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class LaserBulletBuilder extends BulletBuilder {

    @Override
    public void buildName() { bullet.setName("Laser");}

    @Override
    public void buildLife() { bullet.setLife(1);}

    @Override
    public void buildSize() { bullet.setSize(1);}

    @Override
    public void buildSpeed() { bullet.setSpeed(3);}

    @Override
    public void buildDamage() { bullet.setDamage(1);}
}
