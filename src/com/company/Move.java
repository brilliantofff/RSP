package src.com.company;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public int compareMoves(Move otherMove) {
        if (this == otherMove)
            return 0;

        return switch (this) {
            case ROCK -> (otherMove == SCISSORS ? 1 : -1);
            case PAPER -> (otherMove == ROCK ? 1 : -1);
            case SCISSORS -> (otherMove == PAPER ? 1 : -1);
        };
    }
}