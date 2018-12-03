package edu.austral.starship.model.builder.bullets;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class FrozenBulletBuilder extends BulletBuilder {

    @Override
    public void buildName() { bullet.setName("Frozen");}

    @Override
    public void buildLife() { bullet.setLife(2);}

    @Override
    public void buildSize() { bullet.setSize(2);}

    @Override
    public void buildSpeed() { bullet.setSpeed(5);}

    @Override
    public void buildDamage() { bullet.setDamage(5);}
}
