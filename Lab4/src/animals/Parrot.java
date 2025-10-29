package animals;

public class Parrot extends Animal
{
    public Parrot()
    {
        legs = 2;
        name = "Parrot";
    }

    @Override
    public String getDescription()
    {
        return "Papuga, ilość nóg: " + legs;
    }

    @Override
    public void makeSound() {
        System.out.println("Ćwir ćwir!");
    }
}
