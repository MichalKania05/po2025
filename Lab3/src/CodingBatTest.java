import static org.junit.Assert.*;

public class CodingBatTest
{
    @org.junit.Test
    public void diff21()
    {
        assertEquals(2, new CodingBat().diff21(19));
        assertEquals(11, new CodingBat().diff21(10));
        assertEquals(0, new CodingBat().diff21(21));
        assertEquals(2, new CodingBat().diff21(22));
        assertEquals(8, new CodingBat().diff21(25));
        assertEquals(18, new CodingBat().diff21(30));
        assertEquals(21, new CodingBat().diff21(0));
        assertEquals(20, new CodingBat().diff21(1));
        assertEquals(19, new CodingBat().diff21(2));
        assertEquals(22, new CodingBat().diff21(-1));
        assertEquals(23, new CodingBat().diff21(-2));
        assertEquals(58, new CodingBat().diff21(50));
    }

    @org.junit.Test
    public void startHi()
    {
        assertEquals(true, new CodingBat().startHi("hi there"));
        assertEquals(true, new CodingBat().startHi("hi"));
        assertEquals(false, new CodingBat().startHi("hello hi"));
        assertEquals(false, new CodingBat().startHi("he"));
        assertEquals(false, new CodingBat().startHi("h"));
        assertEquals(false, new CodingBat().startHi(""));
        assertEquals(false, new CodingBat().startHi("ho hi"));
        assertEquals(true, new CodingBat().startHi("hi ho"));
    }

    //@org.junit.Test
    //public void firstHalf() {
    //}

    //@org.junit.Test
    //public void countEvens() {
    //}
}