/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnpi;
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Vicky
 */
public class LearnPi extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    public static int WIDTH = 1600;
    public static int HEIGHT = 850;
    
    public static void main(String[] args) {
        // TODO code application logic here
        new LearnPi();
    }
    
    
    public LearnPi() {
        super("LearnPi");
        setSize(WIDTH, HEIGHT);
        setBackground(Color.WHITE);
        PiGame game = new PiGame();
        ((Component) game).setFocusable(true);
        getContentPane().add(game);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
}
