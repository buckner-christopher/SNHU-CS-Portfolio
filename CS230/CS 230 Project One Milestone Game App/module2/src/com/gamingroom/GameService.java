package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * GameService is a singleton class that manages all active games,
 * teams, and players in the system.
 * 
 * This class ensures:
 *  - Only one instance of GameService exists (Singleton Pattern)
 *  - Unique IDs are assigned to games, teams, and players
 *  - Names remain unique using the iterator pattern
 */
public class GameService {

    // The one and only instance of GameService (Singleton)
    private static GameService instance = null;

    // List of all active games
    private static List<Game> games = new ArrayList<>();

    // ID counters for games, teams, and players
    private static long nextGameId = 1;
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;

    /**
     * Private constructor prevents external instantiation.
     */
    private GameService() {
    }

    /**
     * Returns the single instance of GameService.
     * Creates it if it does not already exist.
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * Adds a new game to the system.
     * 
     * Uses the iterator pattern to check for an existing game
     * with the same name. If found, returns the existing game.
     * Otherwise, creates a new one.
     */
    public Game addGame(String name) {

        // Check for existing game with same name
        for (Game g : games) {
            if (g.getName().equalsIgnoreCase(name)) {
                return g; // return existing game
            }
        }

        // Create new game if not found
        Game game = new Game(nextGameId++, name);
        games.add(game);

        return game;
    }

    /**
     * Adds a new team to a specific game.
     * 
     * @param game The game the team belongs to
     * @param name The unique team name
     * @return The existing or newly created Team object
     */
    public Team addTeam(Game game, String name) {
        return game.addTeam(nextTeamId++, name);
    }

    /**
     * Adds a new player to a specific team.
     * 
     * @param team The team the player belongs to
     * @param name The unique player name
     * @return The existing or newly created Player object
     */
    public Player addPlayer(Team team, String name) {
        return team.addPlayer(nextPlayerId++, name);
    }

    /**
     * Returns the number of active games.
     */
    public int getGameCount() {
        return games.size();
    }

    /**
     * Returns the game at a specific index.
     * Used by SingletonTester.
     */
    Game getGame(int index) {
        return games.get(index);
    }
}
