import java.util.HashMap;

public class TicTocToe2 {
    private HashMap<Integer, String> board;

    public TicTocToe2(HashMap<Integer, String> board) {
        this.board = board;
    }

    public String getWinner() {
        if (board.get(0).equals("O") && board.get(1).equals("O") && board.get(2).equals("O")) {
            return "Player Dot";
        }
        return "Player Cross";
    }
}
