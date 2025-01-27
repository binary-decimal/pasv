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
        int start = 0;
        int end = 0;

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
            start = minPosition;
            end = maxPosition;
        } else {
            start = maxPosition;
            end = minPosition;
        }

        for (int i = start + 1; i < end; i++) {
            sum += elements[i];
        }

        System.out.println("min is " + min);
        System.out.println("max is " + max);
        System.out.println("sum is " + sum);
    }
}
