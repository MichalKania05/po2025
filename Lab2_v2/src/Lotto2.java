
import java.util.ArrayList;
import java.util.Random;
import java.util.HashSet;

public class Lotto2
{
    public static void main(String[] args)
    {
        System.out.println("Argument count: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }

        ArrayList<Integer> wylosowane = new ArrayList<>();
        Random losuj = new Random();

        int trafienia = 0;

        while (wylosowane.size() < 6)
        {
            int nowa = losuj.nextInt(49) + 1;
            wylosowane.add(nowa);
            for(int i=0 ; i<=5 ; i=i+1)
            {
                if(args[i] == nowa)
                {
                    trafienia = trafienia + 1;
                }
            }
        }

        System.out.println("Wylosowane liczby: ");
        for (int liczba : wylosowane)
        {
            System.out.print(liczba + " ");
        }
        System.out.println();

        System.out.println("Liczba trafień: " + trafienia);
    }
}

