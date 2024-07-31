/**********************************************************************
 *  readme                                                    
 *  2048 Game 
 **********************************************************************/

Name: Cristian Gonzalez Paqui


/**********************************************************************
 *  Instructions on how to run program 
 **********************************************************************/
To start the game, just run java Game in the terminal and the 
game will start.

/**********************************************************************
 *  Tile.java - purpose
 **********************************************************************/
This class makes it possible to create an instance of the object Tile.
A Tile consists of just a number. Tiles will be used in Board.java 
to fill a 2d array.

/**********************************************************************
 *  Board.java - purpose
 **********************************************************************/
The Board class is used to create an instance of the object Board that is 
a 2D array of Tiles. This class also contains many methods that the board
can do: Shiting the tiles up/down/left/right, drawing the board outline and tiles, 
checking for legal moves, checking for when board is full or there is a 
winner, inserting a random 2 or 4 tile onto the board, functions
that merge the Tiles together, and a print method that prints the 
2D array to help debug. Board.java will be used in Game.java



/**********************************************************************
 *  Game.java - purpose           
 **********************************************************************/
This is where the game comes together. This class takes care of the 
user input when they press WASD keys to move the tiles. It also takes care
of checking when the player wins or loses and shows the appropriate message
on the screen.

 
 /**********************************************************************
 *  Additional features beyond assignment specifications
 **********************************************************************/
N/A
 
