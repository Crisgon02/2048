/**
 * Name: Cristian Gonzalez Paqui
 * PennKey: CrisGon
 * Execution: java Game 
 * 
 * Description: This class takes care of user input and runs the 2048 game. 
 *              It also prints the appropriate message if a game is won or
 *              lost. 
 */
public class Game {
    public static void main(String[] args) {
        Board game = new Board();   
        
        //insert two tile to begin the game 
        game.insert();
        game.insert(); 
        game.draw(); 
        int count = 0;
        PennDraw.enableAnimation(30);
        while (true) {  
            // checks if a key has been pressed 
            if (PennDraw.hasNextKeyTyped()) {
                char x = PennDraw.nextKeyTyped();
                //down actions
                if (x == 's') {
                    //moves tiles down, checks if board has changed
                    if (game.moveDown() > 0) { 
                        if (game.crashDown() > 0) {
                            game.moveDown();
                        }
                        count++;
                        game.insert();
                    }
                    /* if no tiles can move, but there are tiles that can merge
                     * this else if statement takes care of it. 
                     */
                    else if (game.crashDown() > 0) {
                        game.moveDown();
                        count++;
                        game.insert(); 
                    }  
                }
                //up actions 
                else if (x == 'w') {
                    //moves tiles up, checks if board has changed 
                    if (game.moveUp() > 0) { 
                        if (game.crashUp() > 0) {
                            game.moveUp();
                        }
                        count++;
                        game.insert();
                    }
                    /* if no tiles can move, but there are tiles that can merge
                     * this else if statement takes care of it. 
                     */    
                    else if (game.crashUp() > 0) {                 
                        game.moveUp();
                        count++;
                        game.insert();
                    }  
                }
                //right movement actions 
                else if (x == 'd') {                  
                    //moves tiles to the right, checks if board has changed
                    if (game.moveRight() > 0) {   
                        if (game.crashRight() > 0) {
                            game.moveRight();
                        }    
                        count++;
                        game.insert();
                    } 
                    /* if no tiles can move, but there are tiles that can merge
                     * this else if statement takes care of it. 
                     */
                    else if (game.crashRight() > 0) {
                        game.moveRight();
                        count++;
                        game.insert();
                    }  
                }
                //left movement actions 
                else if (x == 'a') {
                    //moves tiles to the left, checks if board has changed
                    if (game.moveLeft() > 0) { 
                        if (game.crashLeft() > 0) {
                            game.moveLeft();
                        }
                        count++;
                        game.insert();
                    }
                    /* if no tiles can move, but there are tiles that can merge
                     * this else if statement takes care of it. 
                     */
                    else if (game.crashLeft() > 0) {
                        game.moveLeft();
                        count++;
                        game.insert();
                    }  
                } 
                game.draw();
            } 
            //checks to see if game has been won 
            if (game.checkForWin() == true) {
                PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
                PennDraw.filledRectangle(0.5, 0.75, 0.32, 0.05);
                PennDraw.filledRectangle(0.5, 0.54, 0.32, 0.05);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius(0.008);
                PennDraw.rectangle(0.5, 0.75, 0.32, 0.05);
                PennDraw.rectangle(0.5, 0.54, 0.32, 0.05); 
                PennDraw.text(0.5, 0.74, "WINNER!!");
                PennDraw.text(0.5, 0.53, "Score:" + "" + count); 
            }
            //checks to see if game has been lost 
            if (game.checkRows() == false && game.checkCol() == false &&
                game.boardIsFull() == true) {
                PennDraw.setPenColor(PennDraw.LIGHT_GRAY);
                PennDraw.filledRectangle(0.5, 0.75, 0.32, 0.05);
                PennDraw.filledRectangle(0.5, 0.54, 0.32, 0.05);
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius(0.008);
                PennDraw.rectangle(0.5, 0.75, 0.32, 0.05);
                PennDraw.rectangle(0.5, 0.54, 0.32, 0.05);
                PennDraw.text(0.5, 0.74, "GAME OVER");
                PennDraw.text(0.5, 0.53, "Score:" + "" + count);
            }
            PennDraw.advance();
        }
    }
}

    