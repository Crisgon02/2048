/**
 * Name: Cristian Gonzalez Paqui
 * PennKey: CrisGon
 * Execution: No execution, used in Board.java
 * 
 * Description: used to create an instance of the Tile object. 
 *              
 */

public class Tile {
    private int num;
    
    //constructor
    public Tile(int num) {
        this.num = num;       
    }
    
    /**
     * Inputs: None 
     * Outputs: Integer 
     * Description: gets the number associated with a Tile. 
     *              
     */
    public int getNum() {
        return num; 
    }   
}