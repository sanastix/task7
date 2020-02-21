package com.company.task7;

import java.util.Arrays;
import java.util.Random;

public class MainOne {
    /*
    Создать 2-мерный массив (матрица) M*N и заполнить его случайными числами.
    Отсортировать числа по возрастанию, чтобы с левом верхнем углу было самое маленькое число,
    справа от него следующее по значению, итд, в правом нижнем углу самое большое.
     */
    public static void main(String[] args) {

        Random random = new Random();
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(100) + 1;
            }
        }
        System.out.println(Arrays.deepToString(arr) + " ");

        int[] tmp = new int[5*5];
        int in = 0;
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                tmp[in++] = arr[a][b];
            }
        }

        Arrays.sort(tmp);

        int out = 0;
        for (int c = 0; c < 5; c++) {
            for (int d = 0; d < 5; d++) {
                arr[c][d] = tmp[out++];
            }
        }
        System.out.println(Arrays.deepToString(arr));

    }

}
