import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTocToeTest {

    @Test
    void shouldNotifyUserThatAlreadyFilledPositionIsNotAvailableForInput() {
        TicTocToe ticTocToe = new TicTocToe();
        Assertions.assertThrows(PositionIsAlreadyFilledException.class, () -> ticTocToe.getInput(2));
    }
}