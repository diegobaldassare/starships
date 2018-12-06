package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;

/**
 * Created by Diego Baldassare on 2018-11-01.
 */
public abstract class ManageableObject extends GameObject {

    ManageableObject(int width, int height, int life, Vector2 position) {
        super(width, height, life, position);
    }

    public abstract void action(Player player);
}
