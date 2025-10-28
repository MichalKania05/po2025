
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class Lotto2
{
    public static void main(String[] args)
    {
        // Wczytywanie liczb użytkownika
        HashSet<Integer> wlasne_typy = new HashSet<>();
        for (String arg : args)
        {
            wlasne_typy.add(Integer.parseInt(arg));
        }

        // Losowanie liczb przez komputer
        HashSet<Integer> wylosowane = new HashSet<>();
        Random losuj = new Random();
        while (wylosowane.size() < 6)
        {
            int nowa = losuj.nextInt(49) + 1;
            wylosowane.add(nowa);
        }
        System.out.println("Wylosowane liczby: ");
        for (int liczba : wylosowane)
        {
            System.out.print(liczba + " ");
        }
        System.out.println();

        // Licznik trafień
        int trafienia = 0;
        for (int liczba : wylosowane)
        {
            if(wlasne_typy.contains(liczba))
            {
                trafienia += 1;
            }
        }

        System.out.println("Liczba trafień: " + trafienia);
    }
}

