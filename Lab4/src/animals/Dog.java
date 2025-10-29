package animals;

public class Dog extends Animal
{
    public Dog()
    {
        legs = 4;
        name = "Dog";
    }

    @Override
    public String getDescription()
    {
        return "Pies, ilość nóg: " + legs;
    }

    @Override
    public void makeSound() {
        System.out.println("Hau hau!");
    }
}

