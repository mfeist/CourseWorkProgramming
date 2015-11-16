
/**
 * Demonstrate integer division.
 * 
 * @author mfeist 
 * @version 1.0
 */
public class Milk
{
    public static void main (String[] args)
    {
        double milkCarton = 3.78;//variable declaration and assinged a value.
        double milkCost = .38;//variable declaration and assinged a value.
        double milkProfit = .27;//variable declaration and assinged a value.
        int milkTotal = 50;//variable declaration and assinged a value.
        double cartonsSold = milkTotal / milkCarton;//declared variable and performed operation.
        int cartonsSold1 = (int) cartonsSold;//made the variable into an int.
        double y = milkTotal * milkCost;//declared variable and performed operation.
        double z = milkTotal * milkProfit;//declared variable and performed operation.
        System.out.println("The number of milk cartons needed to hold 50 liters of milk is " + cartonsSold1);//output to view data.
        System.out.println("The cost of producing 50 liters of milk is $" + y);//output to view data.
        System.out.println("The profit of producing 50 liters of milk is $" + z);//output to view data. 
        
    }
}
