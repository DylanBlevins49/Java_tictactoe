// Dylan Blevins
// Tic Tac toe utilizing player and gameboard classes and objects
import java.util.*;
public class Main {

    /* Method to swap turns */
    public static void swapTurn(Player human, Player cpu){
        human.setTurn(!human.isTurn());
        cpu.setTurn(!cpu.isTurn());
    }
    public static void main(String[] args) {

        /* Take user input to determine the values for their player class*/
        System.out.println("Welcome to Tic Tac Toe!\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String playerName = input.nextLine();
        int turn = 0;
        char cpuSign = 'O';
        char playerSign = 'X';
        String playerTurn = "";


        /* Assign sign value to cpu based upon players choice */
        while (true){
            System.out.println("Would you like to be 'X' or 'O' ");
            playerSign = input.nextLine().charAt(0);
            if (playerSign == 'X' || playerSign == 'x') {
                cpuSign = 'O';
                break;
            } else if (playerSign == 'O' || playerSign == 'o') {
                cpuSign = 'X';
                break;
            } else{
                System.out.println("Please enter a valid character\n");
                continue;
            }
        }

        /* Generate Human based on user input */
        Player human = new Player(playerName, playerSign);

        /* Generate CPU player based upon the user input */
        Player cpu = new Player("CODEy", cpuSign);

        /* Assign first turn based upon user input */
        while (true){
            System.out.println("Would you like to go first or have your opponent go first? \nEnter 1 to go first:  \nEnter 2 to have opponent go first: ");
            playerTurn = input.nextLine();
            if (playerTurn.equals("1")){
                human.setTurn(!human.isTurn());
                break;
            } else if (playerTurn.equals("2")){
                cpu.setTurn(!cpu.isTurn());
                break;
            } else{
                System.out.println("Please enter a valid number\n");
                continue;
            }
        }


        /* Make a blank board for console printing purposes */
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'},
        };

        /* Creates new game board object and prints it */
        GameBoard gameBoard = new GameBoard(board);
        System.out.println(gameBoard);




        /* while loop to continuously iterate and print board while less than 9 turns have happened */
        while (turn <= 9) {
            if (human.isTurn()){ // method for human player

                /* Take input from the user to place their sign */
                System.out.println("Select coordinate for your move. Start with the row (0,1,2): ");
                int rowPlace = input.nextInt();
                System.out.println("Now select which column(0,1,2): ");
                int columnPlace = input.nextInt();

                /* assigns the player sign to the chosen index value checks if the move is valid and swaps turns */
                if (rowPlace > 2 || columnPlace > 2){
                    System.out.println("That is not a valid move!\n");
                    continue;
                }
                else if (gameBoard.getBoard()[rowPlace][columnPlace] == '_') {
                    gameBoard.setBoard(rowPlace, columnPlace, playerSign);
                    turn++;
                    System.out.println(gameBoard);
                    swapTurn(human , cpu);
                }
                else {
                    // Iterates back through loop if placement is not valid
                    System.out.println("That space is already taken please try again! \n");
                    System.out.println(gameBoard);
                    continue;
                }

                /*Checks if there is a winner after every player turn */
                if (gameBoard.hasWinner(true)) {
                    System.out.println(playerName + " is a winner!\n");

                    /*Asks the user if they would like to play again. Either restarts the loop to play again, or exits and prints game data*/
                    System.out.println("Would you like to play again?\n");
                    System.out.println("Enter 1 for yes:\nEnter 2 for no:");

                    // Sets values according to winner
                    human.setGamesWon(human.getGamesWon() + 1 );
                    human.setGamesPlayed(human.getGamesPlayed()+1);
                    cpu.setGamesPlayed(cpu.getGamesWon()+1);
                    cpu.setGameLost(cpu.getGameLost()+1);

                    int playAgain = input.nextInt();
                    if (playAgain == 1){
                        gameBoard.resetBoard();
                        System.out.println(gameBoard);
                        turn = 0;
                    } else{ //ends game and prints game data
                        System.out.println(playerName + " you Played " + human.getGamesPlayed() + " Total Games\nYou Won " + human.getGamesWon() + " Games.\nYou Lost " + human.getGameLost() + " Games\nYou Tied "+ human.getGamesTied() +" Games.");
                        break;
                    }
                }
            }





            else { // method for cpu player

                /* Generates a randomly placed sign for computer player */
                Random rand = new Random();
                int row = rand.nextInt(3);
                int column = rand.nextInt(3);

                // Random placement assignment for computer player
                if (gameBoard.getBoard()[row][column] == '_') {
                    gameBoard.setBoard(row, column, cpuSign);
                    turn++;
                    System.out.println("The computer chose " + "Row " + row + ", " + "Column " + column + ".");
                    System.out.println(gameBoard);
                    swapTurn(human, cpu);
                } else {
                    continue;
                }
                // Checks if there is a winner after every computer turn
                if (gameBoard.hasWinner(true)) {

                    System.out.println(cpu.getName() + " is a winner!\n");

                    // asks user if the want to play again
                    System.out.println("Would you like to play again?\n");
                    System.out.println("Enter 1 for yes:\nEnter 2 for no:");

                    // Sets values according to winner
                    human.setGamesPlayed(human.getGamesPlayed()+1);
                    human.setGameLost(human.getGameLost()+1);
                    cpu.setGamesWon(cpu.getGamesWon()+1);
                    cpu.setGamesPlayed(cpu.getGamesPlayed()+1);

                    int playAgain = input.nextInt();
                    if (playAgain == 1){
                        gameBoard.resetBoard();
                        System.out.println(gameBoard);
                        turn = 0;
                    } else{ // ends the game and prints game data
                        System.out.println(playerName + " you Played " + human.getGamesPlayed() + " Total Games\nYou Won " + human.getGamesWon() + " Games.\nYou Lost " + human.getGameLost() + " Games\nYou Tied "+ human.getGamesTied() +" Games.");
                        break;
                    }
                }
            }




            /* assigns a tie if 9 turns are played and no one wins */
            if (turn == 9 || gameBoard.hasWinner(false)) {
                System.out.println("The game is a draw");

                // Assigns values based on game outcome
                cpu.setGamesTied(cpu.getGamesTied()+1);
                cpu.setGamesPlayed(cpu.getGamesPlayed()+1);
                human.setGamesTied(human.getGamesTied()+1);
                human.setGamesPlayed(human.getGamesPlayed()+1);

                // asks the use if they would like to play again
                System.out.println("Would you like to play again?\n");
                System.out.println("Enter 1 for yes:\nEnter 2 for no:");
                int playAgain = input.nextInt();
                if (playAgain == 1){
                    gameBoard.resetBoard();
                    System.out.println(gameBoard);
                    turn = 0;
                } else{ // ends game and prints game data if they choose not to play again
                    System.out.println(playerName + " you Played " + human.getGamesPlayed() + " Total Games\nYou Won " + human.getGamesWon() + " Games.\nYou Lost " + human.getGameLost() + " Games\nYou Tied "+ human.getGamesTied() +" Games.");
                    break;
                }
            }
        }
    }
}
