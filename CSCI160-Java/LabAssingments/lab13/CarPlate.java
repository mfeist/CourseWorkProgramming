
/**
 * User-defined class for car plates.
 * 
 * @author mfeist 
 * @version 05/01/2013
 */

import java.io.Serializable;

public class CarPlate implements Serializable
{
    //instance variables.
    private int plateNumber;
    private String state;
    private String color;
    
    //default constructor.
    public CarPlate()
    {
        plateNumber = 0;
        state = "Unknown";
        color = "Unknown";
    }
    
    //overloaded constuctor.
    public CarPlate(int xPlateNumber, String xState, String xColor)
    {
        plateNumber = xPlateNumber;
        state = xState;
        color = xColor;
    }
    
    //mutator method for plate number.
    public void setPlateNumber(int newPlateNumber)
    {
        plateNumber = newPlateNumber;
    }
    
    //mutator method for state.
    public void setState(String newState)
    {
        state = newState;
    }
    
    //mutator method for color.
    public void setColor(String newColor)
    {
        color = newColor;
    }
    
    //access method for plate number.
    public int getPlateNumber()
    {
        return plateNumber;
    }
    
    //access method for state.
    public String getState()
    {
        return state;
    }
    
    //access method for color.
    public String getColor()
    {
        return color;
    }
    
    //toString method.
    public String toString()
    {
        return "Plate Number: " + plateNumber + "\tState: " + state + "\tColor: " + color;
    }
}
