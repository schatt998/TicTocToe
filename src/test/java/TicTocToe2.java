import java.util.HashMap;

import static java.util.Arrays.asList;

public class TicTocToe2 {
    public static final String CROSS = "X";
    public static final String DOT = "O";
    private HashMap<Integer, String> board;

    public TicTocToe2(HashMap<Integer, String> board) {
        this.board = board;
    }

    public String getWinner() {
        if (isFirstRowFilledWithDots()) {
            return "Player Dot";
        }
        return "Player Cross";
    }

    private boolean isFirstRowFilledWithDots() {
        boolean isFirstRowFilled = true;
        for (Integer position : asList(0,1,2)) {
            isFirstRowFilled &= board.get(position).equals(DOT);
        }
        return isFirstRowFilled;
    }
}
