
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto2
{
    public static void main(String[] args)
    {
        Scanner wczyt = new Scanner(System.in);
        System.out.println("Podaj liczby: ");
        int liczby1 = wczyt.nextInt();
        int liczby2 = wczyt.nextInt();
        int liczby3 = wczyt.nextInt();
        int liczby4 = wczyt.nextInt();
        int liczby5 = wczyt.nextInt();
        int liczby6 = wczyt.nextInt();
        int liczby_user[] = {liczby1, liczby2, liczby3, liczby4, liczby5, liczby6};

        ArrayList<Integer> wylosowane = new ArrayList<>();
        Random losuj = new Random();

        int zgodnosc = 0;

        while (wylosowane.size() < 6) // Losowanie
        {
            int nowa = losuj.nextInt(49) + 1;
            wylosowane.add(nowa);
            for(int k=0 ; k<=5 ; k=k+1)
            {
                if(liczby_user[k] == nowa)
                {
                    zgodnosc = zgodnosc + 1;
                }
            }
        }

        System.out.println("Wylosowane liczby: "); // Wypisanie
        for (int liczba : wylosowane)
        {
            System.out.println(liczba + " ");
        }

        System.out.println("Liczba trafień: " + zgodnosc);
    }
}

