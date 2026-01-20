package symulator;

public class SkrzyniaBiegow extends Komponent {

    // Pola
    private int aktBieg;
    private final int iloscBiegow;
    private Sprzeglo sprzeglo;

    // Konstruktor
    public SkrzyniaBiegow(String producent, String model, String nazwa,
                          double waga, double cena, int iloscBiegow,
                          Sprzeglo sprzeglo) {
        super(producent, model, nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktBieg = 0;
        this.sprzeglo = sprzeglo;
    }

    // Metody
    public void zwiekszBieg() {
        if (!sprzeglo.stanSprzegla()) {
            throw new IllegalStateException("Nie można zmienić biegu bez sprzęgła");
        }
        if (aktBieg >= iloscBiegow) {
            throw new IllegalStateException("To już najwyższy bieg");
        }
        aktBieg++;
    }

    public void zmniejszBieg() {
        if (!sprzeglo.stanSprzegla()) {
            throw new IllegalStateException("Nie można zmienić biegu bez sprzęgła");
        }
        if (aktBieg <= 0) {
            throw new IllegalStateException("To już najniższy bieg");
        }
        aktBieg--;
    }

    // Gettery
    public int getAktBieg() { return aktBieg; }
    public Sprzeglo getSprzeglo() { return sprzeglo; }
    public int getIloscBiegow() { return iloscBiegow; }

    // Opis w ComboBoxie
    @Override
    public String toString() {
        return getNazwa() + " | "
                + iloscBiegow + " biegów"
                + " | " + getWaga() + " kg"
                + " | " + getCena() + " zł";
    }

}
