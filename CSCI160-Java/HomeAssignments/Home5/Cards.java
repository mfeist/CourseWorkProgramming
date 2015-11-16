
/**
 * User-Defined MultiDimensional Array.
 * 
 * @author Micheal Feickert, Mathew Feist, Matthew Thomas 
 * @version 04/26/2013
 */
public class Cards
{
    private int [][] values = new int [4][13];//instance variable.
    private String [] suit = {"Diamonds","Hearts", "Clubs", "Spades"};//instance variable.
    private int trump;//instance variable.
    
    public Cards(int xTrump)//constructor.
    {
        trump = xTrump;//assinging trump value.
        for (int i = 0; i < values.length; i++)//outer loop for row.
        {
            for (int j = 0; j < values[i].length; j++)//inner loop for column.
            {
                int tempValue = 0;//temp value.
                switch (j)//switch statement for non - trump value.
                {
                    case 0:
                        tempValue = 5;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        tempValue = 1;
                        break;
                    case 10:
                        tempValue = 2;
                        break;
                    case 11:
                        tempValue = 3;
                        break;
                    case 12:
                        tempValue = 4;
                        break;
                }
                if (i == trump)//check if trump.
                    tempValue += 1;//adding 1 if trump.
                values[i][j] = tempValue;//populuting elements.
            }
        }
    }
    
    public String getTrump(int trump)//access method for trump
    {
        return suit[trump];//returing trump suit.
    }
    
    public String getDeck()//access method for deck.
    {
        String answer = "";//temp string value.
        for(int i = 0; i < values.length; i++)//outer loop for row.
        {
            answer += "\n" + suit[i] + ":   \t";//adding the suit to the string.
            for (int j = 0; j < values[i].length; j++)//inner loop for column.
            {
                answer += values[i][j] + "\t";//adding the elements of the values.
            }
        }
        
        return answer;//returns the new string.
    }
    
    public int getRowTotal (String suit1)//access method for the total value of the rows.
    {
        int i = 0;//temp value.
        int rowTotal = 0;//temp value for the total of the row.
        if (suit1.equals(suit[0]))//check to see if the suit matches.
            i = 0;//assinging the corresponding index position.
        else if (suit1.equals(suit[1]))//check to see if the suit matches.
            i = 1;//assinging the corresponding index position.
        else if (suit1.equals(suit[2]))//check to see if the suit matches.
            i = 2;//assinging the corresponding index position.
        else if (suit1.equals(suit[3]))//check to see if the suit matches.
            i = 3;//assinging the corresponding index position.
        for (int j = 0; j < values[i].length; j++)//for loop to go through the row.
            rowTotal += values[i][j];//adding the elements of the array.
        return rowTotal;//return the total amount.
    }
}