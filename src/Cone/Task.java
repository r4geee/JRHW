package Cone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Алексей Ростовщиков - 23.11
 */
public class Task {

    static int[][] input;

    public static void main(String[] args) throws IOException {
        input = getInput();
        visualiseSimple(input);
        System.out.println();
        System.out.println("Results");
        f(null);
    }

    //рекурсивно подбираем все варианты в каждый квадратик, если условию не удовлетворяет, то дальше не идем
    static void f(Stack<Integer> stack) {
        if (stack == null) {
            stack = new Stack<>();
        }
        for (int i = 0; i < 12; i++) {
            if (stack.contains(i)) {
                if (stack.size() == 12) {
                    List<Integer> list = new ArrayList<>(stack);
                    int[][] ints = new int[12][4];
                    for (int j = 0; j < 12; j++) {
                        ints[j] = input[list.get(j)];
                    }
                    visualiseSimple(ints);
                    System.out.println("=======");
                    break;
                }
            } else {
                List<Integer> list = new ArrayList<>(stack);
                //последовательно проверяем все необходимые условия для каждого подбираемого квадрата
                if (stack.size() == 1) {
                    if (input[list.get(list.size() - 1)][1] + input[i][0] > 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10)
                        continue;
                }
                if (stack.size() == 2) {
                    if (input[list.get(list.size() - 2)][2] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 3) {
                    if (input[list.get(list.size() - 1)][1] + input[list.get(list.size() - 3)][2] + input[i][0] > 10 || input[list.get(list.size() - 3)][3] + input[list.get(list.size() - 2)][2] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 4) {
                    if (input[list.get(list.size() - 4)][3] + input[list.get(list.size() - 3)][2] + input[list.get(list.size() - 1)][1] + input[i][0] != 10 || input[list.get(list.size() - 3)][3] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 5) {
                    if (input[list.get(list.size() - 4)][3] + input[list.get(list.size() - 1)][1] + input[i][0] > 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10)
                        continue;
                }
                if (stack.size() == 6) {
                    if (input[list.get(list.size() - 4)][2] + input[i][0] > 10 || input[list.get(list.size() - 4)][3] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 7) {
                    if (input[list.get(list.size() - 5)][3] + input[list.get(list.size() - 4)][2] + input[list.get(list.size() - 1)][1] + input[i][0] != 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10 || input[list.get(list.size() - 4)][3] + input[list.get(list.size() - 3)][2] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 8) {
                    if (input[list.get(list.size() - 5)][3] + input[list.get(list.size() - 4)][2] + input[list.get(list.size() - 1)][1] + input[i][0] != 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10 || input[list.get(list.size() - 4)][3] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 9) {
                    if (input[list.get(list.size() - 5)][3] + input[list.get(list.size() - 4)][2] + input[list.get(list.size() - 1)][1] + input[i][0] != 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10 || input[list.get(list.size() - 4)][3] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 10) {
                    if (input[list.get(list.size() - 4)][3] + input[list.get(list.size() - 3)][2] + input[i][0] > 10 || input[list.get(list.size() - 3)][3] + input[list.get(list.size() - 2)][2] + input[i][1] > 10)
                        continue;
                }
                if (stack.size() == 11) {
                    if (input[list.get(list.size() - 4)][3] + input[list.get(list.size() - 3)][2] + input[list.get(list.size() - 1)][1] + input[i][0] != 10 || input[list.get(list.size() - 1)][3] + input[i][2] > 10 || input[list.get(list.size() - 3)][3] + input[list.get(list.size() - 2)][2] + input[i][1] > 10)
                        continue;
                }
                stack.push(i);
                f(stack);
                stack.pop();
            }

        }
    }

    // читаем входные данные из файла
    private static int[][] getInput() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("D:/input.txt"));
        int[][] arrayOfArrays = new int[12][4];
        int i = 0;
        while (bufferedReader.ready()) {
            String[] sNumbers = bufferedReader.readLine().split(" ");
            int[] ints = new int[4];
            for (int y = 0; y < 4; y++) {
                ints[y] = Integer.valueOf(sNumbers[y]);
            }
            arrayOfArrays[i] = ints;
            i++;
        }
        return arrayOfArrays;
    }

    // вывод результата
    private static void visualiseSimple(int[][] ints) {
        for (int[] sqare : ints) {
            for (int number : sqare){
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    //Рисует схемку как в задании, можно использовать заместо visualiseSimple
/*    private static void visualise(int[][] ints) {
        System.out.println("       _______________        ");
        System.out.println("       |" + ints[0][0] + "    " + ints[0][1] + "|" + ints[1][0] + "    " + ints[1][1] + "|"+ "        ");
        System.out.println("       |      |      |       ");
        System.out.println("       " + "|" + ints[0][2] + "    " + ints[0][3] + "|" + ints[1][2] + "    " + ints[1][3] + "|" + "        ");
        System.out.println(" ______|______|______|______");
        System.out.println("|" + ints[2][0] + "    " + ints[2][1] + "|" + ints[3][0] + "    " + ints[3][1] + "|" + ints[4][0] + "    " + ints[4][1] + "|" + ints[5][0] + "    " + ints[5][1] + "|");
        System.out.println("|      |      |      |      |");
        System.out.println("|" + ints[2][2] + "    " + ints[2][3] + "|" + ints[3][2] + "    " + ints[3][3] + "|" + ints[4][2] + "    " + ints[4][3] + "|" + ints[5][2] + "    " + ints[5][3] + "|");
        System.out.println("|______|______|______|______|");
        System.out.println("|" + ints[6][0] + "    " + ints[6][1] + "|" + ints[7][0] + "    " + ints[7][1] + "|" + ints[8][0] + "    " + ints[8][1] + "|" + ints[9][0] + "    " + ints[9][1] + "|");
        System.out.println("|      |      |      |      |");
        System.out.println("|" + ints[6][2] + "    " + ints[6][3] + "|" + ints[7][2] + "    " + ints[7][3] + "|" + ints[8][2] + "    " + ints[8][3] + "|" + ints[9][2] + "    " + ints[9][3] + "|");
        System.out.println("|______|______|______|______|");
        System.out.println("       |" + ints[10][0] + "    " + ints[10][1] + "|" + ints[11][0] + "    " + ints[11][1] + "|" + "        ");
        System.out.println("       |      |      |       ");
        System.out.println("       " + "|" + ints[10][2] + "    " + ints[10][3] + "|" + ints[11][2] + "    " + ints[11][3] + "|" + "        ");
        System.out.println("       |______|______|       ");
    }*/
}
