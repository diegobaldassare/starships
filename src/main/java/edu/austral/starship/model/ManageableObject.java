package edu.austral.starship.model;

import edu.austral.starship.base.vector.Vector2;

/**
 * Created by Diego Baldassare on 2018-11-01.
 */
public abstract class ManageableObject extends GameObject {

    ManageableObject(int life, Vector2 position) {
        super(life, position);
    }
//    public abstract void move(Vector2 direction);
//    public abstract void accelerate();
//    public abstract void rotate(Vector2 direction);
    public abstract void action(Player player);

//    public abstract void moveUp();
//    public abstract void moveDown();
//    public abstract void rotateRight();
//    public abstract void rotateLeft();

    public abstract int getWidth();
    public abstract int getHeight();

}
