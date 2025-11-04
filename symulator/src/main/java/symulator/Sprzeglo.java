package symulator;

public class Sprzeglo extends Komponent
{
    // Pola
    private boolean stanSprzegla;


    // Konstruktor
    public Sprzeglo(String producent, String model, String nazwa, double waga, double cena)
    {
        super(producent, model, nazwa, waga, cena); // Komponent
        this.stanSprzegla = false; // Początkowo niewciśnięte
    }


    // Metody
    public void wcisnij()
    {
        stanSprzegla = true;
    }

    public void zwolnij()
    {
        stanSprzegla = false;
    }

    public boolean stanSprzegla()
    {
        return stanSprzegla;
    }
}
