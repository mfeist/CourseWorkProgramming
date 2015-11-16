
/**
 * @author mfeist
 * @version 05/01/2013
 */
public class HorrowShow
{
    public static void u(Monster b)
    {
        b.menace();
    }
    
    public static void v(DangerousMonster d)
    {
        d.menace();
        d.destroy();
    }
    
    public static void w(Lethal l)
    {
        l.Kill();
    }
    
    public static void main (String[] args)
    {
        DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);
        
        Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);
    }
}
