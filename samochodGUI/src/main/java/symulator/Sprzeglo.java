package symulator;

public class Sprzeglo extends Komponent {

    // Pole
    private boolean stanSprzegla;

    // Konstruktor
    public Sprzeglo(String producent, String model, String nazwa,
                    double waga, double cena) {
        super(producent, model, nazwa, waga, cena);
        this.stanSprzegla = false;
    }

    // Metody
    public void wcisnij() {
        if (stanSprzegla) {
            throw new IllegalStateException("Sprzęgło jest już wciśnięte");
        }
        stanSprzegla = true;
    }

    public void zwolnij() {
        if (!stanSprzegla) {
            throw new IllegalStateException("Sprzęgło jest już zwolnione");
        }
        stanSprzegla = false;
    }

    public boolean stanSprzegla() {
        return stanSprzegla;
    }
}
