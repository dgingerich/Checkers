/*
 * Events upon mouse click. This is where the player control happens
 */
package checkers;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author 1301612
 */

//y - 25
public class myMouseListener extends Checkers implements MouseListener {
    
    public myMouseListener() {
        super();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        //Turn can be one or two
        //When turn = 1, red turn
        //When turn = 2, black turn
        int turn = 1;
        
        int x = e.getX();
        int y = e.getY() - 25;
        
        //Gets board row and column due to truncating
        //Each square is 100 px
        int column = x / 100;
        int row = y / 100;
        
        if (board[column][row].getOccupied() == turn) {
            System.out.println("Here 2");
            board[column][row].setSelected(true);
            System.out.println(board[column][row].getSelected());
            repaint();
        }
        
    }
    
    
    
    //Ignore all this garbage until I find out how to get rid of it
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

}
