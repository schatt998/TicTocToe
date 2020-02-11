import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicTocToeTest {

    public static final String X = "X";
    public static final String O = "O";

    @Test
    void shouldNotifyUserThatAlreadyFilledPositionIsNotAvailableForInput() {
        TicTocToe ticTocToe = new TicTocToe();
        Assertions.assertThrows(PositionIsAlreadyFilledException.class, () -> ticTocToe.getInput(9));
    }

    @Test
        // TODO - whose player A? - PLayer cross now.
    void shouldDeclarePlayerOneAsWinnerIfItFillsARowBeforePlayerTwo2() { // TODO - inconsistency - PlayerOne vs Player A

        HashMap<Integer, String> board = new HashMap<>();
        board.put(0, X);
        board.put(1, X);
        board.put(2, X);

        board.put(4, O);
        board.put(7, O);

        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?
        // TODO - I represent unmarked spaces as empty strings. Its inconvinent.
        // TODO - difficult to see the indexes.

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Cross", actualWinner); // TODO - where did player A come from? this is a magic literal?
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

    @Test
    void shouldDeclarePlayerTwoAsWinnerIfItFillsARowBeforePlayerOne() throws PositionIsAlreadyFilledException {
        TicTocToe ticTocToe = new TicTocToe();
        Player playerOne = mock(Player.class);
        Player playerTwo = mock(Player.class);

        when(playerOne.giveInput()).thenReturn(1, 2, 8);
        when(playerTwo.giveInput()).thenReturn(4, 5, 6);

        ticTocToe.getInput(playerOne.giveInput());
        ticTocToe.getInput(playerTwo.giveInput());
        ticTocToe.getInput(playerOne.giveInput());
        ticTocToe.getInput(playerTwo.giveInput());
        ticTocToe.getInput(playerOne.giveInput());
        ticTocToe.getInput(playerTwo.giveInput());

        String winner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Two", winner);


    }


}