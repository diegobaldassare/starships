package edu.austral.starship.model.builder.weapons;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.Game;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.Shooter;
import edu.austral.starship.model.builder.bullets.BulletBuilder;
import edu.austral.starship.model.builder.bullets.LaserBulletBuilder;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Performs as the BulletBuilder Director as well.
 *
 * Created by Diego Baldassare on 2018-10-31.
 */
public class LaserWeapon extends Weapon {

//    private static final int SIMPLE_WEAPON_USE_LIFE = 10000000; //infinito
//    private static final Vector2 EVERYWHERE = Vector2.vector(0, 0); //siempre la tiene el starship (no se ve)

    @Override
    public void shoot(Shooter shooter) {
//        shooter.getBullets().add(new Bullet(shooter, 60, Vector2.vector(34, 34)));
        final BulletBuilder bulletBuilder = new LaserBulletBuilder();
        bulletBuilder.construct();
        bulletBuilder.build();
        bulletBuilder.assignShooter(shooter);
    }

    @Override
    public void accept(Harmful visitor) {
        //Nothing can be done here
    }

    @Override
    public void accept(Helpful visitor) {
        //Nothing can be done here
    }

    @Override
    public Weapon getNext() {
        return new MultilaserWeapon();
    }
}
