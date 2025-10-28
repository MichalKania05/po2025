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
        return "Dog, ilość nóg: " + legs;
    }
}

