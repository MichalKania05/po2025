package symulator;
import static java.lang.Math.pow;

public class SkrzyniaBiegow extends Komponent
{
    // Pola
    private int aktBieg;
    private final int iloscBiegow;
    private double aktPrzelozenie;
    private Sprzeglo sprzeglo;


    // Konstruktor
    public SkrzyniaBiegow(String producent, String model, String nazwa,
                          double waga, double cena, int iloscBiegow, Sprzeglo sprzeglo)
    {
        super(producent, model, nazwa, waga, cena); // Komponent
        this.iloscBiegow = iloscBiegow;
        this.aktBieg = getAktBieg();
        this.aktPrzelozenie = 0.0;
        this.sprzeglo = sprzeglo;
    }


    // Metody
    public void zwiekszBieg()
    {
        if (sprzeglo.stanSprzegla() && (aktBieg < iloscBiegow))
        {
            aktBieg++;

            if (aktBieg == 0)
                {aktPrzelozenie = 0.0;}
            else
                {aktPrzelozenie = 3.8 / pow(aktBieg, 0.85);}
        }
    }

    public void zmniejszBieg()
    {
        if (sprzeglo.stanSprzegla() && (aktBieg > 0))
        {
            aktBieg--;

            if (aktBieg == 0)
                {aktPrzelozenie = 0.0;}
            else
            {aktPrzelozenie = 3.8 / pow(aktBieg, 0.85);}
        }
    }


    // Gettery
    public int getAktBieg()
    {
        return aktBieg;
    }

    public double getAktPrzelozenie()
    {
        return aktPrzelozenie;
    }

    public int getIloscBiegow()
    {
        return iloscBiegow;
    }

    public Sprzeglo getSprzeglo()
    {
        return sprzeglo;
    }

    /*
    public void setSprzeglo(Sprzeglo sprzeglo)
    {
        this.sprzeglo = sprzeglo;
    }*/
}
