
import java.util.Random;
import java.util.HashSet; // Odrzuca duplikaty

public class Lotto
{
    public static void main(String[] args)
    {
        HashSet<Integer> wylosowane = new HashSet<>();
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

