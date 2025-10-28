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
        return "Snake, ilość nóg: " + legs;
    }
}
