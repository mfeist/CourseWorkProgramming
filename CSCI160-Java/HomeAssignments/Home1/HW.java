
/**
 * Homework 1.
 * 
 * @author mfeist 
 * @version 1.0
 */
public class HW
{
    public static void main (String[] args)
    {
        int weeks = 5;//declared variable and assinged the number of weeks worked.
        int hoursWeek = 40;//declared variable and assinged the number of hours worked per week.
        double rate = 15.50;//declared variable and assinged the hourly rate.
        double grossPay = weeks * hoursWeek * rate;//declared variable and performed calculation for gross pay.
        double tax = .14;//declared variable and assinged the rate for taxes.
        double netPay = grossPay - (grossPay * tax);//declared variable and performed calculation for net pay.
        System.out.println("My gross pay was $" + grossPay + "0");//output.
        System.out.println("My net pay was $" + netPay + "0");//output.
        double spending = .10;//declared variable and assinged the rate that was spent.
        double totalSpending = netPay * spending;//declared variable and performed operation to find out amount spent.
        System.out.println("The amount that I spent on clothes and other accessories was $" + totalSpending + "0");//output.
        double schoolSupplies = .01;//declared variable and assinged the rate that was spent for school.
        double totalSchool = netPay * schoolSupplies;//declared variable and performed operation to find out amount spent for school.
        System.out.println("The amount that I spent on school supplies was $" + totalSchool);//output.
        double totalLeft = netPay - totalSpending - totalSchool;//declared variable and found out amount spent on scool and clothes.
        float totalLeft1 = (float) totalLeft;//changed variable to float.
        float savingsBonds = .25f;//declared variable and assinged the rate spent on savings bonds.
        float mySavingsBonds = totalLeft1 * savingsBonds;//declared varaible and perfomed operation to find out how much I put into savings bonds.
        System.out.println("The amount that I put into savings bonds was $" + mySavingsBonds);//output.
        double parentsBonds = .50;//declared variable and assinged rate that parents inputed.
        int mySavingsBonds1 = (int) mySavingsBonds;//made variable into an int.
        double totalParentsBonds = mySavingsBonds1 * parentsBonds;//declared variable and performed operation to find out how much parents spent.
        System.out.println("The amount that my parents put into savings bonds for me was $" + totalParentsBonds + "0");//output.
    }
}
