package edu.austral.starship.model.builder.weapons;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.Shooter;
import edu.austral.starship.model.builder.bullets.BulletBuilder;
import edu.austral.starship.model.builder.bullets.LaserBulletBuilder;
import edu.austral.starship.model.builder.bullets.MultilaserBulletBuilder;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Performs as the BulletBuilder Director as well.
 *
 * Created by Diego Baldassare on 2018-10-31.
 */
public class MultilaserWeapon extends Weapon {

    @Override
    public void shoot(Shooter shooter) {
        final BulletBuilder bulletBuilder = new MultilaserBulletBuilder();
        bulletBuilder.construct();
        bulletBuilder.build();
        bulletBuilder.assignShooter(shooter);
    }

    @Override
    public Weapon getNext() {
        return new FrozenWeapon();
    }
}
