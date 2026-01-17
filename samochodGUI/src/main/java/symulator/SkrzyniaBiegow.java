package symulator;

public class SkrzyniaBiegow extends Komponent {

    private int aktBieg;
    private final int iloscBiegow;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String producent, String model, String nazwa,
                          double waga, double cena, int iloscBiegow,
                          Sprzeglo sprzeglo) {
        super(producent, model, nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktBieg = 0;
        this.sprzeglo = sprzeglo;
    }

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

    public int getAktBieg() { return aktBieg; }
    public int getIloscBiegow() { return iloscBiegow; }
    public Sprzeglo getSprzeglo() { return sprzeglo; }
}
