package edu.austral.starship.model.visitor;

import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;
import edu.austral.starship.model.Starship;

/**
 * Created by Diego Baldassare on 2018-10-28.
 */
public interface Harmful {

    void damage(Starship visitable);
    void damage(Asteroid visitable);
    void damage(Bullet visitable);
}
