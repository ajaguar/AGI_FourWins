package de.jvw.fourwins;

import org.junit.Test;

import junit.framework.TestCase;

public class TicTacToeTest extends TestCase {
	
	
	@Test
	public void testWinRows() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 0));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 1, 0));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 2, 0));
	}
	
	@Test
	public void testWinColumns() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 0));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 1));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 0, 2));
	}
	
	@Test
	public void testWinDiagonalRight() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 0));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 1, 1));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 2, 2));
	}
	
	@Test
	public void testWinDiagonalLeft() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 2, 2));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 1, 1));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 0, 0));
	}
	
	@Test
	public void testWinColumnsFromTop() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 2));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 0, 1));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 0, 0));
	}
	
	@Test
	public void testWinColumnsFromTopRight() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 2, 2));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 2, 1));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 2, 0));
	}
	
	@Test
	public void testWinRowsTop() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 2, 2));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 1, 2));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 0, 2));
	}
	
	@Test
	public void testWinRowsTopInvalid() {
		TicTacToeLogic ticTacToe = new MiniGame(GameType.TICTACTOE);
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 2, 2));
		assertEquals(Result.UNDECIDED, ticTacToe.setChip(Chip.RED, 1, 2));
		assertEquals(Result.WON, ticTacToe.setChip(Chip.RED, 0, 2));
		assertEquals(Result.INVALID, ticTacToe.setChip(Chip.RED, 2, 3));
	}
	
}
