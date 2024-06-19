public class Quest {
    private String description;
    private boolean completed;

    public Quest(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean canComplete(Player player) {
        // Implement conditions for quest completion based on player's attributes or inventory
        return true; // For demonstration, always return true
    }

    public void complete(Player player) {
        completed = true;
        // Implement rewards or consequences for completing the quest
    }

    public String getStatus() {
        return completed ? "Completed" : "In Progress";
    }
}