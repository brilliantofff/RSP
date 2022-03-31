package src.com.company;

import java.util.Scanner;

public class Player {
    private final Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public Move processMove() {
        System.out.println("Choose your move:\n R for ROCK\n P for PAPER\n S for SCISSORS");
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
        System.out.println("INVALID MOVE");
        return processMove();
    }

    public boolean playAgain() {
        System.out.print("Play again?\n Y for YES \n any other key for NO");
        return scanner.nextLine().toUpperCase().charAt(0) == 'Y';
    }
}

