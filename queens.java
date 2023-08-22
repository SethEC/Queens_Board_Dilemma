import java.util.Arrays;

/**
 * queens
 */
public class queens {

    public static void main(String[] args) {
        
        int size = 0;

        try {           
            if(args.length == 1){
                size = Integer.parseInt(args[0]);
                int[][] board = new int[size][size];

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        board[i][j] = 0;
                    }
                }
                solve(board, 0, size);
            }
            else{
                System.out.println("Usage: queens [int]");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("Usage: queens [int]");
        }
    }

    private static void solve(int[][] board, int xPos, int size){
        
        if (xPos == size){
            print(board);
            return;
        }

        for(int y = 0; y < size; y++){

            if (board[xPos][y] < 1) {
                solve(remove(board, xPos, y, size), xPos + 1, size);
            }
        }
        return;
    }

    private static int[][] remove(int[][] board, int xPos, int yPos, int size){

        int[][] boardClone = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
        boardClone[xPos][yPos] = 2;

        for (int i = 1; xPos + i < size; i++) {
            
            boardClone[xPos + i][yPos] = 1;

            if (yPos - i >= 0){ 
                boardClone[xPos + i][yPos - i] = 1;
            }

            if (yPos + i < size){
                boardClone[xPos + i][yPos + i] = 1;
            }
        }
        
        return boardClone;
    }

    private static void print(int[][] board){
        
        for(int[] xPos : board) {
            for (int yPos : xPos) {
                System.out.print(yPos + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}