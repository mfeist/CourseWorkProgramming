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
public class NodeStack implements Stack1 {
    //instance variables

    protected Node top;
    protected int size;
    //node method
    public NodeStack() {
        top = null;
        size = 0;
    }
    //Stack methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public void push(int elem) {
        if (size == 5) {
            System.out.println("Illegal because stack is full.");
        } else {
            Node v = new Node(elem, top);
            top = v;
            size++;
        }
    }

    public int top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Illegal becase stack is empty.");
        }
        return top.getElement();
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Illegal because stack is empty.");
        }
        int temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

    public boolean isFull() {
        if (size == 5) {
            return true;
        }
        return false;
    }
}