import java.util.*;

public class Location {
    private String name;
    private String description;
    private ArrayList<String> interactions;
    private ArrayList<Quest> quests;
    private ArrayList<Item> items;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.interactions = new ArrayList<>();
        this.quests = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFullDescription() {
        StringBuilder fullDescription = new StringBuilder(description);

        if (!interactions.isEmpty()) {
            fullDescription.append("\nInteractions:");
            for (String interaction : interactions) {
                fullDescription.append("\n- ").append(interaction);
            }
        }

        if (!quests.isEmpty()) {
            fullDescription.append("\nQuests:");
            for (Quest quest : quests) {
                fullDescription.append("\n- ").append(quest.getDescription()).append(" (Status: ").append(quest.getStatus()).append(")");
            }
        }

        if (!items.isEmpty()) {
            fullDescription.append("\nItems:");
            for (Item item : items) {
                fullDescription.append("\n- ").append(item.getName()).append(": ").append(item.getDescription());
            }
        }

        return fullDescription.toString();
    }

    // Methods to add interactions, quests, and items
    public void addInteraction(String interaction) {
        interactions.add(interaction);
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    // Example methods (for illustration purposes)
    public Quest checkQuestCompletion(Player player) {
        for (Quest quest : quests) {
            if (!quest.isCompleted() && quest.canComplete(player)) {
                quest.complete(player);
                return quest;
            }
        }
        return null;
    }

    public Item search(Player player) {
        // Example: Player searches the location and finds an item
        // For now, return a hardcoded item for demonstration
        if (!items.isEmpty()) {
            return items.get(0); // Return the first item found
        }
        return null;
    }
}