import java.util.*;

public class TextAdventure {
    private static Player player;
    private static Location currentLocation;
    private static boolean gameOver;

    public static void main(String[] args) {
        initializeGame();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text-Based Adventure Game!");
        System.out.println("Explore the world and make decisions to shape your destiny.");
        System.out.println("------------------------------------------------------------");

        while (!gameOver) {
            displayLocation();
            displayOptions();

            String input = scanner.nextLine().trim().toLowerCase();
            processInput(input);
        }

        System.out.println("Game over! Thanks for playing.");
        scanner.close();
    }

    private static void initializeGame() {
        player = new Player("Player");
        currentLocation = WorldMap.getLocation("start"); // Start location
        gameOver = false;
    }

    private static void displayLocation() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Current Location: " + currentLocation.getName());
        System.out.println(currentLocation.getDescription());
        System.out.println("------------------------------------------------------------");
    }

    private static void displayOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1. Explore surroundings");
        System.out.println("2. Check inventory");
        System.out.println("3. Move to another location");
        System.out.println("4. Quit game");
        System.out.print("Enter your choice: ");
    }

    private static void processInput(String input) {
        switch (input) {
            case "1":
                exploreLocation();
                break;
            case "2":
                displayInventory();
                break;
            case "3":
                moveLocation();
                break;
            case "4":
                gameOver = true;
                break;
            default:
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                break;
        }
    }

    private static void exploreLocation() {
        System.out.println("You explore " + currentLocation.getName() + "...");
        System.out.println(currentLocation.getFullDescription());

        // Simulate interaction with NPCs or items in the location
        // Example: currentLocation.interact(player);

        // Check if player completes a quest or finds an item
        // Example: Quest completedQuest = currentLocation.checkQuestCompletion(player);
        // Example: Item foundItem = currentLocation.search(player);

        // Update player's status based on interactions

        // For demonstration purposes, let's move to another location after exploring
        moveLocation();
    }

    private static void displayInventory() {
        System.out.println("Inventory:");
        System.out.println(player.getInventory());
    }

    private static void moveLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available locations:");
        WorldMap.printLocations();
        System.out.print("Enter the location you want to move to: ");
        String newLocationName = scanner.nextLine().trim().toLowerCase();

        Location newLocation = WorldMap.getLocation(newLocationName);

        if (newLocation != null) {
            currentLocation = newLocation;
        } else {
            System.out.println("Invalid location.");
        }
    }
}