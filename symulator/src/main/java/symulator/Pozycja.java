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

    // DOPISAĆ METODĘ PRZEMIEŚĆ
    // cel, predkosc, deltaT,
    // tak zmienia pozycję, aby przemieścić go z predkoscia V w kierunku celu
    // Wykonuje jeden krok, nie robić tu pętli, a jak juz to w klasie Samochód
    // Działa poprawnie ale nie o to chodziło
    public void przemiesc(Pozycja cel, double V, double deltaT)
    {
        double x1 = this.get_x();
        double y1 = this.get_y();
        double x2 = cel.get_x();
        double y2 = cel.get_y();
        double X_calk = abs(x2 - x1); // Całkowite przemieszczenie w osi OX
        double Y_calk = abs(y2 - y1); // Całkowite przemieszczenie w osi OY
        double O_calk = sqrt(pow(X_calk, 2) + pow(Y_calk, 2)); // Całkowita odległość do pokonania
        double dO = V * deltaT; // Taki kawałek drogi pokonuje z prędkością V w czasie deltaT
        double dx = X_calk * (dO/O_calk);
        double dy = Y_calk * (dO/O_calk);

        int k = 1;
        while(true)
        {
            if(k*dx <= X_calk && k*dy <= Y_calk)
            {
                aktPozycje(k*dx, k*dy);
                System.out.println("Nieznacznie przesunięto samochód: (" + (x1+k*dx) + " , " + (y1+k*dy) + ") ");
                k += 1;
            }

            else
            {
                aktPozycje(x2, y2);
                System.out.println("Samochód dojechał do celu: (" + x2 + " , " + y2 + ") ");
                break;
            }
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
