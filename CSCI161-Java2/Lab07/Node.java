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
public class Node {
    //Instance Variables:
    private int element;
    private Node next;
    
    //Create Node with null references to its element and next node.
    public Node() {
        next = null;
    }
    
    //create node with the given element and next node.
    public Node(int e, Node n) {
        element = e;
        next = n;
    }
    
    //accessor methods
    public int getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }
    
    //Modifier methods.
    public void setElement(int newElem) {
        element = newElem;
    }

    public void setNext(Node newNext) {
        next = newNext;
    }
}