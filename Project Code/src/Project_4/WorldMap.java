import java.util.*;

public class WorldMap {
    private static HashMap<String, Location> locations = new HashMap<>();

    static {
        // Initialize locations
        Location start = new Location("start", "You are at the beginning of your journey.");
        Location town = new Location("town", "You have arrived at a small town.");
        Location forest = new Location("forest", "You find yourself in a dense forest.");

        // Add interactions, quests, and items to locations (for demonstration)
        start.addInteraction("Talk to the guide");
        start.addQuest(new Quest("Help the villagers with a problem"));

        town.addItem(new Item("Potion", "Restores health when consumed"));

        forest.addInteraction("Search for hidden treasure");

        // Add locations to the map
        locations.put("start", start);
        locations.put("town", town);
        locations.put("forest", forest);
    }

    public static Location getLocation(String name) {
        return locations.get(name);
    }

    public static void printLocations() {
        for (String locationName : locations.keySet()) {
            System.out.println("- " + locationName);
        }
    }
}