package MyTests;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by r4geee on 13.07.2014.
 */
public class MatrixDiagonal
{
    public static void main(String[] args) throws IOException
    {
        //rightDown();
        //rightUp();
        //leftDown();
        leftUp();
    }

    public static void rightDown()
    {
        int[][] crossword = new int[][]{
                {'a', 'f', 'k', 'o', 's', 'u'},
                {'v', 'b', 'g', 'l', 'p', 't'},
                {'1', 'x', 'c', 'h', 'm', 'r'},
                {'4', '2', 'y', 'd', 'i', 'n'},
                {'6', '5', '3', 'z', 'e', 'j'}
        };
        for(int i = 0; i <crossword.length; i++)
        {
            for(int k = i, l = 0; k < crossword.length && l <crossword[0].length; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k++;
                l++;
            }
        }
        for(int y = 1; y < crossword[0].length;y++)
        {
            for(int k = 0, l = y; k < crossword.length && l <crossword[0].length; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k++;
                l++;
            }
        }
    }

    public static void rightUp()
    {
        int[][] crossword = new int[][]{
                {'a', 'f', 'k', 'o', 's', 'u'},
                {'v', 'b', 'g', 'l', 'p', 't'},
                {'1', 'x', 'c', 'h', 'm', 'r'},
                {'4', '2', 'y', 'd', 'i', 'n'},
                {'6', '5', '3', 'z', 'e', 'j'}
        };
        for(int i = crossword.length-1; i  >=0; i--)
        {
            for(int k = i, l = 0; k >= 0 && l <crossword[0].length; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k--;
                l++;
            }
        }
        for(int y = 1; y < crossword[0].length;y++)
        {
            for(int k = crossword.length-1, l = y; k >= 0 && l <crossword[0].length; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k--;
                l++;
            }
        }
    }

    public static void leftDown()
    {
        int[][] crossword = new int[][]{
                {'a', 'f', 'k', 'o', 's', 'u'},
                {'v', 'b', 'g', 'l', 'p', 't'},
                {'1', 'x', 'c', 'h', 'm', 'r'},
                {'4', '2', 'y', 'd', 'i', 'n'},
                {'6', '5', '3', 'z', 'e', 'j'}
        };
        for(int i = 0; i <crossword.length; i++)
        {
            for(int k = i, l = crossword[0].length-1; k < crossword.length && l >= 0; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k++;
                l--;
            }
        }
        for(int y = crossword[0].length-2; y >= 0 ; y--)
        {
            for(int k = 0, l = y; k < crossword.length && l >=0; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k++;
                l--;
            }
        }
    }

    public static void leftUp()
    {
        int[][] crossword = new int[][]{
                {'a', 'f', 'k', 'o', 's', 'u'},
                {'v', 'b', 'g', 'l', 'p', 't'},
                {'1', 'x', 'c', 'h', 'm', 'r'},
                {'4', '2', 'y', 'd', 'i', 'n'},
                {'6', '5', '3', 'z', 'e', 'j'}
        };
        for(int i = crossword.length-1; i >= 0; i--)
        {
            for(int k = i, l = crossword[0].length-1; k >= 0 && l >= 0; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k--;
                l--;
            }
        }
        for(int y = crossword[0].length-2; y >= 0 ; y--)
        {
            for(int k = crossword.length-1, l = y; k >= 0 && l >=0; )
            {
                char c = (char)crossword[k][l];
                System.out.println(c);
                k--;
                l--;
            }
        }
    }


}


