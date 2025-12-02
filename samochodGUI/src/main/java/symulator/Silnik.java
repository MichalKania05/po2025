
package symulator;

public class Silnik extends Komponent
{
    // Pola
    private final int maxObroty;
    private int obroty;


    // Konstruktor
    public Silnik(String producent, String model, String nazwa, double waga, double cena, int maxObroty)
    {
        super(producent, model, nazwa, waga, cena); // Komponent
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }


    // Metody
    public void uruchom()
    {
        if (obroty == 0)
        {obroty = 1000;}

        System.out.println("Uruchomiono silnik!");
    }

    public void zatrzymaj()
    {
        obroty = 0;
        System.out.println("Zatrzymano silnik!");
    }

    public void zwiekszObroty()
    {
        if (obroty > 0)
        {
            obroty += 100;

            if (obroty > maxObroty)
            {obroty = maxObroty;}

            System.out.println("Zwiększono obroty: " + getObroty());
        }
    }

    public void zmniejszObroty()
    {
        if (obroty > 0)
        {
            obroty -= 100;

            if (obroty < 0)
            {obroty = 0;}

            System.out.println("Zmniejszono obroty: " + getObroty());
        }
    }


    // Gettery
    public int getMaxObroty()
    {
        return maxObroty;
    }

    public int getObroty()
    {
        return obroty;
    }
}
