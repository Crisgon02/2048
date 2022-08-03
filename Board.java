/**
 * Name: Cristian Gonzalez Paqui
 * PennKey: CrisGon
 * Execution: No execution, used in Game.java 
 * 
 * Description: The Board class will be used in Game.java and consists 
 *              of many methods that make the Tiles move, merge, check
 *              for when the board is full, if there is a winner, and if 
 *              there are still legal moves that can be made. 
 */
public class Board {
    private static final int COLUMN_COUNT = 4; 
    private Tile[][] board; 
    
    // Constructor, fills board with empty Tiles 
    public Board() {
        board = new Tile[COLUMN_COUNT][COLUMN_COUNT];
        for (int i = 0; i < board.length; i++) {    
            for (int j = 0; j < board[i].length; j++) {
                Tile empty  = new Tile(0);
                // empty tiles will be given a value of 0
                board[i][j] = empty;
            }
        } 
    }
    
    /**
     * Inputs: None 
     * Outputs: None 
     * Description: inserts a random 2/4 tile into an empty space 
     *              on the board. 
     */
    public void insert() {
        Tile newTile = new Tile(0);
        if (Math.random() < 0.49) {
            Tile newTiles = new Tile(4);
            newTile = newTiles; 
        }
        else {
            Tile newTiles  = new Tile(2);
            newTile = newTiles; 
        }
        // while loop to find empty spot 
        while (true) { 
            int x = findRandomNum();
            int y = findRandomNum();
            if (board[x][y].getNum() == 0) {
                board[x][y] = newTile; 
                break; 
            }
        }
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer
     * Description: generates a random number between 0 and 3. 
     */
    public int findRandomNum() {
        int num = -1; 
        if (Math.random() < 0.49) {
            if (Math.random() < 0.49) {
                num = 0; 
            }
            else {
                num = 3;               
            }   
        }
        else {
            if (Math.random() < 0.49) {
                num = 1;
            }
            else {
                num = 2; 
            }
        }      
        return num;   
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Shifts all the tiles up and tracks how many Tiles 
     *              have moved up. This number is then returned. 
     */
    public int  moveUp() {
        /* counter will be used to represent if the board has changed 
         * this will be very important to see if we need to insert a new Tile
         * or not
         */
        int counter = 0; 
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                // finds a tile in a column that isn't empty
                if (board[j][i].getNum() != 0) {   
                    int x = j - 1;
                    // loops until the tile above is not empty 
                    while (x > -1 && board[x][i].getNum() == 0) {
                        x--;
                    } 
                    // x represents the index of where the Tile should move to
                    x++; 
                    // replace the empty Tile with the non empty one
                    board[x][i] = board[j][i]; 
                    /* replaces the previous spot of the Tile with an empty tile
                     * only if the Tiles position changes 
                     */
                    if (x != j) {
                        Tile empty = new Tile(0);
                        board[j][i] = empty; 
                        counter++; 
                    } 
                }  
            }
        } 
        return counter; 
    }

    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Shifts all the tiles to down and tracks how many Tiles
     *              have moved. This number is then returned. 
     */
    public int moveDown() {
        // counter will be used to represent if the board has changed 
        int counter = 0; 
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > -1; j--) {
                /* finds the tile that isn't empty starting from the bottom
                 * of every column
                 */
                if (board[j][i].getNum() != 0) {   
                    int x = j + 1;
                    // loops until the tile below is not an empty tile 
                    while (x < 4 && board[x][i].getNum() == 0) {
                        x++;
                    } 
                    x--; 
                    board[x][i] = board[j][i]; 
                    // replaces previous spot with an empty tile
                    if (x != j) {
                        Tile empty = new Tile(0);
                        board[j][i] = empty; 
                        counter++; 
                    }
                }  
            }
        } 
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Shifts all the tiles to the right and tracks how many Tiles
     *              have moved. This number is then returned. 
     */     
    public int moveRight() {     
        // counter will be used to represent if the board has changed 
        int counter = 0; 
         for (int i = 0; i < 4; i++) {
            for (int j = 2; j > -1; j--) {
                /* finds the Tile that isn't empty starting from 
                 * the far right of every row. 
                 */
                if (board[i][j].getNum() != 0) {   
                    int x = j + 1;
                    // loops until the tile to the right is not an empty Tile
                    while (x < 4 && board[i][x].getNum() == 0) {
                        x++;
                    } 
                    x--;
                    board[i][x] = board[i][j]; 
                    if (x != j) {
                        Tile empty = new Tile(0);
                        board[i][j] = empty; 
                        counter++; 
                    }
                }  
            }
        }   
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: shifts all the tiles to the left and tracks how many Tiles
     *              have moved. This number is then returned. 
     */
    public int moveLeft() {
        // counter will be used to represent if the board has changed 
        int counter = 0; 
         for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                /*finds the Tile that isn't empty starting from the left 
                 * of every row
                 */
                if (board[i][j].getNum() != 0) {   
                    int x = j - 1;
                    // loops until the Tile to the left isn't empty
                    while (x > -1 && board[i][x].getNum() == 0) {
                        x--;
                    } 
                    x++; 
                    board[i][x] = board[i][j]; 
                    if (x != j) {
                        Tile empty = new Tile(0);
                        board[i][j] = empty;
                        counter++;  
                    }
                }  
            }
        } 
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Takes care of "merging" tiles when the player moves
     *              the tiles up. It also tracks how many pairs of Tiles
     *              "merge" and returns this number.
     */
    public int crashUp() { 
        // counter will be used to represent if the board has changed 
        int counter = 0;
        int x = 0;  
        while (x < 4) {          
            for (int i = 0; i < 3; i++) {
                if (board[i][x].getNum() != 0 && board[i + 1][x].getNum() != 0) {
                    /* checks to see if there are two tiles in a column that 
                     * can merge, made specifically for when player moves tiles up
                     */
                    if (board[i][x].getNum() == board[i + 1][x].getNum()) { 
                        // create a new Tile with double the value
                        Tile added = new Tile(board[i][x].getNum() * 2);
                        //replace the nearest Tile to the movement with the new tile
                        board[i][x] = added;
                        // replace the other tile with an empty tile
                        Tile empty = new Tile(0);
                        board[i + 1][x] = empty;
                        counter++;
                    }
                }
            }
            x++; 
        } 
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Takes care of "merging" tiles when the player moves 
     *              the tiles down. It also tracks how many pairs of Tiles
     *              "merge" and returns this number.
     */
    public int crashDown() {
        // counter will be used to represent if the board has changed 
        int counter = 0; 
        int x = 0;  
        while (x < 4) {
            for (int i = 3; i > 0; i--) {
                if (board[i][x].getNum() != 0 && board[i - 1][x].getNum() != 0) {
                    /* checks to see if there are two tiles in a column that can 
                     * merge, made specifically for when player moves tiles down
                     */
                    if (board[i][x].getNum() == board[i - 1][x].getNum()) {
                        Tile added = new Tile(board[i][x].getNum() * 2);
                        board[i][x] = added;
                        Tile empty = new Tile(0);
                        board[i - 1][x] = empty; 
                        counter++; 
                    }
                }
            }
            x++; 
        }   
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: Takes care of "merging" tiles when the player moves
     *              the tiles to the right. It also tracks how many pairs 
     *              of Tiles "merge" and returns this number.
     */
    public int crashRight() {
        // counter will be used to represent if the board has changed 
        int counter = 0; 
        int x = 0;  
        while (x < 4) {            
            for (int i = 3; i > 0; i--) {  
                if (board[x][i].getNum() != 0 &&  board[x][i - 1].getNum() != 0) {
                    /* checks to see if there are two tiles in a row that can merge
                     * made specifically for when player moves tiles to the right
                     */
                    if (board[x][i].getNum() == board[x][i - 1].getNum()) {
                        Tile added = new Tile(board[x][i].getNum() * 2);
                        board[x][i] = added;
                        Tile empty = new Tile(0);
                        board[x][i - 1] = empty; 
                        counter++; 
                    } 
                }
            }
            x++; 
        }      
        return counter; 
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer
     * Description: Takes care of "merging" tiles when the player moves 
     *              the tiles to the left. It also tracks how many pairs of 
     *              Tiles "merge" and returns this number. 
     */
    public int crashLeft() {
        // counter will be used to represent if the board has changed 
        int counter = 0; 
        int x = 0;  
        while (x < 4) {   
            for (int i = 0; i < 3; i++) {   
                if (board[x][i].getNum() != 0 && board[x][i + 1].getNum() != 0) {
                    /* checks to see if there are two tiles in a row that can merge
                     * made specifically for when player moves tiles to the left
                     */
                    if (board[x][i].getNum() == board[x][i + 1].getNum()) {
                        Tile added = new Tile(board[x][i].getNum() * 2);
                        board[x][i] = added;
                        Tile empty = new Tile(0);
                        board[x][i + 1] = empty;
                        counter++;  
                    }   
                }
            }
            x++;
        }   
        return counter;
    }
    
    /**
     * Inputs: None 
     * Outputs: Boolean 
     * Description: Checks to see if there are still possible moves that 
     *              the player can make, specifically checks if there are 
     *              possible left/right moves. (checks rows)
     */
    public boolean checkRows() {
        int x = 0;  
        while (x < 4) {
            for (int i = 0; i < 3; i++) {                
                if (board[x][i].getNum() == board[x][i + 1].getNum()) {
                    return true;
                }    
            }
            x++; 
        } 
        return false;      
    }
    
    /**
     * Inputs: None 
     * Outputs: Boolean 
     * Description: Checks to see if there are still possible 
     *              moves that the player can make, specifically checks 
     *              if there are possible up/down moves. (checks Columns)
     */
    public boolean checkCol() {
        int x = 0;  
        while (x < 4) {
            for (int i = 0; i < 3; i++) {
                if (board[i][x].getNum() == board[i + 1][x].getNum()) {
                    return true;
                }    
            }
            x++; 
        } 
        return false;   
    }
    
    /**
     * Inputs: None 
     * Outputs: Boolean 
     * Description: Checks to see if there is a 2048 Tile on the Board, 
     *              returns True if there is. 
     */
    public boolean checkForWin() {
        for (int i = 0; i < board.length; i++) {         
            for (int j = 0; j < board[i].length; j++) { 
                if (board[i][j].getNum() == 2048) {
                    return true;
                }
            }
        }
        return false;   
    }
    
    /**
     * Inputs: None 
     * Outputs: Boolean 
     * Description: Used to check if the board is full of Tiles, returns 
     *              True when the board is full.
     */
    public boolean boardIsFull() {
        int count = 0; 
        for (int i = 0; i < board.length; i++) {    
            for (int j = 0; j < board[i].length; j++) {
               if (board[i][j].getNum() != 0) {
                   count++; 
               }
            }
        }
        return count == 16; 
    }
    
    /**
     * Inputs: None 
     * Outputs: None 
     * Description: Draws the Board outline and draws the correct Tile 
     *              at the correct place with the correct colored background.
     */
    public void draw() {
        PennDraw.clear();
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.setPenRadius(0.008);
        PennDraw.square(0.5, 0.5, 0.5);
        PennDraw.line(0.25, 0, 0.25, 1);
        PennDraw.line(0.5, 0, 0.5, 1);
        PennDraw.line(0.75, 0, 0.75, 1);
        PennDraw.line(0, 0.25, 1, 0.25);
        PennDraw.line(0, 0.5, 1, 0.5);
        PennDraw.line(0, 0.75, 1, 0.75);
        for (int i = 0; i < COLUMN_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                if (board[i][j].getNum() != 0) {
                    double xPos = j / 4.0 + (1 / 8.0);
                    double yPos = 1 - (i / 4.0 + (1 / 8.0));
                    PennDraw.setPenRadius(0.03);
                    PennDraw.setFontSize(50);
                    if (board[i][j].getNum() == 2) {
                        PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 4) {
                        PennDraw.setPenColor(PennDraw.RED);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 8) {
                        PennDraw.setPenColor(PennDraw.CYAN);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 16) {
                        PennDraw.setPenColor(PennDraw.ORANGE);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 32) {
                        PennDraw.setPenColor(PennDraw.GREEN);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 64) {
                        PennDraw.setPenColor(PennDraw.MAGENTA);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 128) {
                        PennDraw.setPenColor(PennDraw.BOOK_LIGHT_BLUE);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 256) {
                        PennDraw.setPenColor(100, 220, 50);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 512) {
                        PennDraw.setPenColor(200, 100, 230);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 1024) {
                        PennDraw.setPenColor(PennDraw.BOOK_BLUE);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    }
                    if (board[i][j].getNum() == 2048) {
                        PennDraw.setPenColor(PennDraw.YELLOW);
                        PennDraw.filledSquare(xPos, yPos, 0.121);
                    } 
                    PennDraw.setPenColor(PennDraw.BLACK);
                    PennDraw.text(xPos, yPos, "" + board[i][j].getNum());
                }
            }
        }
    }
    
    /**
     * Inputs: None
     * Outputs: None 
     * Description: Prints out a representation of the board. Used for debugging.  
     */
    public void print() {
        int count = 0; 
        for (int i = 0; i < board.length; i++) {   
            for (int j = 0; j < board[i].length; j++) {
                count++;
                System.out.print(board[i][j].getNum() + " ");
                if (count % 4 == 0) {
                    System.out.println("\n");
                }
            }
        }        
    }
}