package lesson7;

//       [[11111], [01110], [00100], [01110], [11111]]

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = new int[5][5];
        int number;

        for(int i = 0; i < twoDimensionalArray.length; i++) {

            twoDimensionalArray[2][2] = 1;

            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if (i == 0 || i == twoDimensionalArray.length - 1) {
                    number = 1;
                } else if ((i == 1 || i == twoDimensionalArray.length - 2) && !(j == 0 || j == 4) ) {
                    number = 1;
                } else {
                    number = 0;
                }
                twoDimensionalArray[i][j] = number;
            }
        }

        for (int[] row: twoDimensionalArray) {
            for (int column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
}