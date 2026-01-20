package symulator;

public class Silnik extends Komponent {

    // Pola
    private final int maxObroty; // Maksymalne RPM nie do przekroczenia przez użytkownika
    private int obroty; // Zmienne RPM
    private int limitObrotow; // Wybrane przez użytkownika nie do przekroczenia przez program

    // Konstruktor
    public Silnik(String producent, String model, String nazwa,
                  double waga, double cena, int maxObroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
        this.limitObrotow = maxObroty; // Defaultowo takie samo jak maksymalne
    }

    // Metody
    public void uruchom() {
        if (obroty > 0) {
            throw new IllegalStateException("Silnik jest już uruchomiony");
        }
        obroty = 1000; // startowe obroty przy uruchomieniu
    }

    public void zatrzymaj() {
        if (obroty == 0) {
            throw new IllegalStateException("Silnik jest już wyłączony");
        }
        obroty = 0; // zerowane przy zatrzymaniu
    }

    public void zwiekszObroty() {
        if (obroty == 0) {
            throw new IllegalStateException("Nie można dodać gazu – silnik jest wyłączony");
        }

        if (obroty + 500 > limitObrotow) {
            obroty = limitObrotow; // ustaw na maksymalne obroty
            throw new IllegalStateException("Osiągnięto maksymalne obroty (" + limitObrotow + ") !");
        } else {
            obroty += 500;
        }
    }

    public void zmniejszObroty() {
        if (obroty == 0) {
            throw new IllegalStateException("Silnik jest wyłączony");
        }

        obroty -= 500;
        if (obroty < 0) obroty = 0; // Obroty nie mogą być ujemne
    }

    // Gettery
    public int getObroty() { return obroty; }
    public int getMaxObroty() {return maxObroty;}

    public void setLimitObrotow(int limit) {
        this.limitObrotow = Math.min(limit, maxObroty);
        if (obroty > limitObrotow) obroty = limitObrotow;
    }

    // Opis w ComboBoxie
    @Override
    public String toString() {
        return getNazwa() + " | "
                + maxObroty + " rpm" + " | "
                + getWaga() + " kg" + " | "
                + getCena() + " zł";
    }
}
