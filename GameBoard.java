public class GameBoard {
    private char[][] board;
    private boolean hasWinner;
    private boolean hasOpenTurn;

    /* Constructor method */
    public GameBoard(char[][] board) {
        this.board = board;
    }

    /* Getter method */
    public char[][] getBoard() {
        return board;
    }
    public void setBoard(int row , int column, char sign){
        this.board[row][column]= sign;
    }
    /* resetter Method */
    public char[][] resetBoard() {
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'},
        };
        this.board = board;
        return this.board;
    }

    /* method to check each row of board to determine if there is a winner*/
    public boolean hasWinner(boolean winner) {

        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[0][0] == board[1][0] &&  board[1][0] == board[2][0] && board[0][0] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_') {
            hasWinner = true;
            return hasWinner;
        } else if (board[0][2] == board[1][1] && board[1][1]== board[2][0] && board[0][2] != '_') {
            hasWinner = true;
            return hasWinner;
        } else {
            hasWinner = false;
            return hasWinner;
        }
    }




    /* to string method for printing the gameBoard */
    @Override
    public String toString(){
        String gameBoard = "";
        for (int row = 0; row < board.length; row++){

            for (int column = 0; column < board.length; column++){
                if (column < 2)
                    gameBoard += board[row][column] + " | ";
                else
                    gameBoard += board[row][column] + " ";
            }
            gameBoard += "\n";
        }
        return gameBoard;
    }

}