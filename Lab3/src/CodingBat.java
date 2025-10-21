
public class CodingBat
{

    // Zadanie diff21()
    public static int diff21(int n)
    {
        if (n<=21) {return (21-n);} // Zwykła wartość bezwzględna
        else {return ((n-21)*2);} // Podwojona wartość bezwzględna
    }


    // Zadanie startHi()
    public static boolean startHi(String str)
    {
        if (str.length() < 2) {return false;}
        String poczatek = str.substring(0, 2); // Pierwsze dwie litery
        if (poczatek.equals("hi")) {return true;}
        else {return false;}
    }


    // Zadanie firstHalf()
    public static String firstHalf(String str)
    {
        int dlugosc = str.length();
        String polowa = str.substring(0, dlugosc/2);
        return polowa;
    }


    // Zadanie countEvens()
    public static int countEvens(int[] nums)
    {
        int ilosc = 0;
        for(int i=0; i<nums.length; i++)
        {
            if( nums[i]%2==0 )
            {
                ilosc++;
            }
        }
        return ilosc;
    }

}
