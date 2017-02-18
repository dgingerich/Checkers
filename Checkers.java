/*
 * This is a checkers program
TODO
-two player, same computer implementation
    -movement
    -turns
    -GUI
-main menu
-multiplayer, network, implementation
-one player implementation
 */
package checkers;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author 1301612
 */
public class Checkers extends JPanel {

    /*
         * Board Design 8 x 8 Spot is either occupied by player 1, occupied by
         * player 2, or unoccupied Either gray or white; can only move to gray
         * squares
         *
     */

    public boardTile[][] board = new boardTile[8][8];
    
    public Checkers(){
        super();
        setBackground(Color.lightGray);
        this.initializeBoard();
    }
    
    
    public void initializeBoard() {
        //Sets board color
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0 && j % 2 != 0 || i % 2 != 0 && j % 2 == 0) {
                    board[i][j] = new boardTile();
                    board[i][j].setColor('g');
                } else {
                    board[i][j] = new boardTile();
                    board[i][j].setColor('w');
                }
            }
        }
        //Sets initial positions
        for (int i = 0; i < 3; i++) {
            for (int j = 1 - (i % 2); j < 8; j += 2) {
                board[j][i].setOccupied(2, false);
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 1 - (i % 2); j < 8; j += 2) {
                board[j][i].setOccupied(1, false);
            }
        }
    }
    
   
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        System.out.println("here");
        
        //Draws squares
        for (int x = 0; x < 800; x += 100) {
            for (int y = 0; y < 800; y += 100) {
                switch (board[x/100][y/100].getColor()) {
                    case 'w':
                        g.setColor(Color.WHITE);
                        g.drawRect(x, y, 100, 100);
                        g.fillRect(x, y, 100, 100);
                        break;
                    case 'g':
                        g.setColor(Color.DARK_GRAY);
                        if (board[x/100][y/100].getSelected()) {
                            System.out.println("here");
                            g.setColor(Color.yellow);
                            board[x/100][y/100].setSelected(false);
                        }
                        g.drawRect(x, y, 100, 100);
                        g.fillRect(x, y, 100, 100);
                        break; 
                    default:
                        System.out.println("Houston, we have a problem.");
                        break;
                }
            }
        }
        
        //Makes pieces
        for (int x = 0; x < 800; x += 100) {
            for (int y = 0; y < 800; y += 100) {
                switch (board[x/100][y/100].getOccupied()) {
                    case 1:
                        g.setColor(Color.red);
                        g.fillOval(x + 10, y + 10, 80, 80);
                        g.fillOval(x + 10, y + 10, 80, 80);
                        if (board[x/100][y/100].getKing()) {
                            g.setColor(Color.WHITE);
                            g.drawString("KING", x + 35, y + 55);
                        }
                        break;
                    case 2:
                        g.setColor(Color.black);
                        g.fillOval(x + 10, y + 10, 80, 80);
                        g.fillOval(x + 10, y + 10, 80, 80);
                        if (board[x/100][y/100].getKing()) {
                            g.setColor(Color.WHITE);
                            g.drawString("KING", x + 35, y + 55);
                        }
                        break; 
                    default:
                        break;
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        Checkers checkers = new Checkers();
        
        myMouseListener listener = new myMouseListener();
        //Makes JFrame
        JFrame frame = new JFrame("Checkers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new Checkers();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.addMouseListener(listener);
        
    }

}