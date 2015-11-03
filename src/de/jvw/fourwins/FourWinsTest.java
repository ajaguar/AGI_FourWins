package de.jvw.fourwins;

import org.junit.Test;

import junit.framework.TestCase;

public class FourWinsTest extends TestCase {

	@Test
	public void testThrowChipLeft() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 0));
	}

	@Test
	public void testThrowChipRight() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 6));
	}

	@Test
	public void testThrowChipColumnFull() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));

	}

	@Test
	public void testThrowChipColumnOverflow() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.INVALID, fourWins.throwChip(Chip.BLUE, 6));
	}

	@Test
	public void testThrowChipLeftTop() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 0));
	}

	@Test
	public void testThrowChipRightTop() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 6));
	}

	@Test
	public void testThrowChipHorizontalLeft() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 3));
	}

	@Test
	public void testThrowChipHorizontalRight() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 6));
	}

	@Test
	public void testThrowChipHorizontalRightOverflow() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.INVALID, fourWins.throwChip(Chip.RED, 7));
	}

	@Test
	public void testThrowChipHorizontalLeftMinimumOverflow() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.INVALID, fourWins.throwChip(Chip.RED, -1));
	}

	@Test
	public void testThrowChipHorizontalMiddle() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 4));
	}

	@Test
	public void testThrowChipHorizontalMiddleMoreThanFour() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 3));
	}

	@Test
	public void testThrowChipHorizontalLeftTop() {
		FourWinsLogic fourWins = new MiniGame();
		for (int i = 0; i < 3; i++) {
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
		}
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 3));
	}

	@Test
	public void testThrowChipHorizontalRightTop() {
		FourWinsLogic fourWins = new MiniGame();
		for (int i = 6; i > 3; i--) {
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
			assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, i));
		}
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 3));
	}

	@Test
	public void testThrowChipDiagonalBottomLeft() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 3));
	}

	@Test
	public void testThrowChipDiagonalBottomLeftMiddle() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 2));
	}

	@Test
	public void testThrowChipDiagonalBottomRightMiddle() {
		FourWinsLogic fourWins = new MiniGame();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 4));
	}
}
