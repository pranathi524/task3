import java.util.ArrayList;
import java.util.Scanner;
public class StudentGrade{
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        String[] studentNames = new String[numStudents];
        ArrayList<ArrayList<Double>> studentScores = new ArrayList<>();
        for(int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            ArrayList<Double> scores = new ArrayList<>();
            System.out.print("Enter the number of scores for " + studentNames[i] + ": ");
            int numGrades = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < numGrades; j++) {
                while (true) {
                    System.out.print("Enter scores " + (j + 1) + ": ");
                    String input = scanner.nextLine();
                    try {
                        double score = Double.parseDouble(input);
                        scores.add(score);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                    }
                }
            }
            studentScores.add(scores);
        }
        for (int i = 0; i < numStudents; i++) {
            ArrayList<Double> scores = studentScores.get(i);
            if (scores.size() > 0) {
                System.out.println("\nResults for " + studentNames[i] + ":");
                System.out.println("Highest score = " + max(scores));
                System.out.println("Lowest score = " + min(scores));
                System.out.println("Mean = " + mean(scores) + " Grade: " + gradeLetter(mean(scores)));
                System.out.println("-------------------------------------");
            } else {
                System.out.println("No scores entered for " + studentNames[i] + ".");
            }
        }
		scanner.close();
    }
	public static double max(ArrayList<Double> numbers) {
        double result = numbers.get(0);
        for (double number : numbers) {
            if (number > result) {
                result = number;
            }
        }
        return result;
    }
	public static double min(ArrayList<Double> numbers) {
        double result = numbers.get(0);
        for (double number : numbers) {
            if (number < result) {
                result = number;
            }
        }
        return result;
    }
	public static double mean(ArrayList<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }
	public static char gradeLetter(double mean) {
        if (mean >= 90) {
            return 'A';
        } else if (mean >= 80) {
            return 'B';
        } else if (mean >= 70) {
            return 'C';
        } else if (mean >= 65) {
            return 'D';
        } else {
            return 'F';
        }
    }
}