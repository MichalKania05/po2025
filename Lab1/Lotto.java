
import java.util.Random;

public class Lotto {
    public static void main(String[] args){
        
        Random los = new Random();
        int n1 = los.nextInt(1, 3);
        int n2 = los.nextInt(1, 3);
        int n3 = los.nextInt(1, 3);
        
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
    }
}
