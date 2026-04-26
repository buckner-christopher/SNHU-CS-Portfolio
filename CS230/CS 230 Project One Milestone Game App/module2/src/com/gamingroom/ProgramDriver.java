package com.gamingroom;

/**
 * Application start-up program.
 * 
 * This class demonstrates how the GameService singleton is used
 * to create games, teams, and players. It also verifies that only
 * one instance of GameService exists in memory.
 */
public class ProgramDriver {

    /**
     * The main() method is the entry point of the application.
     */
    public static void main(String[] args) {

        // Obtain the single instance of GameService (Singleton Pattern)
        GameService service = GameService.getInstance();

        System.out.println("\nInitializing game data...\n");

        // Create a new game
        Game game = service.addGame("Draw It or Lose It");

        // Add teams to the game
        Team team1 = service.addTeam(game, "Team Alpha");
        Team team2 = service.addTeam(game, "Team Beta");

        // Add players to Team Alpha
        Player p1 = service.addPlayer(team1, "Chris");
        Player p2 = service.addPlayer(team1, "Allison");

        // Add a player to Team Beta
        Player p3 = service.addPlayer(team2, "Leela");

        // Print out the created objects
        System.out.println(game);
        System.out.println(team1);
        System.out.println(team2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Test the singleton behavior using the tester class
        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}