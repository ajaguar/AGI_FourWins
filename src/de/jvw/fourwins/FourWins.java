package de.jvw.fourwins;

public class FourWins implements FourWinsLogic {

	private final static int COLUMNS = 7;
	private final static int ROWS = 6;

	private Chip[][] field = new Chip[COLUMNS][ROWS];

	@Override
	public Result throwChip(Chip chip, int column) {
		if (column >= COLUMNS || column < 0)
			return Result.INVALID;
		int row = 0;
		while (field[column][row] != null) {
			if (++row >= ROWS) {
				return Result.INVALID;
			}
		}
		field[column][row] = chip;

		Result result = Result.UNDECIDED;

		result = checkFourInColumn(chip, column, row);

		if (result != Result.WON) {
			result = checkFourInRow(chip, column, row);
		}

		if (result != Result.WON) {
			result = checkFourInDiagonal(chip, column, row);
		}

		return result;
	}

	private Result checkFourInRow(Chip chip, int column, int row) {
		int foundChipsInRow = 0;
		for (int i = 0; i < COLUMNS; i++) {
			if (field[i][row] == chip) {
				if (++foundChipsInRow >= 4) {
					return Result.WON;
				}
			} else {
				foundChipsInRow = 0;
			}
		}
		return Result.UNDECIDED;
	}

	private Result checkFourInColumn(Chip chip, int column, int row) {
		if (row - 3 >= 0) {
			for (int i = 1; i < 4; i++) {
				if (field[column][row - i] != chip) {
					return Result.UNDECIDED;
				}
			}
			return Result.WON;
		}
		return Result.UNDECIDED;
	}

	private Result checkFourInDiagonal(Chip chip, int column, int row) {
		int columnCheck = column;
		int rowCheck = row;
		Result result = Result.UNDECIDED;

		result = checkFourInDiagonalLeft(chip, columnCheck, rowCheck);
		if (result != Result.WON) {
			result = checkFourInDiagonalRight(chip, columnCheck, rowCheck);
		}
		return result;
	}

	private Result checkFourInDiagonalLeft(Chip chip, int columnCheck, int rowCheck) {
		while (rowCheck > 0 && columnCheck > 0) {
			rowCheck--;
			columnCheck--;
		}
		int foundChipsInDiagonal = 0;
		while (rowCheck < ROWS && columnCheck < COLUMNS) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= 4) {
					return Result.WON;
				}
			} else {
				foundChipsInDiagonal = 0;
			}
			rowCheck++;
			columnCheck++;
		}
		return Result.UNDECIDED;
	}
	
	private Result checkFourInDiagonalRight(Chip chip, int columnCheck, int rowCheck) {
		while (rowCheck < ROWS-1 && columnCheck > 0) {
			rowCheck++;
			columnCheck--;
		}
		int foundChipsInDiagonal = 0;
		while (rowCheck >= 0 && columnCheck < COLUMNS) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= 4) {
					return Result.WON;
				}
			} else {
				foundChipsInDiagonal = 0;
			}
			rowCheck--;
			columnCheck++;
		}
		return Result.UNDECIDED;
	}
}
