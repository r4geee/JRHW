package Cone;

import java.util.*;


public class aa {

    static int[] numbers = {1, 2, 3};
    static List<int[]> endres = new ArrayList<>();
    static int counter = 0;

    public static void main(String[] args) {
        f(null);
        System.out.println(counter);
    }

    static void f(Stack stack) {
        if (stack == null ) {
            stack = new Stack<>();
        }
        for (int i = 0; i < 5; i++) {
            if (stack.contains(i)) {
                if(stack.size() == 5){
                    System.out.println(stack);
                    counter++;
                    break;
                }
            } else {
                stack.push(i);
                f(stack);
                stack.pop();
            }

        }
    }
}
