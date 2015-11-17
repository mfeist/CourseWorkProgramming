/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab4;

/**
 *
 * @author Christopher Jordan-Denny, Mathew Feist, Taren McCullough
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //calling and testing Employee class.
        Employee emp1 = new Employee();
        emp1.setEmployee();
        emp1.getEmployee();
        Employee emp2 = new Employee();
        emp2.setEmployee();
        emp2.getEmployee();

        //calling and testing Consultant class.
        Consultant con1 = new Consultant();
        con1.setConsultant();
        con1.getConsultant();
        Consultant con2 = new Consultant();
        con2.setConsultant();
        con2.getConsultant();

        //calling and testing Manager class.
        Manager boss1 = new Manager();
        boss1.setManager();
        boss1.getManager();
        Manager boss2 = new Manager();
        boss2.setManager();
        boss2.getManager();

        //calling and testing Project class.
        Project task1 = new Project();
        task1.setProject();
        task1.getProject();
        Project task2 = new Project();
        task2.setProject();
        task2.getProject();

        //calling and testing Assignment class.
        Assignment work1 = new Assignment();
        work1.setAssignment();
        work1.getAssignment();
        Assignment work2 = new Assignment();
        work2.setAssignment();
        work2.getAssignment();
    }
}
