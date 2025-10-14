

import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto3
{
    public static void main(String[] args)
    {
        Scanner wczyt = new Scanner(System.in);
        System.out.print("Podaj liczby: ");
        int liczby1 = wczyt.nextInt();

        ArrayList<Integer> wylosowane = new ArrayList<>();
        Random losuj = new Random();

        while (wylosowane.size() < 6) // Losowanie
        {
            int nowa = losuj.nextInt(49) + 1;
            wylosowane.add(nowa);
        }

        System.out.println("Wylosowane liczby: "); // Wypisanie
        for (int liczba : wylosowane)
        {
            System.out.print(liczba + " ");
        }
    }
}

