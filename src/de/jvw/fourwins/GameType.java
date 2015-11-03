package de.jvw.fourwins;

public enum GameType {

	FOURWINS(6, 7, 4), TICTACTOE(3, 3, 3);

	private int col;
	private int rows;
	private int won;

	private GameType(int rows, int col, int won) {
		this.rows = rows;
		this.col = col;
		this.won = won;
	}

	public int getCol() {
		return col;
	}

	public int getRows() {
		return rows;
	}

	public int getWon() {
		return won;
	}

}
