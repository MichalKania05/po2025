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
        System.out.println("Wciśnięto sprzęgło!");
    }

    public void zwolnij()
    {
        stanSprzegla = false;
        System.out.println("Zwolniono sprzęgło!");
    }

    public boolean stanSprzegla()
    {
        return stanSprzegla;
    }
}
