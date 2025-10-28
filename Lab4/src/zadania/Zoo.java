package zadania;
import animals.Animal;

public class Zoo
{
    public static void main(String[] args)
    {
        Animal[] animals = new Animal[100];

        for (int i = 0; i < animals.length; i++)
        {
            animals[i] = Animal.getRandomAnimal();
            System.out.println("Zwierzę " + (i + 1) + ": " + animals[i].getDescription());
        }

        int nogi = ileNog(animals);
        System.out.println("\nŁączna liczba nóg: " + nogi);
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
