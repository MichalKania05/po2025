import static org.junit.Assert.*;

public class CodingBatTest
{

    // Test diff21()
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


    // Test startHi()
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


    // Test firstHalf()
    @org.junit.Test
    public void firstHalf()
    {
        assertEquals("Woo", new CodingBat().firstHalf("WooHoo"));
        assertEquals("Hello", new CodingBat().firstHalf("HelloThere"));
        assertEquals("abc", new CodingBat().firstHalf("abcdef"));
        assertEquals("a", new CodingBat().firstHalf("ab"));
        assertEquals("", new CodingBat().firstHalf(""));
        assertEquals("01234", new CodingBat().firstHalf("0123456789"));
        assertEquals("kit", new CodingBat().firstHalf("kitten"));
    }


    // Test countEvens()
    @org.junit.Test
    public void countEvens()
    {
        int[] cE1 = {2,1,2,3,4};
        int[] cE2 = {2, 2, 0};
        int[] cE3 = {1, 3, 5};
        int[] cE4 = {};
        int[] cE5 = {11, 9, 0, 1};
        int[] cE6 = {2, 11, 9, 0};
        int[] cE7 = {2};
        int[] cE8 = {2, 5, 12};
        assertEquals(3, new CodingBat().countEvens(cE1));
        assertEquals(3, new CodingBat().countEvens(cE2));
        assertEquals(0, new CodingBat().countEvens(cE3));
        assertEquals(0, new CodingBat().countEvens(cE4));
        assertEquals(1, new CodingBat().countEvens(cE5));
        assertEquals(2, new CodingBat().countEvens(cE6));
        assertEquals(1, new CodingBat().countEvens(cE7));
        assertEquals(2, new CodingBat().countEvens(cE8));
    }

}