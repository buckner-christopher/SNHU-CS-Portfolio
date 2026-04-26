package com.gamingroom;

/**
 * Base class for all entities in the game.
 */
public class Entity {
    protected long id;
    protected String name;

    protected Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}