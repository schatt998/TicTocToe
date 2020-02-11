import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicTocToeTest {

    public static final List<Integer> FIRST_COLUMN = asList(0, 3, 6);

    @Test
    void shouldNotifyUserThatAlreadyFilledPositionIsNotAvailableForInput() {
        TicTocToe ticTocToe = new TicTocToe();
        Assertions.assertThrows(PositionIsAlreadyFilledException.class, () -> ticTocToe.getInput(9));
    }
    //TODO Question  ,if top down approach introduces primitive obsession.

    @Test
    void shouldDeclarePlayerCrossAsWinnerIfItFillsFirstRowBeforePlayerDot() { //
        HashMap<Integer, String> board = new HashMap<>();
        markBoard(board, TicTocToe2.CROSS, TicTocToe2.FIRST_ROW);
        markBoard(board, TicTocToe2.DOT, 4, 7); // TODO - could this be simpler?
        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Cross", actualWinner); // TODO - Player Cross is still a magic literal
    }

    @Test
    void shouldDeclarePlayerDotAsWinnerIfItFillsFirstColumnBeforePlayerCross() { //
        HashMap<Integer, String> board = new HashMap<>();
        markBoard(board, TicTocToe2.CROSS, 4, 7, 8);
        markBoard(board, TicTocToe2.DOT, TicTocToe2.FIRST_ROW);
        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Dot", actualWinner); // TODO - Player Cross is still a magic literal
    }

    @Test
    void shouldDeclarePlayerCrossAsWinnerIfItFillsSecondRowBeforePlayerDot() { //
        HashMap<Integer, String> board = new HashMap<>();
        markBoard(board, TicTocToe2.CROSS, TicTocToe2.SECOND_ROW);
        markBoard(board, TicTocToe2.DOT, 1, 2);
        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Cross", actualWinner); // TODO - Player Cross is still a magic literal
    }

    @Test
    void shouldDeclarePlayerDotAsWinnerIfItFillsSecondRowBeforePlayerCross() { //
        HashMap<Integer, String> board = new HashMap<>();
        markBoard(board, TicTocToe2.DOT, TicTocToe2.SECOND_ROW);
        markBoard(board, TicTocToe2.CROSS, 1, 2);
        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Dot", actualWinner); // TODO - Player Cross is still a magic literal
    }

    @Test
    void shouldDeclarePlayerDotAsWinnerIfItFillsThirdRowBeforePlayerCross() { //
        HashMap<Integer, String> board = new HashMap<>();
        markBoard(board, TicTocToe2.DOT, TicTocToe2.THIRD_ROW);
        markBoard(board, TicTocToe2.CROSS, 1, 2);
        TicTocToe2 ticTocToe = new TicTocToe2(board); // TODO - really unhappy - specifying empty strings is really confusing - am I doing primitive obsession here?

        String actualWinner = ticTocToe.getWinner();

        Assertions.assertEquals("Player Dot", actualWinner); // TODO - Player Cross is still a magic literal
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

    // TODO - duplication in helper methods...
    private void markBoard(HashMap<Integer, String> board, String marker, int... positions) {
        for (int position : positions) {
            board.put(position, marker);
        }
    }

    private void markBoard(HashMap<Integer, String> board, String marker, List<Integer> positions) {
        for (int position : positions) {
            board.put(position, marker);
        }
    }


}