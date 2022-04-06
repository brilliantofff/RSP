package src.com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
    public String getName() {
        return name;
    }

    private final String name;
    private final Scanner scanner;
    private final PrintWriter printWriter;

    public Player(String name,Scanner scanner, PrintWriter printWriter) {
        this.name = name;
        this.scanner = scanner;
        this.printWriter = printWriter;
    }

    public static Player registerPlayer(Scanner in, PrintWriter out) {
        String name = "";
        while (name.isBlank() || name.length() > 8) {
            out.println("Enter player name");
            name = in.nextLine();
        }
        return new Player(name, in, out);
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

    public boolean playAgain() {
        printWriter.print("Play again?\n Y for YES \n any other key for NO");
        return scanner.nextLine().toUpperCase().charAt(0) == 'Y';
    }
}

