import java.util.ArrayList;
import java.util.List;

public class TicTocToe {
    List<Integer> filledPositionByFirstPlayer = new ArrayList<>();
    List<Integer> filledPositionBySecondPlayer = new ArrayList<>();
    List<List<Integer>> filledPosition = new ArrayList<>();
    int counter;

    public TicTocToe() {
        this.counter = 0;
        filledPositionByFirstPlayer.add(9);
        filledPosition.add(filledPositionByFirstPlayer);
        filledPosition.add(filledPositionBySecondPlayer);
    }

    private void fillPosition(int playerNumber, int inputPosition) throws PositionIsAlreadyFilledException {
        if (filledPosition.get(playerNumber).contains(inputPosition))
            throw new PositionIsAlreadyFilledException();
        else {
            counter += 1;
            filledPosition.get(playerNumber).add(inputPosition);
        }
    }

    public void getInput(int inputPosition) throws PositionIsAlreadyFilledException {
        if (counter % 2 == 0) {
            fillPosition(0, inputPosition);

        } else {
            fillPosition(1, inputPosition);
        }
    }


    public String getWinner() {
        if (filledPositionByFirstPlayer.contains(1) && filledPositionByFirstPlayer.contains(2) && filledPositionByFirstPlayer.contains(3))
            return "Player One";
        if (filledPositionBySecondPlayer.contains(4) && filledPositionBySecondPlayer.contains(5) && filledPositionBySecondPlayer.contains(6))
            return "Player Two";
        else
            return null;
    }

}
