/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.Lab2Lib;

/**
 *
 * @author mfeist
 */
public class LibClass {

    public static String acrostic(String[] args) {
/**
 * Nested loop to go through the entered statement if the value of the
 * character at that position and add that value to the StringBuffer class.
 */        
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() > i) {
                b.append(args[i].charAt(i));
            } else {
                b.append('?');
            }
        }
        return b.toString();
    }
}
