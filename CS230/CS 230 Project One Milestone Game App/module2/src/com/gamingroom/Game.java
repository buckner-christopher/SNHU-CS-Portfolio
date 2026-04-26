package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * The Game class represents a single game instance.
 * 
 * This class now extends the Entity base class so it can
 * inherit the id and name fields shared by all entities.
 * 
 * A Game contains one or more Teams, and this class provides
 * functionality to add teams while ensuring team names remain unique.
 */
public class Game extends Entity {

    // A list to store all teams that belong to this game
    private List<Team> teams = new ArrayList<>();

    /**
     * Constructor that passes id and name to the Entity base class.
     */
    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a new team to the game.
     * 
     * Uses the iterator pattern to check if a team with the same name
     * already exists. If it does, the existing team is returned.
     * Otherwise, a new team is created and added to the list.
     * 
     * @param id   Unique identifier for the team
     * @param name Name of the team
     * @return The existing or newly created Team object
     */
    public Team addTeam(long id, String name) {

        // Check for an existing team with the same name
        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t; // return existing team
            }
        }

        // If not found, create a new team and add it to the list
        Team team = new Team(id, name);
        teams.add(team);

        return team;
    }

    /**
     * Returns the list of teams in this game.
     */
    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "Game [id=" + id + ", name=" + name + "]";
    }
}
