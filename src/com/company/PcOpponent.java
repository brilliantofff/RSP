package src.com.company;

import java.util.Random;

public class PcOpponent {

    public Move processMove() {
        Move[] moves = Move.values();
        return moves[new Random().nextInt(moves.length)];
    }
}
