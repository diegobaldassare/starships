package edu.austral.starship.model.repository;

import edu.austral.starship.model.builder.asteroids.Asteroid;
import edu.austral.starship.model.builder.bullets.Bullet;

/**
 * Created by Diego Baldassare on 2018-11-15.
 */
public class BulletsRepository extends Repository<Long, Bullet> {

    /**
     * Está bien aplicado el singleton pattern?
     *
     * - Cómo "obligo" a las subclases de Repository
     * para que no tengan mas de una instancia?
     * Porque si hago privado el constructor de repository,
     * no puedo tener sublases.
     */
    private static final Repository<Long, Bullet> INSTANCE = new BulletsRepository();

     BulletsRepository() {}

//    public static Repository<Long, Bullet> getInstance() {
//        return INSTANCE;
//    }
}
