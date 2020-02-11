import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class Blah {
    public static final String CROSS = "X";
    public static final String DOT = "O";
    public static final List<Integer> FIRST_ROW = asList(0, 1, 2);
    public static final List<Integer> SECOND_ROW = asList(3, 4, 5);
    public static final List<Integer> THIRD_ROW = asList(6, 7, 8);
    public static final List<List<Integer>> ALL_ROWS = asList(FIRST_ROW, SECOND_ROW, THIRD_ROW);
    private HashMap<Integer, String> board;

    public Blah(HashMap<Integer, String> board) {
        this.board = board;
    }

    public String getWinner() {
        if (isAnyRowFilledWithDots()) {
            return "Player Dot";
        }
        return "Player Cross";
    }

    private boolean isAnyRowFilledWithDots() {
        boolean isAnyRowFilled = false;
        for (List<Integer> row : ALL_ROWS) {
            isAnyRowFilled |= isRowFilledWithDots(row);

        }
        return isAnyRowFilled;
    }

    private boolean isRowFilledWithDots(List<Integer> row) {
        boolean isFirstRowFilled = true;
        for (Integer position : row) {
            isFirstRowFilled &= hasAnyMarker(position) && board.get(position).equals(DOT); // short circuit
        }
        return isFirstRowFilled;
    }

    private boolean hasAnyMarker(Integer position) { // TODO - does this indicate that the board may have some behavior?
        return board.get(position) != null;
    }
}
