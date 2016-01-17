package MyTests.raznoe;

/**
 * Created by r4geee on 27.06.2014.
 */
public class Continue {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("");
        }
        int i = 0 % 1;
        System.out.println(i);
    }


}