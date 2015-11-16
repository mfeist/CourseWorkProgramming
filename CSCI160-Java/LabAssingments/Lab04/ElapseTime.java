
/**
 * Find time for event in seconds then create in minutes and hours.
 * 
 * @author mfeist 
 * @version 1.0
 */
public class ElapseTime
{
    public static void main (String[] args)
    {
        int givenTime = 8732;//declared varaible and assinged value.
        int timeHours = givenTime / 3600;//declared variable and performed operation to find the hours.
        int remainderMinutes = givenTime % 3600;//declared variable and performed operation to find the remainder time after the hours are taken out.
        int timeMinutes = remainderMinutes / 60;//declared variable and performed operation to find the minutes.
        int remainderSeconds = remainderMinutes % 60;//declared variable and performed operation to find the remainder time after hours and minutes are taken out.
        int timeSeconds = remainderMinutes /60;//declared variable and performed operation to find the seconds.
        System.out.println("The elapse time of 8732 seconds is " + timeHours + ": " + timeMinutes + ": " + timeSeconds + ".");//output to the 8732s into hr:min:sec format.
    }
}
