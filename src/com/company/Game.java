package src.com.company;

import java.io.PrintWriter;

public class Game {
    private final Player player;
    private final PcOpponent pcOpponent;
    private final PrintWriter printWriter;
    boolean isGameProcessing;

    public Game(PrintWriter printWriter, Player player, boolean flag) {
        this.printWriter = printWriter;
        this.isGameProcessing = flag;
        this.player = player;
        this.pcOpponent = new PcOpponent();
    }

    public void startGame() {
        printWriter.println("ROCK, PAPER, SCISSORS");
        Move playerMove = player.processMove();
        Move opponentMove = pcOpponent.processMove();
        printWriter.println("Your move: " + playerMove);
        printWriter.println("Opponent move: " + opponentMove);

        switch (playerMove.compareMoves(opponentMove)) {
            case 0 -> {
                printWriter.println("Draw, new round");
                printWriter.println("");
                printWriter.println("================================================================");
                printWriter.println("");
                startGame();
            }
            case 1 -> {
                printWriter.println(player.getName() + " WINS!");
                isGameProcessing = false;
            }
            case -1 -> {
                printWriter.println("Opponent victory!");
                isGameProcessing = false;
            }
        }
    }


}
