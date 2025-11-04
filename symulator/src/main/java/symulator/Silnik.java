
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
    }

    public void zatrzymaj()
    {
        obroty = 0;
    }

    public void zwiekszObroty()
    {
        if ((obroty > 0) && (obroty + 100 <= maxObroty))
        {obroty += 100;}

        else if (obroty + 100 > maxObroty)
        {obroty = maxObroty;}
    }

    public void zmniejszObroty()
    {
        if (obroty > 800)
        {obroty -= 100;}

        else if ((obroty > 0) && (obroty <= 800))
        {obroty = 1000;}
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
