package Cone;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BruteForce {

    static int[][] input;
    static List<int[][]> endResults = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input = getInput();
        visualise(input);
        System.out.println("==========================");
        f(null);
    }

    static void f(Stack stack) {
        if (stack == null ) {
            stack = new Stack<>();
        }
        for (int i = 0; i < 12; i++) {
            if (stack.contains(i)) {
                if(stack.size() == 12){
                    List<Integer> list = new ArrayList<>(stack);
                    int[][] ints = new int[12][4];
                    for (int j = 0; j < 12; j++ ){
                        ints[j] = input[list.get(j)];
                    }
                    if (check(ints)) {
                        visualise(ints);
                    }
                    break;
                }
            } else {
                stack.push(i);
                f(stack);
                stack.pop();
            }

        }
    }

    private static boolean check (int[][] squares) {
        if (squares[3][3] + squares[4][2] + squares[7][1] + squares[8][0] != 10) {
            return false;
        }
/*        if (squares[0] == null || squares[1] == null || squares[3] == null || squares[4] == null){
            return false;
        }*/
        if (squares[0][3] + squares[1][2] + squares[3][1] + squares[4][0] != 10) {
            return false;
        }
        if (squares[0][1] + squares[1][0] > 10){
            return false;
        }
/*        if (squares[4] == null || squares[5] == null || squares[8] == null || squares[9] == null){
            return false;
        }*/
        if (squares[4][3] + squares[5][2] + squares[8][1] + squares[9][0] != 10) {
            return false;
        }
        if (squares[1][3] + squares[4][1] + squares[5][0] > 10) {
            return false;
        }
        if (squares[5][3] + squares[9][1] > 10){
            return false;
        }
/*        if (squares[7] == null || squares[8] == null || squares[10] == null || squares[11] == null){
            return false;
        }*/
        if (squares[7][3] + squares[8][2] + squares[10][1] + squares[11][0] != 10) {
            return false;
        }
        if (squares[8][3] + squares[9][2] + squares[11][1] > 10) {
            return false;
        }
        if (squares[10][3] + squares[11][2] > 10){
            return false;
        }
/*        if (squares[2] == null || squares[3] == null || squares[6] == null || squares[7] == null){
            return false;
        }*/
        if (squares[2][3] + squares[3][2] + squares[6][1] + squares[7][0] != 10) {
            return false;
        }
        if (squares[6][3] + squares[7][2] + squares[10][0] > 10) {
            return false;
        }
        if (squares[2][2] + squares[6][0] > 10){
            return false;
        }
        if (squares[0][2] + squares[2][1] + squares[3][0] > 10) {
            return false;
        }
        return true;
    }



    private static int[][] getInput() throws IOException {
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("C:/input.txt"));
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

    private static void visualise(int[][] ints) {
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

    }

/*    private static List<int[]> getTens() {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++){
                if (j == i)
                    continue;
                for (int k = 0; k < 12; k++){
                    if (k == j || k == i)
                        continue;
                    for (int h = 0; h < 12; h++){
                        if (h == k || h == j || h == i)
                            continue;
                        if (input[i][3] + input[j][2] + input[k][1] + input[h][0] == 10){
                            int[] combination = new int[4];
                            combination[0] = i;
                            combination[1] = j;
                            combination[2] = k;
                            combination[3] = h;
                            result.add(combination);
                        }
                    }
                }
            }
        }
        return result;
    }*/

    /*    private static List<int[]> clearTens(List<int[]> tens) {
        for (Iterator<int[]> iterator = tens.iterator(); iterator.hasNext(); ) {
            int[] ints = iterator.next();

            int[] first = input[ints[0]];
            int[] second = input[ints[1]];
            int[] third = input[ints[2]];
            int[] fourth = input[ints[3]];
        }
        return null;
    }*/

/*    private static void visualiseTens(List<int[]> tens) {
        for (int[] ints : tens){
            System.out.print(Arrays.toString(input[ints[0]]));
            System.out.println(" - " + (ints[0] + 1));
            System.out.print(Arrays.toString(input[ints[1]]));
            System.out.println(" - " + (ints[1] + 1));
            System.out.print(Arrays.toString(input[ints[2]]));
            System.out.println(" - " + (ints[2] + 1));
            System.out.print(Arrays.toString(input[ints[3]]));
            System.out.println(" - " + (ints[3] + 1));
            System.out.println("=============");
        }
    }*/
}
