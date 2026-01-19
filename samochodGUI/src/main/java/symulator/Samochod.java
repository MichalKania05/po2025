package symulator;

import javafx.application.Platform;

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

    private static final double DELTA_T = 0.01;
    private static final long SLEEP_MS = 100;

    private volatile boolean running = true;

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
        while (running) {
            try {
                if (stanWlaczenia && cel != null) {
                    double V = getAktPredkosc();

                    if (V > 0) {
                        pozycja.przemiesc(cel, V, DELTA_T);
                        notifyListeners();

                        if (pozycja.get_x() == cel.get_x() && pozycja.get_y() == cel.get_y()) {

                            cel = null;

                            try {
                                skrzynia.getSprzeglo().zwolnij();
                            } catch (IllegalStateException ignored) {}

                            while (skrzynia.getAktBieg() > 0) {
                                try {
                                    skrzynia.zmniejszBieg();
                                } catch (IllegalStateException ignored) {}
                            }

                            try {
                                silnik.zatrzymaj();
                            } catch (IllegalStateException ignored) {}

                            resetujStan();
                            notifyListeners();
                        }
                    }
                }

                Thread.sleep(SLEEP_MS);

            } catch (InterruptedException e) {
                if (!running) break;
            }
        }
    }


    public void wlacz() {
        if (silnik.getObroty() > 0) {
            throw new IllegalStateException("Samochód jest już włączony");
        }
        silnik.uruchom();
        stanWlaczenia = true;
    }

    public void wylacz() {
        if (silnik.getObroty() == 0) {
            throw new IllegalStateException("Samochód jest już wyłączony");
        }
        silnik.zatrzymaj();
        stanWlaczenia = false;
        resetujStan();
        notifyListeners();
    }

    public void jedzDo(Pozycja nowyCel)
    {
        if (stanWlaczenia)
        {
            this.cel = nowyCel;
        }
    }

    public void stopSamochod() {
        running = false;
        interrupt();
    }

    private void resetujStan() {

        synchronized (this) {

            try { skrzynia.getSprzeglo().wcisnij(); } catch (IllegalStateException ignored) {}

            while (skrzynia.getAktBieg() > 0) {
                try { skrzynia.zmniejszBieg(); } catch (IllegalStateException ignored) {}
            }

            try { skrzynia.getSprzeglo().zwolnij(); } catch (IllegalStateException ignored) {}

            try { silnik.zatrzymaj(); } catch (IllegalStateException ignored) {}}

        cel = null;
        Platform.runLater(this::notifyListeners);
    }

    // --- Gettery ---
    public Pozycja getPozycja() {return pozycja;}

    public double getWaga() {return silnik.getWaga() + skrzynia.getWaga();}

    public double getAktPredkosc()
    {
        if (skrzynia.getAktBieg() == 0) return 0;
        double predkosc = silnik.getObroty() * skrzynia.getAktBieg() * 0.1;
        return Math.min(predkosc, maxPredkosc);
    }


    public String getNrRejest() {return nrRejest;}

    public String getModel() {return model;}

    public Silnik getSilnik() {return silnik;}

    public SkrzyniaBiegow getSkrzynia() {return skrzynia;}

    @Override
    public String toString() {return model + " (" + nrRejest + ")";}

    // Obserwatorzy
    private List<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener) {listeners.add(listener);}
    public void removeListener(Listener listener) {listeners.remove(listener);}
    private void notifyListeners() { Platform.runLater(() -> {
        for (Listener l : listeners) {
            l.update();
        }
    }); }
}
