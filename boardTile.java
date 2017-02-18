/*
 * This class contains the tiles and information for them
 */
package checkers;

/**
 *
 * @author 1301612
 */
public class boardTile {
    /*  Occupied
     *  0 = not occupied
     *  1 = player 1 occupied
     *  2 = player 2 occupied
     */
    int occupied = 0;
    
    boolean king = false;
    
    /* Color
    *  g = gray
    *  w = white
    */
    char color = ' ';
    
    boolean selected = false;
    
    public void setOccupied(int makeOccupied, boolean isKing) {
        occupied = makeOccupied;
        king = isKing;
    }
    
    public boolean getKing() {
        return king;
    }
    
    public int getOccupied() {
        return occupied;
    }
    
    public void setColor(char makeColor) {
        //makeColor must be g or w
        color = makeColor;
    }
    
    public char getColor() {
        return color;
    }
    
    public void setSelected(Boolean select) {
        selected = select;
    }
    
    public boolean getSelected() {
        return selected;
    }
    
}