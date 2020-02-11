import java.util.HashMap;

public class TicTocToe2 {
    public static final String CROSS = "X";
    public static final String DOT = "O";
    private HashMap<Integer, String> board;

    public TicTocToe2(HashMap<Integer, String> board) {
        this.board = board;
    }

    public String getWinner() {
        if (board.get(0).equals(DOT) && board.get(1).equals(DOT) && board.get(2).equals(DOT)) {
            return "Player Dot";
        }
        return "Player Cross";
    }
}
