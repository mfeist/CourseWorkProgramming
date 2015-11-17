/*
 * Hello.java
 *
 * Created on January 12, 2009, 3:15 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Hello;

/** 
 * Prints the traditional first String.
 * @version 1.0
 * @author: mfeist
 * @Section #: 2
 */

public class Hello
{
    // instance variables
    private String greeting;
    private String salutation;
    private String myName;
    private String myMajor;
    
    /**
     * Constructor for objects of class Hello
     */
    public Hello()
    {
        // initialize instance variables
        greeting = "<<<<< Hello >>>>>";
        salutation = "<<<< Welcome to CSci-161 >>>";
        myName = "Name: Mathew Feist";
        myMajor = "Major: Computer Engineer";
    }
    
    public void sayHello()
    {
        System.out.print(greeting);
    }
    
    private void sayWelcome()
    {
        System.out.print(salutation);
    }
    
    private void sayMyName()
    {
        System.out.print(myName);
    }
    
    private void sayMyMajor()
    {
        System.out.print(myMajor);
    }
    public static void main(String[] args)
    {
        Hello hi = new Hello();
        
        hi.sayHello(); 
        
        System.out.println();        
        hi.sayWelcome();
        System.out.println();
        hi.sayMyName();
        System.out.println();
        hi.sayMyMajor();
        System.out.println();
    }
}
