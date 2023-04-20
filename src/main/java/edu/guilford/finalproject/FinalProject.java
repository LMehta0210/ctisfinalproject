/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


package edu.guilford.finalproject;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author vm658
 */
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //creates window
        JFrame window = new JFrame("Final Project");
        JPanel content = new JPanel();
        
        //adds display to the window
        Display display = new Display();        
        
        //sets the size of the panel
        Dimension panelSize = new Dimension(1520,800);
        display.setPreferredSize(panelSize);
        
        //allows us to x out the program
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //add to Jframe
        content.add(display);
        window.getContentPane().add(content);
        
        
        //makes window display
        window.pack();
        window.setVisible(true);
    }
    
    
    
}
