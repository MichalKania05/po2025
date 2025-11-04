package symulator;

public class Samochod extends Pozycja
{
    // Pola
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private double maxPredkosc;


    // Konstruktor
    public Samochod(String nrRejest, String model, double maxPredkosc,
                    Silnik silnik, SkrzyniaBiegow skrzynia)
    {
        super(0, 0); // Pozycja
        this.nrRejest = nrRejest;
        this.model = model;
        this.maxPredkosc = maxPredkosc;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.stanWlaczenia = false; // Początkowo wyłączony
    }


    // Metody
    public void wlacz()
    {
        if (!stanWlaczenia)
        {
            silnik.uruchom();
            stanWlaczenia = true;
        }
    }

    public void wylacz()
    {
        if (stanWlaczenia)
        {
            silnik.zatrzymaj();
            while (skrzynia.getAktBieg() > 0)
            {
                skrzynia.zmniejszBieg();
            }
            stanWlaczenia = false;
        }
    }

    public void jedzDo(Pozycja cel)
    {
        double deltaX = cel.get_x() - this.get_x();
        double deltaY = cel.get_y() - this.get_y();
        aktPozycje(deltaX, deltaY);
    }

    public double getWaga()
    {
        return silnik.getWaga() + skrzynia.getWaga();
    }

    public double getAktPredkosc()
    {
        return silnik.getObroty() * skrzynia.getAktPrzelozenie();
    }

    public String getAktPozycja()
    {
        return getPozycja();
    }

    public boolean isStanWlaczenia()
    {
        return stanWlaczenia;
    }

    public String getNrRejest()
    {
        return nrRejest;
    }

    public String getModel()
    {
        return model;
    }

    public double getMaxPredkosc()
    {
        return maxPredkosc;
    }

    public Silnik getSilnik()
    {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia()
    {
        return skrzynia;
    }
}
