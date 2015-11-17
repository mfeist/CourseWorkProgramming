package lab7;

import java.util.Scanner;

/**
 *
 * @labnumber 7
 * @author Christopher Jordan - Denny
 * @author Mathew Feist
 * @Section 2
 * @version 1.0
 *
 */
public class UI {
    //instance variables
    private Scanner scan;
    private NodeStack ns;
    private int input;
    private int data;

    public UI() {
        scan = new Scanner(System.in);
        ns = new NodeStack();
    }
//menu
    public void menu() {
        do {
            //prints the menu
            System.out.println("Menu: ");
            System.out.println("You can exit at any time by pressing: 0");
            System.out.println("If you want to know if the stack is empty "
                    + "enter: 1");
            System.out.println("If you want to know if the stack is full "
                    + "enter: 2");
            System.out.println("If you want to know the size of the stack "
                    + "enter: 3");
            System.out.println("If you want to know the top most element "
                    + "in the stack enter: 4");
            System.out.println("If you want to push onto the stack enter: 5");
            System.out.println("If you want to pop from the stack enter: 6\n");

            //scans user input
            System.out.print("> ");
            try {
                input = scan.nextInt();
            } catch (Exception e) {
                System.out.println("You must enter an integer!!! ");
            }

            //switches on which number they enter
            switch (input) {
                case 1:
                    System.out.println(ns.isEmpty());
                    break;
                case 2:
                    System.out.println(ns.isFull());
                    break;
                case 3:
                    System.out.println(ns.size());
                    break;
                case 4:
                    System.out.println(ns.top());
                    break;
                case 5:
                    System.out.print("What number would you like to push? >");
                    try {
                        data = scan.nextInt();
                    } catch (Exception e) {
                        System.out.println("You must enter an integer!!! ");
                    }
                    ns.push(data);
                    break;
                case 6:
                    System.out.println(ns.pop());
                    break;
            }
        } while (input != 0);
    }
}