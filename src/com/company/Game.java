package src.com.company;

import java.util.Stack;

public class Game {
    private static volatile Stack<Game> games = new Stack<>();
    private Player firstPlayer;
    private Player secondPlayer;
    private boolean isReady = false;

    public boolean isReady() {
        return isReady;
    }

    public static Game getGame() {
        if (games.empty()) {
            games.push(new Game());
        }
        return games.peek();
    }

    public void acceptPlayer(Player player) {
        if (firstPlayer == null) {
            firstPlayer = player;
        } else if (secondPlayer == null) {
            secondPlayer = player;
            isReady = true;
        }
    }

    public void startGame() {
        translateCommonMessage("ROCK, PAPER, SCISSORS");
        Move firstPlayerMove = firstPlayer.processMove();
        translateCommonMessage(firstPlayer.getName() + " has processed move");
        Move secondPlayerMove = secondPlayer.processMove();
        translateCommonMessage(secondPlayer.getName() + " has processed move");
        translateCommonMessage(firstPlayer.getName() + " move: " + firstPlayerMove);
        translateCommonMessage(secondPlayer.getName() + " move: " + secondPlayerMove);

        switch (firstPlayerMove.compareMoves(secondPlayerMove)) {
            case 0 -> {
                translateCommonMessage("Draw, new round");
                translateCommonMessage("");
                translateCommonMessage("================================================================");
                translateCommonMessage("");
                startGame();
            }
            case 1 -> translateCommonMessage(firstPlayer.getName() + " victory");

            case -1 -> translateCommonMessage(secondPlayer.getName() + " victory!");
        }
        games.pop();
    }

    private void translateCommonMessage(String message) {
        firstPlayer.getPrintWriter().println(message);
        secondPlayer.getPrintWriter().println(message);
    }
}
