package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * The Team class represents a team within a game.
 * 
 * This class extends the Entity base class so it inherits
 * the id and name fields shared by all entities.
 * 
 * A Team contains one or more Player objects, and this class
 * ensures that player names remain unique using the iterator pattern.
 */
public class Team extends Entity {

    // A list to store all players that belong to this team
    private List<Player> players = new ArrayList<>();

    /**
     * Constructor that passes id and name to the Entity base class.
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a new player to the team.
     * 
     * Uses the iterator pattern to check if a player with the same name
     * already exists. If found, the existing player is returned.
     * Otherwise, a new player is created and added to the list.
     * 
     * @param id   Unique identifier for the player
     * @param name Name of the player
     * @return The existing or newly created Player object
     */
    public Player addPlayer(long id, String name) {

        // Check for an existing player with the same name
        for (Player p : players) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p; // return existing player
            }
        }

        // If not found, create a new player and add to the list
        Player player = new Player(id, name);
        players.add(player);

        return player;
    }

    /**
     * Returns the list of players on this team.
     */
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }
}
