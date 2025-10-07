
import java.util.Scanner;

public class Choinka
{
    public static void main(String[] args)
    {
        Scanner wczyt = new Scanner(System.in);
        System.out.print("Podaj rozmiar choinki: ");
        int rozmiar = wczyt.nextInt();
        
        for(int i=1; i<=rozmiar; i++){
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
