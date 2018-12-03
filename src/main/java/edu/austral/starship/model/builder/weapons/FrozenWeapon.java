package edu.austral.starship.model.builder.weapons;

import edu.austral.starship.base.vector.Vector2;
import edu.austral.starship.model.Shooter;
import edu.austral.starship.model.visitor.Harmful;
import edu.austral.starship.model.visitor.Helpful;

/**
 * Created by Diego Baldassare on 2018-11-20.
 */
public class FrozenWeapon extends Weapon {

    @Override
    public void shoot(Shooter shooter) {

    }

    @Override
    public void accept(Harmful visitor) {

    }

    @Override
    public void accept(Helpful visitor) {

    }

    @Override
    public Weapon getNext() {
        return new LaserWeapon();
    }
}
