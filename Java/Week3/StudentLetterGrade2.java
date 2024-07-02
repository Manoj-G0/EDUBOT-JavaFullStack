import java.util.Scanner;

public class StudentLetterGrade2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's grade: ");
        int grade = scanner.nextInt();

        String letterGrade;

        switch (grade / 10) {
            case 10:
                letterGrade = "A+";
                break;
            case 9:
                letterGrade = "A";
                break;
            case 8:
                letterGrade = "B";
                break;
            case 7:
                letterGrade = "C";
                break;
            case 6:
                letterGrade = "D";
                break;
            default:
                letterGrade = "F";
                break;
        }

        System.out.println("The student's letter grade is: " + letterGrade);
        scanner.close();
    }
}
