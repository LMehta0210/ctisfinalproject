/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.guilford.finalproject;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import org.apache.commons.math4.legacy.linear.*;
/**
 *
 * @author vm658
 */
public class CircleCharge{
    
    //initializes default x and y and color
    private int x = 0, y = 0; 
    private Color drawColor = Color.BLUE;
    //instantiates th circle and charge value
    private Ellipse2D.Double circle;
    private double charge;
    
    //creates charge with x and y position as paramters
    public CircleCharge(int posx, int posy) {
        x = posx;
        y = posy;
    }
    
    //method that returns the circle that should be drawn to the screen
    public Ellipse2D.Double getCircle(int posx, int posy, boolean textOffset) {
        x = posx;
        y = posy;
        //if charge is on the text object, there is a different offset than without the text box to keep everything visually centered
        if (textOffset){ circle = new Ellipse2D.Double(x-30, y-40, 100, 100);
        } else { circle = new Ellipse2D.Double(x-50, y-50, 100, 100);}
        return circle;
    }
    
    //calculates the E-field vector
    public ArrayRealVector calcEField(int testx, int testy){
        //creates r vector
        ArrayRealVector dist = new ArrayRealVector(new double[]{testx - (x+20), testy - (y+10)});
        double distMag = Math.sqrt(dist.dotProduct(dist)); //determiines the magnitude of the distance
        //formula for the E-field, scaled down by factor of 10e5
        ArrayRealVector EField = (ArrayRealVector) dist.mapMultiply(8.99E4*charge*Math.pow(distMag, -3));
        return EField;
    }
    
    //calculates voltage
    public double calcVoltage(int testx, int testy){
        ArrayRealVector dist = new ArrayRealVector(new double[]{testx - (x+20), testy - (y+10)});
        //also scaled down by 10e5
        double voltage  = -8.99E4*charge/Math.sqrt(dist.dotProduct(dist));
        return voltage;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
    
    //determines color based on the charge value
    public Color getDrawColor() {
        if(charge > 0) {
            drawColor = new Color((int) (150 + 1.05*charge),0,0, 200);
        }else if (charge < 0){
            drawColor = new Color(0,0, (int) (150-1.05*charge), 200);
        }else drawColor = new Color(0, 0, 0, 200);
        return drawColor;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
