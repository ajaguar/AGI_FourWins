package de.jvw.fourwins;

import org.junit.Test;

import junit.framework.TestCase;

public class FourWinsTest extends TestCase {

	@Test
	public void testThrowChipLeft() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 0));
	}
	
	@Test
	public void testThrowChipRight() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.BLUE, 6));
	}
	
	@Test
	public void testThrowChipColumnFull() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		
	}
	
	@Test
	public void testThrowChipColumnOverflow() {
		FourWins fourWins = new FourWins();
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
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 0));
	}
	
	@Test
	public void testThrowChipRightTop() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.BLUE, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 6));
	}
	
	@Test
	public void testThrowChipHorizontalLeft() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 0));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 3));
	}
	
	@Test
	public void testThrowChipHorizontalRight() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 6));
	}
	
	@Test
	public void testThrowChipHorizontalRightOverflow() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.INVALID, fourWins.throwChip(Chip.RED, 7));
	}
	@Test
	public void testThrowChipHorizontalLeftMinimumOverflow() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.INVALID, fourWins.throwChip(Chip.RED, -1));
	}
	
	@Test
	public void testThrowChipHorizontalMiddle() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 3));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 4));
	}
	
	@Test
	public void testThrowChipHorizontalMiddleMoreThanFour() {
		FourWins fourWins = new FourWins();
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 1));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 2));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 4));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 5));
		assertEquals(Result.UNDECIDED, fourWins.throwChip(Chip.RED, 6));
		assertEquals(Result.WON, fourWins.throwChip(Chip.RED, 3));
	}
	
	@Test
	public void testThrowChipHorizontalLeftTop() {
		FourWins fourWins = new FourWins();
		for (int i = 0; i<3; i++) {
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
		FourWins fourWins = new FourWins();
		for (int i = 6; i>3; i--) {
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
		FourWins fourWins = new FourWins();
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
		FourWins fourWins = new FourWins();
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
		FourWins fourWins = new FourWins();
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
