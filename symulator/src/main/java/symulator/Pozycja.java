package symulator;
import static java.lang.Math.*;

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

    public void przemiesc(Pozycja cel, double V, double deltaT)
    {
        double x1 = this.get_x();
        double y1 = this.get_y();
        double x2 = cel.get_x();
        double y2 = cel.get_y();
        double deltaX = x2 - x1; // Całkowite przemieszczenie w osi OX
        double deltaY = y2 - y1; // Całkowite przemieszczenie w osi OY
        double odleglosc = sqrt(pow(deltaX, 2) + pow(deltaY, 2)); // Całkowita odległość do pokonania
        double kawalek = V * deltaT; // Taki dystans pokonuje samochód z prędkością V w czasie deltaT

        if(odleglosc <= kawalek)
        {
            this.x = x2;
            this.y = y2;
        }

        else
        {
            this.x += deltaX * (kawalek/odleglosc);
            this.y += deltaY * (kawalek/odleglosc);
        }
    }


    // Gettery
    public double get_x()
    {
        return x;
    }

    public double get_y()
    {
        return y;
    }
}
