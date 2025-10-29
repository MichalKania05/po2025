package animals;

public class Snake extends Animal
{
    public Snake()
    {
        legs = 0;
        name = "Snake";
    }

    @Override
    public String getDescription()
    {
        return "Wąż, ilość nóg: " + legs;
    }

    @Override
    public void makeSound() {
        System.out.println("SSSSSSSSSS...");
    }
}
