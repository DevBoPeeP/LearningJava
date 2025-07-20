public class RollDie {
    private static final int SIDES = 6;

    public static int roll() {
        return (int) (Math.random() * SIDES) + 1;
    }
    public int rollDie() {
        int rollResult = roll();
        return rollResult;
    }


    public static void main(String[] args) {
        System.out.println ("Rolling a die... ");

        RollDie die = new RollDie();
        die.rollDie();
    }
}
