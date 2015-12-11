package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> listOfFoundWords = detectAllWords(crossword, "home", "same");
        for (Word word : listOfFoundWords)
        {
            System.out.println(word.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        //список для результата
        List<Word> listOfFoundWords = new ArrayList<>();
        //берем слово
        for (String word : words)
        {
            //начинаем искать по горизонтали вперед
            for (int i = 0; i < crossword.length; i++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int y = 0; y < crossword[0].length; y++)
                {
                    //если совпала буква
                    if (crossword[i][y] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = y;
                            wordStartY = i;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = y;
                            wordEndY = i;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[i][y] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                }
            }
            //начинаем искать по горизонтали назад
            for (int i = 0; i < crossword.length; i++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int y = crossword[0].length - 1; y >= 0; y--)
                {
                    //если совпала буква
                    if (crossword[i][y] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = y;
                            wordStartY = i;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = y;
                            wordEndY = i;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[i][y] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                }
            }
            //начинаем искать по вертикали вниз
            for (int y = 0; y < crossword[0].length; y++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int i = 0; i < crossword.length; i++)
                {
                    //если совпала буква
                    if (crossword[i][y] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = y;
                            wordStartY = i;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = y;
                            wordEndY = i;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[i][y] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                }
            }
            //начинаем искать по вертикали вверх
            for (int y = 0; y < crossword[0].length; y++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int i = crossword.length - 1; i >= 0; i--)
                {
                    //если совпала буква
                    if (crossword[i][y] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = y;
                            wordStartY = i;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = y;
                            wordEndY = i;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[i][y] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                }
            }
            /*начинаем искать по диагонали вправо вниз для
            +-----
            ++----
            +++---
            ++++--
            +++++-
            ++++++
            */
            for (int i = 0; i < crossword.length; i++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int k = i, l = 0; k < crossword.length && l < crossword[0].length; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k++;
                    l++;
                }
            }
            /*начинаем искать по диагонали вправо вниз для
            -+++++
            --++++
            ---+++
            ----++
            -----+
            ------
            */
            for (int y = 1; y < crossword[0].length; y++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for (int k = 0, l = y; k < crossword.length && l < crossword[0].length; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k++;
                    l++;
                }
            }
            /*начинаем искать по диагонали вправо вверх для
            ++++++
            +++++-
            ++++--
            +++---
            ++----
            +-----
            */
            for(int i = crossword.length-1; i  >=0; i--)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = i, l = 0; k >= 0 && l <crossword[0].length; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k--;
                    l++;
                }
            }
            /*начинаем искать по диагонали вправо вверх для
            ------
            -----+
            ----++
            ---+++
            --++++
            -+++++
            */
            for(int y = 1; y < crossword[0].length;y++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = crossword.length-1, l = y; k >= 0 && l <crossword[0].length; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k--;
                    l++;
                }
            }
            /*начинаем искать по диагонали влево вниз для
            -----+
            ----++
            ---+++
            --++++
            -+++++
            ++++++
            */
            for(int i = 0; i <crossword.length; i++)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = i, l = crossword[0].length-1; k < crossword.length && l >= 0; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k++;
                    l--;
                }
            }
            /*начинаем искать по диагонали влево вниз для
            +++++-
            ++++--
            +++---
            ++----
            +-----
            ------
            */
            for(int y = crossword[0].length-2; y >= 0 ; y--)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = 0, l = y; k < crossword.length && l >=0; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k++;
                    l--;
                }
            }
            /*начинаем искать по диагонали влево вверх для
            ++++++
            -+++++
            --++++
            ---+++
            ----++
            -----+
            */
            for(int i = crossword.length-1; i >= 0; i--)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = i, l = crossword[0].length-1; k >= 0 && l >= 0; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k--;
                    l--;
                }
            }
                        /*начинаем искать по диагонали влево вверх для
            ------
            +-----
            ++----
            +++---
            ++++--
            +++++-
            */
            for(int y = crossword[0].length-2; y >= 0 ; y--)
            {
                int wordLetterCounter = 0;
                int wordStartX = -1;
                int wordStartY = -1;
                int wordEndX;
                int wordEndY;
                for(int k = crossword.length-1, l = y; k >= 0 && l >=0; )
                {
                    //если совпала буква
                    if (crossword[k][l] == word.charAt(wordLetterCounter))
                    {
                        //дальше будем смотреть следующую букву в слове
                        wordLetterCounter++;
                        //если это первая совпавшая буква
                        if (wordStartX == -1 && wordStartY == -1)
                        {
                            wordStartX = l;
                            wordStartY = k;
                        }
                        //если нашли слово
                        if (wordLetterCounter == word.length())
                        {
                            wordEndX = l;
                            wordEndY = k;
                            Word foundWord = new Word(word);
                            foundWord.setStartPoint(wordStartX, wordStartY);
                            foundWord.setEndPoint(wordEndX, wordEndY);
                            listOfFoundWords.add(foundWord);
                            //сбрасываем счетчики
                            wordLetterCounter = 0;
                            wordStartX = -1;
                            wordStartY = -1;
                        }
                    }
                    //если буква не совпала
                    else if (crossword[k][l] != word.charAt(wordLetterCounter))
                    {
                        wordLetterCounter = 0;
                        wordStartX = -1;
                        wordStartY = -1;
                    }
                    k--;
                    l--;
                }
            }
        }

        return listOfFoundWords;
    }

    public static class Word
    {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text)
        {
            this.text = text;
        }

        public void setStartPoint(int i, int j)
        {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j)
        {
            endX = i;
            endY = j;
        }

        @Override
        public String toString()
        {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
