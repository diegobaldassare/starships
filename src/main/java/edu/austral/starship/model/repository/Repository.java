package edu.austral.starship.model.repository;

import edu.austral.starship.model.Entity;
import edu.austral.starship.model.builder.bullets.Bullet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Repository Pattern
 * Has the CRUD methods.
 * K represents the key to get a value efficiently.
 * T is the type of entities that will be stored.
 * Subclasses must implement the singleton pattern
 * in order to maintain data consistency.
 *
 * Created by Diego Baldassare on 2018-11-14.
 */
public abstract class Repository<K, T extends Entity<K>> {

    private final Map<K, T> entities = new HashMap<>();

    /**
     * Está bien aplicado el singleton pattern?
     *
     * - Cómo "obligo" a las subclases de Repository
     * para que no tengan mas de una instancia?
     * Porque si hago privado el constructor de repository,
     * no puedo tener sublases.
     */
    private static final Repository<Long, Bullet> INSTANCE = new BulletsRepository();

    public static Repository<Long, Bullet> getInstance() {
        return INSTANCE;
    }

    public void create(T entity) {
        entities.put(entity.getId(), entity);
    }

    public List<T> read() {
        return new ArrayList<>(entities.values());
    }

    public void update(T entity) {
        entities.replace(entity.getId(), entity);
    }

    public void delete(T entity) {
        entities.remove(entity.getId());
    }

    public T findById(K id) {
        return entities.get(id);
    }

    public List<T> findByPredicate(Predicate<T> predicate) {
        return entities.values().stream().filter(predicate).collect(Collectors.toList());
    }

    //Tratar de no usarlo para desligarlo de la implementación
//    public Map<K, T> getEntities() {
//        return entities;
//    }
}
