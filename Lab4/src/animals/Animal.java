package animals;
import java.util.Random;

public abstract class Animal
{
    public String name;
    public int legs;

    public abstract String getDescription();

    public abstract void makeSound();

    public static Animal getRandomAnimal()
    {
        Random losowe = new Random();
        int index = losowe.nextInt(3);
        switch (index)
        {
            case 0:
                return new Dog();
            case 1:
                return new Parrot();
            default:
                return new Snake();
        }
    }

    public int getLegs()
    {
        return legs;
    }
}
