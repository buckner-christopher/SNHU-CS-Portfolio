package com.gamingroom;

/**
 * A simple class used to test the behavior of the GameService singleton.
 * 
 * This class verifies that only one instance of GameService exists
 * by retrieving the instance again and printing out the list of games.
 */
public class SingletonTester {

    /**
     * Tests the singleton by printing all active games.
     */
    public void testSingleton() {

        System.out.println("\nTesting the GameService singleton...\n");

        // Obtain the same GameService instance (Singleton Pattern)
        GameService service = GameService.getInstance();

        // Loop through all games and print them
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }
    }
}