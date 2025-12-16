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
            System.out.println("Włączono samochód! ");
        }

        else
        {
            System.out.println("Samochód jest już włączony! ");
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
            System.out.println("Wyłączono samochód! ");
        }

        else
        {
            System.out.println("Samochód jest już wyłączony! ");
        }
    }

    public void jedzDo(Pozycja cel)
    {
        if(stanWlaczenia)
        {
            double deltaX = cel.get_x() - this.get_x();
            double deltaY = cel.get_y() - this.get_y();
            aktPozycje(deltaX, deltaY);
        }
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


    // Testowanie klasy
        public static void main(String[] args) {
            Sprzeglo spr1 = new Sprzeglo("S", "SP1",
                    "Sprzeglo1", 0.005, 250);

            SkrzyniaBiegow sb1 = new SkrzyniaBiegow("P", "SB1",
                    "Skrzynia1", 25, 5000, 6, spr1);

            Silnik sil1 = new Silnik("S", "SIL1",
                    "Silnik1", 10000, 50000, 8000);

            Samochod sam1 = new Samochod("XYZ-1234", "Golf 5",
                    250, sil1, sb1);


            // TESTOWANIE
            System.out.println("Czy samochód włączony: " + sam1.isStanWlaczenia());
            System.out.println("Czy sprzęgło wciśnięte: " + spr1.stanSprzegla());
            sam1.wlacz();
            spr1.wcisnij();
            System.out.println("Czy samochód włączony: " + sam1.isStanWlaczenia());
            System.out.println("Czy sprzęgło wciśnięte: " + spr1.stanSprzegla());

            sb1.zwiekszBieg();
            sb1.zwiekszBieg();
            sb1.zwiekszBieg();
            sb1.zmniejszBieg();
            sb1.zmniejszBieg();
            System.out.println("Aktualny bieg: " + sb1.getAktBieg());
            System.out.println("Aktualna prędkość: " + sam1.getAktPredkosc());
            System.out.println("Aktualne przełożenie: " + sb1.getAktPrzelozenie());
            sb1.zmniejszBieg();
            sb1.zmniejszBieg();

            System.out.println(sam1.getAktPozycja());
            Pozycja cel1 = new Pozycja(4, 5);
            sam1.jedzDo(cel1);
            System.out.println(sam1.getAktPozycja());
            Pozycja cel2 = new Pozycja(-3, -2);
            sam1.jedzDo(cel2);
            System.out.println(sam1.getAktPozycja() + "\n");

            // Sprawdzenie nowej metody
            Pozycja cel3 = new Pozycja(7, 18);
            System.out.println(sam1.getAktPozycja());
            while (sam1.get_x() != cel3.get_x() || sam1.get_y() != cel3.get_y())
            {
                sam1.przemiesc(cel3, 2, 0.2);
                System.out.println(sam1.getAktPozycja());
            }

            Pozycja poczatek = new Pozycja(0, 0);
            System.out.println(sam1.getAktPozycja());
            while (sam1.get_x() != poczatek.get_x() || sam1.get_y() != poczatek.get_y())
            {
                sam1.przemiesc(poczatek, 4, 0.5);
                System.out.println(sam1.getAktPozycja());
            }

            spr1.zwolnij();
            sam1.wylacz();
            System.out.println("Czy samochód włączony: " + sam1.isStanWlaczenia());
            System.out.println("Czy sprzęgło wciśnięte: " + spr1.stanSprzegla());
        }
}
