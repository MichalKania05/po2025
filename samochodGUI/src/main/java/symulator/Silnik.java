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
        obroty = 1000;
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

        obroty += 100;
        if (obroty > maxObroty) {
            obroty = maxObroty;
        }
    }

    public void zmniejszObroty() {
        if (obroty == 0) {
            throw new IllegalStateException("Silnik jest wyłączony");
        }

        obroty -= 100;
        if (obroty < 0) {
            obroty = 0;
        }
    }

    public int getMaxObroty() { return maxObroty; }
    public int getObroty() { return obroty; }
}
