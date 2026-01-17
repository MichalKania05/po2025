package symulator;

import java.util.ArrayList;
import java.util.List;

public class Samochod extends Thread {

    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private double maxPredkosc;

    private Pozycja pozycja;
    private Pozycja cel;

    private static final double DELTA_T = 0.1; // 100 ms
    private static final long SLEEP_MS = 100;


    public Samochod(String nrRejest, String model, double maxPredkosc,
                    Silnik silnik, SkrzyniaBiegow skrzynia)
    {
        this.nrRejest = nrRejest;
        this.model = model;
        this.maxPredkosc = maxPredkosc;
        this.silnik = silnik;
        this.skrzynia = skrzynia;

        this.stanWlaczenia = false;
        this.pozycja = new Pozycja(0, 0);
        this.cel = null;

        start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (stanWlaczenia && cel != null) {
                    double V = getAktPredkosc();

                    if (V > 0) {
                        pozycja.przemiesc(cel, V, DELTA_T);

                        // Powiadamiamy GUI, że coś się zmieniło
                        notifyListeners();

                        // Jeśli dojechaliśmy do celu – zatrzymujemy cel
                        if (pozycja.get_x() == cel.get_x()
                                && pozycja.get_y() == cel.get_y()) {
                            cel = null;
                        }
                    }
                }

                Thread.sleep(SLEEP_MS);

            } catch (InterruptedException e) {
                break;
            }
        }
    }

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
            while (skrzynia.getAktBieg() > 0) {skrzynia.zmniejszBieg();}
            stanWlaczenia = false;
            cel = null;
        }
    }

    public void jedzDo(Pozycja nowyCel)
    {
        if (stanWlaczenia)
        {
            this.cel = nowyCel;
        }
    }

    // --- Gettery ---
    public Pozycja getPozycja() {return pozycja;}

    public double getWaga() {return silnik.getWaga() + skrzynia.getWaga();}

    public double getAktPredkosc()
    {
        if (skrzynia.getAktBieg() == 0) return 0;
        return silnik.getObroty() * skrzynia.getAktBieg() * 0.1;
    }

    public boolean isStanWlaczenia() {return stanWlaczenia;}

    public String getNrRejest() {return nrRejest;}

    public String getModel() {return model;}

    public double getMaxPredkosc() {return maxPredkosc;}

    public Silnik getSilnik() {return silnik;}

    public SkrzyniaBiegow getSkrzynia() {return skrzynia;}

    @Override
    public String toString() {return model + " (" + nrRejest + ")";}

    // Obserwatorzy
    private List<Runnable> listeners = new ArrayList<>();
    public void addListener(Runnable listener) {listeners.add(listener);}
    private void notifyListeners()
    {
        for (Runnable listener : listeners)
        {listener.run();}
    }
}
