package zadania;
import animals.*;

public class Zoo
{
    public static void main(String[] args)
    {
        Animal[] animals = new Animal[100];

        for (int i = 0; i < animals.length; i++)
        {
            animals[i] = Animal.getRandomAnimal();
            System.out.println("\n[!] Zwierzę nr " + (i + 1) + " [!]");
            System.out.println(animals[i].getDescription());
            animals[i].makeSound();
        }

        int nogi_suma = ileNog(animals);
        System.out.println("\nŁączna liczba nóg: " + nogi_suma);
    }

    public static int ileNog(Animal[] animals)
    {
        int ilosc = 0;
        for (Animal animal : animals)
        {
            ilosc += animal.legs;
        }
        return ilosc;
    }

}
