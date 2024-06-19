import java.util.*;

public class Player {
    private String name;
    private ArrayList<Item> inventory;
    // Additional player attributes like health, experience, etc. can be added here

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    // Additional methods for player actions, status, etc.
}