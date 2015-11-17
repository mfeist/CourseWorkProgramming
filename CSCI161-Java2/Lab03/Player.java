/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author mfeist
 */
public class Player {
    //instance variables.
    private int iD;
    private String name;
    public static int win = 0;
    public static int total = 0;
    
    //constructor
    public Player (int xID, String xName){
        iD = xID;
        name = xName;
    }
    //modifyer methods.
    public void setID(int newID){
        iD = newID;
    }
    public void setName(String newName){
        name = newName;
    }
    //access method,
    public int getID(){
        return iD;
    }
    public String getName(){
        return name;
    }
    //toString method.
    public String toString(){
        return ("Player ID: " + iD + "\n" + "Player Name: " 
                + name + "\n" + "Game Score:" 
                + win + "/" + total);
    }
}