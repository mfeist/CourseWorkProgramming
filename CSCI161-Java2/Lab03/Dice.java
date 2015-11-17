/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dicegame;

/**
 *
 * @author mfeist
 */
public class Dice {
    //instance variables
    private int face1;
    private int face2;
    private int sum;
    
    //constructor
    public Dice(){
        rollDice();
    }
    
    //roll the dice.
    public void rollDice(){
        face1 = (int) (Math.random()*6) + 1;
        face2 = (int) (Math.random()*6) + 1;
        sum = face1 + face2;
    }
    //calc sum.
    public void calcSum(){
        sum = face1 + face2;
    }
    //access sum.
    public int getSum(){
        return sum;
    }
}