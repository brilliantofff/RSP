package src.com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Stack;

public class Player implements Runnable {
    public static volatile Stack<Player> players = new Stack<>();
    private Scanner scanner;
    private PrintWriter printWriter;

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public String getName() {
        return name;
    }

    private String name;

    public Player(Socket socket) {
        try {
            this.printWriter = new PrintWriter(socket.getOutputStream(), true);
            this.scanner = new Scanner(socket.getInputStream());
            printWriter.println("Enter player name");
            this.name = scanner.nextLine();
            players.push(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Game currentGame = Game.getGame();
        currentGame.acceptPlayer(this);
        boolean isReady = false;
        printWriter.println("Searching for your opponent");
        while (!isReady) {
            isReady = currentGame.isReady();
        }
        currentGame.startGame();
    }

    public Move processMove() {
        printWriter.println("Choose your move:");
        printWriter.println("R for ROCK");
        printWriter.println("P for PAPER");
        printWriter.println("S for SCISSORS");
        char input = scanner.nextLine().toUpperCase().charAt(0);
        if (input == 'R' || input == 'P' || input == 'S') {
            switch (input) {
                case 'R':
                    return Move.ROCK;
                case 'P':
                    return Move.PAPER;
                case 'S':
                    return Move.SCISSORS;
            }
        }
        printWriter.println("INVALID MOVE");
        return processMove();
    }
}
