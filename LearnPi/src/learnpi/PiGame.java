/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnpi;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
/**
 *
 * @author Vicky
 */
public class PiGame extends JPanel{
    
    private boolean play;
    private int score;
    private int stage;
    private String input;
    private String next;
    private boolean lost;
    private String pi;
    
    public PiGame() {
        score = 0;
        stage = 0;
        input = "";
        lost = false;
        next = "";
        pi = "" + Math.PI;
        play = true;
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                
                if (!lost && stage == 0 && ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || (e.getKeyCode() == 46) || (e.getKeyCode() == 32))) {
                    if (e.getKeyCode() != 32) {
                        if (e.getKeyCode() == 46) {
                            input = ".";
                        }
                        else {
                            input = "" + (e.getKeyCode() - 48);
                        }
                        score++;
                        stage = 1;
                        play = false;
                    }
                    else {
                        stage = 2;
                    }
                }
                else if (!lost && stage == 1 && ((e.getKeyCode() >= 48 && e.getKeyCode() <= 57) || e.getKeyCode() == 46 || e.getKeyCode() == 32)) {
                    if (e.getKeyCode() != 32) {
                        if (e.getKeyCode() == 46) {
                            input += ".";
                        }
                        else {
                            input += "" + (e.getKeyCode() - 48);
                        }
                    }
                    else {
                        stage = 2;
                    }
                }
//                else if (!lost && stage == 2 && e.getKeyCode() == 32) {
//                    play = !play;
//                    System.out.println("YAY");
//                    if (!play) {
//                        stage = 0;
//                        input = "";
//                    }
//                    
//                    if (play) {
//                        if (!input.equals(pi.substring(0, score))) {
//                            lost = true;
//                            stage = 3;
//                        }
//                    }
//                }
                
                repaint();
            }
        });
        
//        addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//        });
        
    }
    
    public void update(Graphics window) {
        paint(window);
    }
    
    public void paint(Graphics window) {
        
        window.setColor(Color.BLACK);
        window.fillRect(0, 0, 1600, 850);
        
        if (play) {    
            Font number = new Font(" ", 70, 70);
            window.setFont(number);
            next = pi.substring(score, score + 1);
            window.setColor(Color.green);
            window.drawString(next, 800, 800);
        }
        else if (!play) {
            Font number = new Font(" ", 1, 10);
            window.setFont(number);
            window.setColor(Color.white);
            window.drawString(input, 0, 10);
        }
        
        if (stage == 2) {
            play = true;
            if (!input.equals(pi.substring(0, score))) {
                lost = true;
            }
            input = "";
            stage = 0;
        }
        repaint();
    }
    
    
}
