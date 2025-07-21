import java.util.Scanner;
import java.util.List;

public class SnakeAndLadder {
    private static int[] playerPositions;
    private static boolean[] playersStarted;
    private static int numberOfPlayers;
    private static List<CreatePlayer.Player> players;
    private static int currentPlayerIndex = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static boolean tryToStart(int playerIndex) {
        if (playerIndex == 0) {
            CreatePlayer player = new CreatePlayer();
            players = player.createPlayers();
            numberOfPlayers = players.size();
            playerPositions = new int[numberOfPlayers];
            playersStarted = new boolean[numberOfPlayers];
            System.out.println("Game starting with " + numberOfPlayers + " players!");
        }

        System.out.println("\nPlayer " + (playerIndex + 1) + "'s turn!");
        System.out.println("You need to roll a 6 to start the game!");
        System.out.print("Press Enter to roll the die...");
        scanner.nextLine();

        RollDie die = new RollDie();
        int roll = die.rollDie();

        if (roll == 6) {
            System.out.println("Player " + (playerIndex + 1) + " rolled a 6! You can start the game.");
            playersStarted[playerIndex] = true;
            playerPositions[playerIndex] = 1;
            return true;
        } else {
            System.out.println("Player " + (playerIndex + 1) + " rolled a " + roll + ".❌ You need a 6 to start. Try again next turn!");
            return false;
        }
    }

    public static void applySpecialRules(int playerIndex) {
        int position = playerPositions[playerIndex];
        if (position % 2 == 0) {
            if (position + 10 > 100) {
                System.out.println("❌ Ladder would exceed 100. Player " + (playerIndex + 1) + " stays at position " + position);
            } else {
                System.out.println("🪜 Ladder! Even number - Player " + (playerIndex + 1) + " climbing up 10 positions!");
                playerPositions[playerIndex] += 10;
            }
        } else if(position % 2 != 0 && position > 10 && position < 100) {
            System.out.println("🐍 Snake! Odd number - Player " + (playerIndex + 1) + " sliding down 5 positions!");
            playerPositions[playerIndex] -= 5;
            if (playerPositions[playerIndex] < 0) {
                playerPositions[playerIndex] = 0;
                playersStarted[playerIndex] = false;
            }
        }
    }

    public static int checkPlayerProgress() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerPositions[i] == 100) {
                return i; // Return the index of the winning player
            }
        }
        return -1; // No winner yet
    }

    public static boolean allPlayersStarted() {
        for (boolean started : playersStarted) {
            if (!started) {
                return false;
            }
        }
        return true;
    }

    public static void displayStatus() {
        System.out.println("\n📊 PLAYER POSITIONS:");
        for (int i = 0; i < numberOfPlayers; i++) {
            String status = playersStarted[i] ? "Position: " + playerPositions[i] : "Not started";
            System.out.println("Player " + (i + 1) + " - " + status);
        }
        System.out.println("🎯 Target: 100");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
    }

    public static void playGame() {
        System.out.println("🎲 Welcome to Snake and Ladder!");
        System.out.println("Rules:");
        System.out.println("- Roll a 6 to start");
        System.out.println("- Even positions: Climb ladder (+10)");
        System.out.println("- Odd positions: Hit snake (-5)");
        System.out.println("- Reach 100 to win!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");

        // Initialize first player to get number of players
        tryToStart(0);
        currentPlayerIndex = 1;

        // Game starts when first player rolls a 6, others keep trying each turn
        displayStatus();
        currentPlayerIndex = 0;

        // Main game loop
        while (checkPlayerProgress() == -1) {
            System.out.println("\nPlayer " + (currentPlayerIndex + 1) + "'s turn!");

            // If player hasn't started yet, they need to roll a 6
            if (!playersStarted[currentPlayerIndex]) {
                System.out.println("You need to roll a 6 to start the game!");
                System.out.print("Press Enter to roll the die...");
                scanner.nextLine();

                RollDie die = new RollDie();
                int roll = die.rollDie();
                System.out.println("🎲 Player " + (currentPlayerIndex + 1) + " rolled: " + roll);

                if (roll == 6) {
                    System.out.println("Player " + (currentPlayerIndex + 1) + " rolled a 6! You can start the game.");
                    playersStarted[currentPlayerIndex] = true;
                    playerPositions[currentPlayerIndex] = 1;
                } else {
                    System.out.println("❌ You need a 6 to start. Try again next turn!");
                }
            } else {
                // Player has already started, normal gameplay
                System.out.print("Press Enter to roll the die...");
                scanner.nextLine();

                int roll = new RollDie().rollDie();
                System.out.println("🎲 Player " + (currentPlayerIndex + 1) + " rolled: " + roll);

                if (playerPositions[currentPlayerIndex] + roll > 100) {
                    System.out.println("❌ Roll exceeds 100. Player " + (currentPlayerIndex + 1) + " stays at position " + playerPositions[currentPlayerIndex]);
                } else {
                    playerPositions[currentPlayerIndex] += roll;
                    System.out.println("Player " + (currentPlayerIndex + 1) + " moved to position: " + playerPositions[currentPlayerIndex]);

                    if (playerPositions[currentPlayerIndex] < 100) {
                        applySpecialRules(currentPlayerIndex);
                    }
                }
            }

            displayStatus();

            int winner = checkPlayerProgress();
            if (winner != -1) {
                System.out.println("🏆 Congratulations! Player " + (winner + 1) + " reached exactly 100 and won the game!");
                break;
            }

            // Move to next player's turn
            currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
            System.out.println();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}