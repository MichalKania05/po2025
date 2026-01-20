package symulator;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Pozycja
{
    // Pola
    private double x;
    private double y;

    // Konstruktor
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Metoda do krokowego przemieszczania
    public synchronized void przemiesc(Pozycja cel, double predkosc, double deltaT)
    {
        double dx = cel.get_x() - x;
        double dy = cel.get_y() - y;
        double dystans = Math.sqrt(dx*dx + dy*dy);

        if(dystans < 1e-3) {    // Bardzo blisko celu
            x = cel.get_x();
            y = cel.get_y();
            return;
        }

        double maxDist = predkosc * deltaT;
        double ratio = Math.min(1.0, maxDist / dystans);

        x += dx * ratio;
        y += dy * ratio;
    }

    // Gettery
    public synchronized double get_x() { return x; }
    public synchronized double get_y() { return y; }
}
