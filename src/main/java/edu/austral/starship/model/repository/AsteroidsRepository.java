package edu.austral.starship.model.repository;

import edu.austral.starship.model.builder.asteroids.Asteroid;

/**
 * Created by Diego Baldassare on 2018-11-15.
 */
public class AsteroidsRepository extends Repository<Long, Asteroid> {

    /**
     * Está bien aplicado el singleton pattern?
     *
     * - Cómo "obligo" a las subclases de Repository
     * para que no tengan mas de una instancia?
     * Porque si hago privado el constructor de repository,
     * no puedo tener sublases.
     */
    private static final Repository<Long, Asteroid> INSTANCE = new AsteroidsRepository();

    private AsteroidsRepository() {}

//    @Override
//    public Repository<Long, Asteroid> getInstance() {
//        return INSTANCE;
//    }
}
