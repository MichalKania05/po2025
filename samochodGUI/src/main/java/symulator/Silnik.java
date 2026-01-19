package symulator;

public class Silnik extends Komponent {

    private final int maxObroty;
    private int obroty;

    public Silnik(String producent, String model, String nazwa,
                  double waga, double cena, int maxObroty) {
        super(producent, model, nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }

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
        obroty = 0;
    }

    public void zwiekszObroty() {
        if (obroty == 0) {
            throw new IllegalStateException("Nie można dodać gazu – silnik jest wyłączony");
        }

        if (obroty + 500 > maxObroty) {
            throw new IllegalStateException("Przekroczono maksymalne obroty (" + maxObroty + ")");
        }

        obroty += 500;
    }

    public void zmniejszObroty() {
        if (obroty == 0) {
            throw new IllegalStateException("Silnik jest wyłączony");
        }

        if (obroty - 500 < 0) {
            throw new IllegalStateException("Obroty nie mogą być ujemne");
        }

        obroty -= 500;
    }

    public int getMaxObroty() { return maxObroty; }
    public int getObroty() { return obroty; }
}
