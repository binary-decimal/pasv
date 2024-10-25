package lesson7;

import java.util.Random;

//Создать последовательность случайных чисел, найти и вывести наибольшее из них

public class Task13MaxRandomNbr {
    public static void main(String[] args) {
        Random randomInt = new Random();
        int[] randomIntArray = new int[10];
        int maxNbr = 0;

        for(int i = 0; i < randomIntArray.length; i++) {
            randomIntArray[i] = randomInt.nextInt(10);
            System.out.println(randomIntArray[i]);
        }

        for(int i: randomIntArray) {
            if (maxNbr < i) {
                maxNbr = i;
            }
        }

        System.out.println("max nbr is " + maxNbr);
    }
}
