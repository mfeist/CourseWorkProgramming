/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7;

/**
 * @labnumber 7
 * @author Christopher Jordan - Denny
 * @author Mathew Feist
 * @Section 2
 * @version 1.0
 */
//Stack interface
public interface Stack1 {
    public int size();
    public boolean isEmpty();
    public int top()
            throws EmptyStackException;
    public void push(int element);
    public int pop()
            throws EmptyStackException;
}