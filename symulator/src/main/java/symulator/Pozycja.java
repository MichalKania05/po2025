package symulator;

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
