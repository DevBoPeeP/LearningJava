import java.util.*;

public class DuplicateCreatePlayer {
    private Scanner scanner;

    public DuplicateCreatePlayer() {
        this.scanner = new Scanner(System.in);
    }

    // Simple Player class
    public static class Player {
        private String name;
        private int id;


        public Player(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Player " + id + ": " + name;
        }
    }

    public Map<Integer, Player> createPlayers() {
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate number of players
        while (numberOfPlayers <= 0) {
            System.out.print("Please enter a valid number of players: ");
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
        }

        Map<Integer, Player> players = new HashMap<>();
        System.out.println("\nCreating " + numberOfPlayers + " players:");

        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = createPlayer(i);
            players.put(player.getId(), player); // Using player ID as key
            System.out.println("✓ " + player.toString() + " created successfully!");
        }

        return players;
    }

    private Player createPlayer(int id) {
        System.out.print("Enter name for Player " + id + ": ");
        String name = scanner.nextLine();

        // Validate player name
        while (name.trim().isEmpty()) {
            System.out.print("Name cannot be empty. Please enter a valid name: ");
            name = scanner.nextLine();
        }

        return new Player(name, id);
    }

    public static void main(String[] args) {
        DuplicateCreatePlayer playerCreator = new DuplicateCreatePlayer();
        Map<Integer, Player> players = playerCreator.createPlayers();

        // Display all created players
        System.out.println("\nAll created players:");
        for (Map.Entry<Integer, Player> entry : players.entrySet()) {
            System.out.println(entry.getValue());
        }


    }
}