import java.util.ArrayList;
import java.util.List;

public class TicTocToe {
    List<Integer> filledPosition = new ArrayList<>();

    public void getInput(int inputPosition) throws PositionIsAlreadyFilledException {
        filledPosition.add(2);
        if (filledPosition.contains(inputPosition)) {
            throw new PositionIsAlreadyFilledException();
        }
    }
}
