package lesson7;

// Создать массив оценок произвольной длины, вывести максимальную и минимальную оценку, её (их) номера
public class Task14MaxMinGrade {
    public static void main(String[] args) {
        double[] googleReviewGrades = { 4.3, 5.7, 6.8, 5.2, 3.5 };

        double minGrade = googleReviewGrades[0];
        double maxGrade = googleReviewGrades[0];
        int minGradePosition = 0;
        int maxGradePosition = 0;

        for (double i: googleReviewGrades) {
            System.out.println(i);
        }

        for (int i = 1; i < googleReviewGrades.length; i++) {
            if (minGrade > googleReviewGrades[i]) {
                minGrade = googleReviewGrades[i];
                minGradePosition = i;
            }
            if (maxGrade < googleReviewGrades[i]) {
                maxGrade = googleReviewGrades[i];
                maxGradePosition = i;
            }
        }

        System.out.println("min grade is " + minGrade + " his position is " + minGradePosition);
        System.out.println("max grade is " + maxGrade + " his position is " + maxGradePosition);
    }
}
