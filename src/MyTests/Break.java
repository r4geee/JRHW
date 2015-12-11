package MyTests;

/**
 * Created by r4geee on 27.06.2014.
 */
public class Break {

    public static void main(String[] args) {
/*        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Перед оператором break.");
                    if (t) {
                        break second; // выход из блока second
                    }
                    System.out.println("Данный оператор никогда не выполнится");
                }
                System.out.println("Данный оператор никогда не выполнится ");
            }
            System.out.println("Данный оператор размещен после блока second.");
        }

        AvTest.AsdQwe asdQwe = new AvTest.AsdQwe();*/
        int a = 0;
        while (true)
        {
            System.out.println(a++);
            if (a == 10)
            {
                break;
            }
        }
    }
}
