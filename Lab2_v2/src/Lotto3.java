
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Collections;

public class Lotto3
{
    public static void main(String[] args)
    {
        // Wczytanie losów
        HashSet<Integer> wlasne_typy = new HashSet<>();
        for (String arg : args)
        {
            int liczba = Integer.parseInt(arg);
            wlasne_typy.add(liczba);
        }

        Random losuj = new Random();
        int ilosc_losowan = 0;

        // Losowanie przez komputer i odliczanie czasu
        long czas_p = System.currentTimeMillis();
        HashSet<Integer> losy_komputera = new HashSet<>();
        while(!losy_komputera.equals(wlasne_typy))
        {
            losy_komputera = new HashSet<>();
            while (losy_komputera.size() < 6)
            {
                int nowa = losuj.nextInt(49) + 1;
                losy_komputera.add(nowa);
            }

            ilosc_losowan++;
        };
        long czas_k = System.currentTimeMillis();

        // Sortowanie losów użytkownika i komputera
        ArrayList<Integer> wlasne_typy_sort = new ArrayList<>(wlasne_typy);
        Collections.sort(wlasne_typy_sort);
        ArrayList<Integer> losy_komputera_sort = new ArrayList<>(losy_komputera);
        Collections.sort(losy_komputera_sort);

        // Wynik
        System.out.println("Liczby użytkownika: " + wlasne_typy_sort);
        System.out.println("Wylosowane liczby: " + losy_komputera_sort);
        System.out.println("Liczba losowań: " + ilosc_losowan);
        System.out.println("Czas losowań: " + (czas_k - czas_p));
    }
}
