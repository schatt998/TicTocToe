import java.util.ArrayList;
import java.util.List;

public class TicTocToe {
    List<Integer> filledPositionByFirstPlayer = new ArrayList<>();
    List<Integer> filledPositionBySecondPlayer = new ArrayList<>();
    int counter;

    public TicTocToe() {
        this.counter = 0;
        filledPositionByFirstPlayer.add(9);
    }

    public void getInput(int inputPosition) throws PositionIsAlreadyFilledException {
        if (counter % 2 == 0) {
            if (filledPositionByFirstPlayer.contains(inputPosition))
                throw new PositionIsAlreadyFilledException();
            else {
                counter += 1;
                filledPositionByFirstPlayer.add(inputPosition);
            }
        } else {
            if (filledPositionBySecondPlayer.contains(inputPosition))
                throw new PositionIsAlreadyFilledException();
            else {
                counter += 1;
                filledPositionBySecondPlayer.add(inputPosition);
            }
        }
    }


    public String getWinner() {
        if (filledPositionByFirstPlayer.contains(1) && filledPositionByFirstPlayer.contains(2) && filledPositionByFirstPlayer.contains(3))
            return "Player One";
        else
            return "Player B";
    }
}
