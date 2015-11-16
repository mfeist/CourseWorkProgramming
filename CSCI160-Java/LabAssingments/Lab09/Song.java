
/**
 * Demonstrate knowledge of switch and loop statements.
 * 
 * @author mfeist
 * @version 3/1/2013
 */
public class Song
{
    public static void main (String [] args)
    {
        int count;
        int day;
        
        String daySuffix = "";
        
        for (day = 1; day <= 12; day ++)
        {
            switch (day)
            {
                case 1:
                 daySuffix = "st";
                 System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");
                 break;
                case 2:
                 daySuffix = "nd";
                 System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");
                 break;
                case 3:
                 daySuffix = "rd";
                 System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");
                 break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                 daySuffix = "th";
                 System.out.println("On the " + day + daySuffix + " day of Christmas my true love gave to me");
                 break;
            }
            String message = "";
            switch (day)
            {
                case 12:
                 message += "Twelve pippers pipping,\n";
                case 11:
                 message += "Eleven drummers drumming,\n";
                case 10:
                 message += "Ten lords a leaping,\n";
                case 9:
                 message += "Nine ladies dancing,\n";
                case 8:
                 message += "Eight maids a milking,\n";
                case 7:
                 message += "Seven swans a swimming,\n";
                case 6:
                 message += "Six geese a laying,\n";
                case 5:
                 message += "Five golden rings,\n";
                case 4:
                 message += "Four calling birds,\n";
                case 3:
                 message += "Three French hens,\n";
                case 2:
                 message += "Two turtle doves, and\n";
                case 1:
                 message += "A partridge in a pear tree";
            }
            System.out.println(message);
        }
    }
}
