import javax.management.ListenerNotFoundException;
import java.util.*;

public class CreatePlayer {
    private Scanner scanner;

    public CreatePlayer() {
        this.scanner = new Scanner(System.in);
    }


    // Simple Player class
    public static class Player {
        private String name;
        private int id;
        int position = 0;
        boolean hasStarted = false;

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

    public List<Player> createPlayers() {
        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Validate number of players
        while (numberOfPlayers <= 0) {
            System.out.print("Please enter a valid number of players: ");
            numberOfPlayers = scanner.nextInt();
            scanner.nextLine();
        }
        List<Player> players = new ArrayList<>();
       // Map<String, Integer> players= new HashMap<>();
        System.out.println("\nCreating " + numberOfPlayers + " players:");
        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = createPlayer(i);
            players.add(player);
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
        CreatePlayer playerCreator = new CreatePlayer(); // Create instance
        List<Player> players = playerCreator.createPlayers();

        // Display all created players
        System.out.println("\nAll created players:");
        for (Player player : players) {
            System.out.println(player);
        }
    }
}