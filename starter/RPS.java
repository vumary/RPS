
/**
 * TODO: Add your file header
 * Name: Mary Vu
 * ID: A17081683
 * Email: m2vu@ucsd.edu
 * Sources used: None
 * 
 * This file contains the RPS class which is responsible for initializing the fields 
 * used in the game and has a method which determines the winner of each RPS game. 
 * Moreover, this file contains the main method which runs the game on the terminal.
 */

import java.util.Scanner;

/**
 * TODO: Add your class header (purpose and capabilities of the class)
 * The RPS class initializes fields necessary for the game to run and is
 * capable of running the game in the terminal.
 */
public class RPS extends RPSAbstract {

    /**
     * TODO: Add method header
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    /**
     * Takes the user move, the CPU move, and determines who wins.
     * 
     * @param playerMove - move of the player
     * @param cpuMove    - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */
    public int determineWinner(String playerMove, String cpuMove) {
        // TODO
        int playerMoveIndex = 0;
        int cpuMoveIndex = 0;
        for (int i = 0; i < possibleMoves.length; i++) {
            if (possibleMoves[i].equals(playerMove)) {
                playerMoveIndex = i;
            }
            if (possibleMoves[i].equals(cpuMove)) {
                cpuMoveIndex = i;
            }
        }
        if (!(isValidMove(playerMove) && isValidMove(cpuMove))) {
            return INVALID_INPUT_OUTCOME;
        }
        if (playerMoveIndex == possibleMoves.length - 1) {
            if (cpuMoveIndex == 0) {
                return PLAYER_WIN_OUTCOME;
            }
        }
        if (playerMoveIndex == cpuMoveIndex - 1) {
            return PLAYER_WIN_OUTCOME;
        }
        if (cpuMoveIndex == possibleMoves.length - 1) {
            if (playerMoveIndex == 0) {
                return CPU_WIN_OUTCOME;
            }
        }
        if (cpuMoveIndex == playerMoveIndex - 1) {
            return CPU_WIN_OUTCOME;
        }
        return TIE_OUTCOME;
    }

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game

        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work!
        boolean quit = false;
        String playerMove;
        while (!quit) {
            System.out.println(PROMPT_MOVE);
            playerMove = in.nextLine();
            if (playerMove.equals(QUIT)) {
                quit = true;
            } else {
                game.play(playerMove, game.genCPUMove());
            }
        }
        game.end();
        in.close();
    }
}
