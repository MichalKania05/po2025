package symulator;

abstract class Komponent
{
    // Pola
    private String producent;
    private String model;
    private String nazwa;
    private double waga;
    private double cena;

    // Konstruktor
    public Komponent(String producent, String model, String nazwa,
                     double waga, double cena) {
        this.producent = producent;
        this.model = model;
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    // Gettery
    public String getNazwa() {return nazwa;}

    public double getWaga() {return waga;}

    public double getCena() {return cena;}
}
