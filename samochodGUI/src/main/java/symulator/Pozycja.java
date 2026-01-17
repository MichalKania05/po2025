package symulator;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Pozycja
{
    // Pola
    private double x;
    private double y;

    // Konstruktor
    public Pozycja(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // Metody
    public void aktPozycje(double deltaX, double deltaY)
    {
        this.x += deltaX;
        this.y += deltaY;
    }

    public String getPozycja()
    {
        return "Pozycja: (" + x + " , " + y + ")";
    }

    public synchronized void przemiesc(Pozycja cel, double predkosc, double deltaT)
    {
        double dx = cel.get_x() - x;
        double dy = cel.get_y() - y;
        double dystans = Math.sqrt(dx*dx + dy*dy);

        if(dystans < 1e-3)
        {
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

    // Settery
    public synchronized void set_x(double x) { this.x = x; }
    public synchronized void set_y(double y) { this.y = y; }
}
