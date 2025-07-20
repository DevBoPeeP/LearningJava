import java.util.Scanner;

public class SnakeAndLadder {
    private static int playerPosition = 0;
    private static boolean gameStarted = false;
    private static Scanner scanner = new Scanner(System.in);

    public static boolean tryToStart() {
        System.out.println("You need to roll a 6 to start the game!");
        System.out.print("Press Enter to roll the die...");
        scanner.nextLine();

        RollDie die = new RollDie();
        int roll = die.rollDie();

        if (roll == 6) {
            System.out.println("You rolled a 6! You can start the game.");
            gameStarted = true;
            playerPosition = 1;
            return true;
        } else {
            System.out.println("You rolled a " + roll + ".❌ You need a 6 to start. Try again!");
            return false;
        }
    }

    public static void applySpecialRules() {
        if (playerPosition % 2 == 0) {
            if (playerPosition + 10 > 100) {
                System.out.println("❌ Roll exceeds 100. You stay at position " + playerPosition);
            } else {
                System.out.println("🪜 Ladder! Even number - climbing up 10 positions!");
                playerPosition += 10;
            }
        } else if(playerPosition % 2 != 0 && playerPosition > 10 && playerPosition < 100) {
            System.out.println("🐍 Snake! Odd number - sliding down 5 positions!");
            playerPosition -= 5;
            if (playerPosition < 0) {
                playerPosition = 0;
            }
        }
    }

    public static boolean checkWin() {
        return playerPosition == 100;
    }

    public static void displayStatus() {
        System.out.println("📍 Current position: " + playerPosition);
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

        while (!gameStarted) {
            tryToStart();
            System.out.println();
        }

        displayStatus();

        while (!checkWin()) {
            System.out.print("Press Enter to roll the die...");
            scanner.nextLine();

            int roll = new RollDie().rollDie();
            System.out.println("🎲 You rolled: " + roll);

            if (playerPosition + roll > 100) {
                continue;
            } else {
                playerPosition += roll;
                System.out.println("Moved to position: " + playerPosition);

                if (playerPosition < 100) {
                    applySpecialRules();
                }
            }

            displayStatus();

            if (checkWin()) {
                if (playerPosition == 100) {
                    System.out.println("🏆 Congratulations! You reached exactly 100 and won the game!");
                }
            }

            System.out.println();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        playGame();
    }
}