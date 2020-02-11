import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class TicTocToe2 {
    public static final String CROSS = "X";
    public static final String DOT = "O";
    public static final List<Integer> FIRST_ROW = asList(0, 1, 2);
    public static final List<Integer> SECOND_ROW = asList(3, 4, 5);
    private HashMap<Integer, String> board;

    public TicTocToe2(HashMap<Integer, String> board) {
        this.board = board;
    }

    public String getWinner() {
        if (isFirstRowFilledWithDots()) {
            return "Player Dot";
        }
        if (isSecondRowFilledWithDots()) {
            return "Player Dot";
        }
        return "Player Cross";
    }

    private boolean isFirstRowFilledWithDots() {
        boolean isFirstRowFilled = true;
        for (Integer position : FIRST_ROW) {
            isFirstRowFilled &= hasAnyMarker(position) && board.get(position).equals(DOT); // short circuit
        }
        return isFirstRowFilled;
    }

    private boolean isSecondRowFilledWithDots() {
        boolean isFirstRowFilled = true;
        for (Integer position : SECOND_ROW) {
            isFirstRowFilled &= hasAnyMarker(position) && board.get(position).equals(DOT); // short circuit
        }
        return isFirstRowFilled;
    }

    private boolean hasAnyMarker(Integer position) { // TODO - does this indicate that the board may have some behavior?
        return board.get(position) != null;
    }
}
