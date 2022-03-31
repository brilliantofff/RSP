package src.com.company;

public class Main {
    private final Player player = new Player();
    private final PcOpponent pcOpponent = new PcOpponent();

    public static void main(String[] args) {
        Main game = new Main();
        game.startGame();
    }

    public void startGame() {
        System.out.println("ROCK, PAPER, SCISSORS");
        Move playerMove = player.processMove();
        Move opponentMove = pcOpponent.processMove();
        System.out.println("Your move: " + playerMove);
        System.out.println("Opponent move: " + opponentMove);

        switch (playerMove.compareMoves(opponentMove)) {
            case 0 -> {
                System.out.println("Draw, new round");
                System.out.println('=' * 100);
                startGame();
            }
            case 1 -> System.out.println("Player victory!");
            case -1 -> System.out.println("Opponent victory!");
        }
    }
}
