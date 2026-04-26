package com.gamingroom;

/**
 * The Player class represents a single player on a team.
 * 
 * This class extends the Entity base class so it inherits
 * the id and name fields shared by all entities in the system.
 * 
 * Players do not contain collections like Game or Team,
 * so this class is primarily a simple data holder.
 */
public class Player extends Entity {

    /**
     * Constructor that passes id and name to the Entity base class.
     * 
     * @param id   Unique identifier for the player
     * @param name Name of the player
     */
    public Player(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + "]";
    }
}