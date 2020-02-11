import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicTocToeTest {

    @Test
    void shouldNotifyUserThatAlreadyFilledPositionIsNotAvailableForInput() {
        TicTocToe ticTocToe = new TicTocToe();
        Assertions.assertThrows(PositionIsAlreadyFilledException.class, () -> ticTocToe.getInput(9));
    }

    @Test
    void shouldDeclarePlayerOneAsWinnerIfItFillsARowBeforePlayerTwo() throws PositionIsAlreadyFilledException {
        TicTocToe ticTocToe = new TicTocToe();
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);

        when(playerOne.giveInput()).thenReturn(1, 2, 3);
        when(playerTwo.giveInput()).thenReturn(4, 5);

        ticTocToe.getInput(playerOne.giveInput());
        ticTocToe.getInput(playerTwo.giveInput());
        ticTocToe.getInput(playerOne.giveInput());
        ticTocToe.getInput(playerTwo.giveInput());
        ticTocToe.getInput(playerOne.giveInput());

        String winner = ticTocToe.getWinner();

        Assertions.assertEquals("Player One", winner);


    }
}