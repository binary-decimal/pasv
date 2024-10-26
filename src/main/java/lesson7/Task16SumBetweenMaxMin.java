package lesson7;

//Определите сумму элементов одномерного массива, расположенных между
//минимальным и максимальным значениями.

public class Task16SumBetweenMaxMin {
    public static void main(String[] args) {
        int[] elements = { 2, 5, 3, 4, 2, 2, 1 };

        int min = elements[0];
        int max = elements[0];
        int minPosition = 0;
        int maxPosition = 0;
        int sum = 0;

        for (int i: elements) {
            System.out.println(i);
        }

        for (int i = 1; i < elements.length; i++) {
            if (min > elements[i]) {
                min = elements[i];
                minPosition = i;
            }
            if (max < elements[i]) {
                max = elements[i];
                maxPosition = i;
            }
        }

        if (minPosition < maxPosition) {
            for (int i = minPosition + 1; i < maxPosition; i++) {
                sum = sum + elements[i];
            }
        } else {
            for (int i = maxPosition + 1; i < minPosition; i++) {
                sum = sum + elements[i];
            }
        }

        System.out.println("min is " + min);
        System.out.println("max is " + max);
        System.out.println("sum is " + sum);
    }
}
