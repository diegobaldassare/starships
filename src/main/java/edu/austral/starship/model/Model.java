package edu.austral.starship.model;

import java.util.UUID;

/**
 * Created by Diego Baldassare on 2018-10-29.
 */
public abstract class Model implements Entity<Long> {

    private long id;

    Model() {
//        id = Long.getLong(UUID.randomUUID().toString());
    }

    public abstract void setup();
    public abstract void update(float timeSinceLastDraw);

    @Override
    public Long getId() {
        return id;
    }
}
