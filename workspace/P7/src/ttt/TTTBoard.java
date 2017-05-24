package ttt;

/**
 * Represents the state of a tic-tac-toe board.  This specification
 * assumes that you know how to play tic-tac-toe.  Consult
 * Wikipedia if you don't.
 * 
 * A tic-tac-toe board consists of nine squares, numbered like this:
 * 
 *   1 | 2 | 3
 *  ---+---+---
 *   4 | 5 | 6
 *  ---+---+---
 *   7 | 8 | 9
 *   
 * Each square can be unoccupied, contain an X, or contain an O.
 * 
 * Beginning from an empty board, the players take turns moving until
 * X wins, O wins, or there is a draw.  X always moves first.
 * 
 * In addition, a tic-tac-toe board knows how many times X has won,
 * how many times O has won, and how many times there has been a draw.
 *
 */
public class TTTBoard {
	
	private int turnNum;
	private int xwins;
	private int ywins;
	private int catsgame;
	private String[] boxValues;

	
	/**
	 * Constructs an empty board in which X has won zero times, Y has won
	 * zero times, and there have been no draws.
	 */
	public TTTBoard () {
		turnNum = 0;
		xwins = 0;
		ywins = 0;
		catsgame = 0;
		boxValues = new String[9];
	}
	
	
	/**
	 * If the current position is a win for X, a win for Y, or a draw, throws
	 * an IllegalArgumentException.
	 * 
	 * If the specified square is already occupied, throws
	 * an IllegalArgumentException.
	 * 
	 * If square is invalid (less than 1 or greater than 9), throws
	 * an IllegalArgumentException.
	 * 
	 * Otherwise, if it is X's turn to move, records an X move to the specified
	 * square and returns "X".  If it is O's turn to move, records an O move to
	 * the specified square and returns "O".  If the move makes the position
	 * a win for X, the "wins for X" count is incremented.  If the move makes
	 * the position a win for O, the "wins for O" count is incremented.  If the
	 * move makes the position a draw, the "draws" count is incremented.
	 */
	public String move (int square) {
		if (isDrawn() || isWon()){
			throw new IllegalArgumentException();
		}
		if (boxValues[square-1] == "X" || boxValues[square-1] == "O" ){
			throw new IllegalArgumentException();
		}
		if (square < 1 || square > 9){
			throw new IllegalArgumentException();
		}
		if (getToMove() == "X"){
			turnNum++;
			boxValues [square-1] = "X";
			if (xwins()){
				xwins++;
			}
			return "X";
		}
		
		else{
			turnNum++;
			boxValues [square-1] = "O";
			if (Owins()){
				ywins++;
			}
			return "O";
		}
		
	}
	
	
	/**
	 * Returns "X" (if it is X's turn to move) or "O" (otherwise).
	 */
	public String getToMove () {
		if (turnNum%2 == 0){
			return "X";
		}
		else{
			
			return "O";
		}
	}
	
	
	/**
	 * Reports whether or not the board has a drawn position (all squares
	 * filled in, neither X nor O has three in a row).
	 */
	public boolean isDrawn () {
		if (turnNum == 9){
		return !isWon();
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * Reports whether or not the board has a won position (either X or O
	 * has three in a row).
	 */
	public boolean isWon () {
		if (xwins() || Owins()){
			return true;
		}
		else{
		return false;
		}
	}
	
	
	/**
	 * Resets the board so that a fresh game can be played.  Does
	 * not modify the scoring records.
	 */
	public void reset () {
		turnNum = 0;
		boxValues = new String[9];
	}
	
	
	/**
	 * Returns the number of games that X has won.
	 */
	public int getXWins () {
		return xwins;
	}
	
	
	/**
	 * Returns the number of games that O has won.
	 */
	public int getOWins () {
		return ywins;
	}
	
	
	/**
	 * Returns the number of games that have been drawn.
	 */
	public int getDrawCount () {
		return catsgame;
	}
	private boolean xwins(){
		if (boxValues[0] == "X" && boxValues[1] == "X" && boxValues[2] == "X"){
			return true;
		}
		if (boxValues[3] == "X" && boxValues[4] == "X" && boxValues[5] == "X"){
			return true;
		}
		if (boxValues[6] == "X" && boxValues[7] == "X" && boxValues[8] == "X"){
			return true;
		}
		if (boxValues[0] == "X" && boxValues[3] == "X" && boxValues[6] == "X"){
			return true;
		}
		if (boxValues[1] == "X" && boxValues[4] == "X" && boxValues[7] == "X"){
			return true;
		}
		if (boxValues[2] == "X" && boxValues[5] == "X" && boxValues[8] == "X"){
			return true;
		}
		if (boxValues[0] == "X" && boxValues[4] == "X" && boxValues[8] == "X"){
			return true;
		}
		if (boxValues[2] == "X" && boxValues[4] == "X" && boxValues[6] == "X"){
			return true;
		}
		return false;
	}
	private boolean Owins(){
		if (boxValues[0] == "O" && boxValues[1] == "O" && boxValues[2]== "O"){
			return true;
		}
		if (boxValues[3] == "O" && boxValues[4] == "O" && boxValues[5] == "O"){
			return true;
		}
		if (boxValues[6] == "O" && boxValues[7] == "O" && boxValues[8] == "O"){
			return true;
		}
		if (boxValues[0] == "O" && boxValues[3] == "O" && boxValues[6]== "O"){
			return true;
		}
		if (boxValues[1] == "O" && boxValues[4] == "O" && boxValues[7] == "O"){
			return true;
		}
		if (boxValues[2] == "O" && boxValues[5] == "O" && boxValues[8] == "O"){
			return true;
		}
		if (boxValues[0] == "O" && boxValues[4] == "O" && boxValues[8] == "O"){
			return true;
		}
		if (boxValues[2] == "O" && boxValues[4] == "O" && boxValues[6] == "O"){
			return true;
		}
		return false;
	}	
}
