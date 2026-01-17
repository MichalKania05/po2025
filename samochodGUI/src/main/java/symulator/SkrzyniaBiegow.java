package symulator;
import static java.lang.Math.pow;

public class SkrzyniaBiegow extends Komponent
{
    // Pola
    private Samochod samochod;
    private int aktBieg;
    private final int iloscBiegow;
    private Sprzeglo sprzeglo;


    // Konstruktor
    public SkrzyniaBiegow(String producent, String model, String nazwa,
                          double waga, double cena, int iloscBiegow, Sprzeglo sprzeglo)
    {
        super(producent, model, nazwa, waga, cena); // Komponent
        this.iloscBiegow = iloscBiegow;
        this.aktBieg = getAktBieg();
        this.sprzeglo = sprzeglo;
    }

    // Metody
    public void zwiekszBieg()
    {
        if (sprzeglo.stanSprzegla() && (aktBieg < iloscBiegow))
        {
            aktBieg++;
            System.out.println("Zwiększono bieg: " + getAktBieg());
        }

        else
        {
            System.out.println("Nie można zwiększyć biegu!");
        }
    }

    public void zmniejszBieg()
    {
        if (sprzeglo.stanSprzegla() && (aktBieg > 0))
        {
            aktBieg--;
            System.out.println("Zmniejszono bieg: " + getAktBieg());
        }

        else
        {
            System.out.println("Nie można zmniejszyć biegu!");
        }
    }


    // Gettery
    public int getAktBieg()
    {
        return aktBieg;
    }

    public int getIloscBiegow()
    {
        return iloscBiegow;
    }

    public Sprzeglo getSprzeglo()
    {
        return sprzeglo;
    }

    public void setSprzeglo(Sprzeglo sprzeglo)
    {
        this.sprzeglo = sprzeglo;
    }
}
