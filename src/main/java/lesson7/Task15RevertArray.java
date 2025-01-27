package lesson7;

// Создать массив, заполнить его случайными элементами, распечатать,
//перевернуть, и снова распечатать (при переворачивании нежелательно создавать
//еще один массив).

public class Task15RevertArray {
    public static void main(String[] args) {
        int[] lol = {1, 2, 3, 4, 5};
        int temp;

        for (int i : lol) {
            System.out.print(i);
        }

        System.out.println();

        for (int i = 0; i < lol.length; i++) {
            for (int j = i; j < lol.length; j++) {
                temp = lol[j];
                lol[j] = lol[lol.length - 1];
                lol[lol.length - 1] = temp;
            }
        }

        for (int i : lol) {
            System.out.print(i);
        }
    }
}