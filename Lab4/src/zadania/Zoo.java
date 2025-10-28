package zadania;
import animals.Animal;
import java.util.Random;

public class Zoo
{
    public static void main(String[] args) {
        Animal[] animals = new Animal[100];
        for (int i = 0; i <= 99; i++) {
            animals[i] = Animal.getRandomAnimal();
            System.out.println("Zwierzę " + (i + 1) + ": ");
            System.out.println(animals[i].toString());
        }
    }
}
