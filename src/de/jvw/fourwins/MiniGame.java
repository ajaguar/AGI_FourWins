package de.jvw.fourwins;

public class MiniGame implements FourWinsLogic, TicTacToeLogic {

	private Chip[][] field;
	private GameType gameType;
	
	public MiniGame() {
		this.gameType = GameType.FOURWINS;
		field = new Chip[gameType.getCol()][gameType.getRows()];
	}
	
	public MiniGame(GameType gameType) {
		this.gameType = gameType;
		field = new Chip[gameType.getCol()][gameType.getRows()];
	}
	
	@Override
	public Result throwChip(Chip chip, int column) {
		System.out.println(this.gameType.getCol());
		if (column >= this.gameType.getCol() || column < 0)
			return Result.INVALID;
		int row = 0;
		while (field[column][row] != null) {
			if (++row >= this.gameType.getRows()) {
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
	
	@Override
	public Result setChip(Chip chip, int row, int col) {
		if(row >= gameType.getRows() || col >= gameType.getRows() || field[col][row] != null)
			return Result.INVALID;
		
		
		field[col][row] = chip;
		Result result = Result.UNDECIDED;
		
		result = checkFourInColumn(chip, col, row);

		if (result != Result.WON) {
			result = checkFourInRow(chip, col, row);
		}

		if (result != Result.WON) {
			result = checkFourInDiagonal(chip, col, row);
		}

		return result;
	}

	private Result checkFourInRow(Chip chip, int column, int row) {
		int foundChipsInRow = 0;
		for (int i = 0; i < this.gameType.getCol(); i++) {
			if (field[i][row] == chip) {
				if (++foundChipsInRow >= this.gameType.getWon()) {
					return Result.WON;
				}
			} else {
				foundChipsInRow = 0;
			}
		}
		return Result.UNDECIDED;
	}

	private Result checkFourInColumn(Chip chip, int column, int row) {
		int foundChipsInRow = 0;
		for (int i = 0; i < this.gameType.getRows(); i++) {
			if (field[column][i] == chip) {
				if (++foundChipsInRow >= this.gameType.getWon()) {
					return Result.WON;
				}
			} else {
				foundChipsInRow = 0;
			}
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
		while (rowCheck < this.gameType.getRows() && columnCheck < this.gameType.getCol()) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= this.gameType.getWon()) {
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
		while (rowCheck < this.gameType.getRows() -1 && columnCheck > 0) {
			rowCheck++;
			columnCheck--;
		}
		int foundChipsInDiagonal = 0;
		while (rowCheck >= 0 && columnCheck < this.gameType.getCol()) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= this.gameType.getWon()) {
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
