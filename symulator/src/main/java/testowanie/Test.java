package testowanie;
import symulator.*;

public class Test
{
    public static void main(String[] args)
    {
        Sprzeglo spr1 = new Sprzeglo("idk", "SP1",
                "Sprzeglo1", 0.005, 250);

        SkrzyniaBiegow sb1 = new SkrzyniaBiegow("Skrzyniarz", "SB1",
                "Skrzynia1", 25, 5000, 6, spr1);

        Silnik sil1 = new Silnik("Tworca Silnikow", "SIL1",
                "Silnik1", 10000, 50000, 8000);

        Samochod sam1 = new Samochod("XYZ-1234", "Golf 5",
                250, sil1, sb1);

        System.out.println(sam1.getWaga()); // Zobaczyć czy zadziała jak się dorobi komponenty

    }
}
