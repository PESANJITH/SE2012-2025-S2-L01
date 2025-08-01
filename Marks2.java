import java.util.Scanner;

public class Marks2 {
    static int[][] marks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        marks = new int[n + 1][4]; // Index 0 unused, subjects 1 to 3

        while (true) {
            System.out.print("\nEnter command: ");
            String command = sc.next();

            if (command.equalsIgnoreCase("add")) {
                int studentID = sc.nextInt();
                if (isValidStudent(studentID, n)) {
                    System.out.print("Enter marks for Mathematics: ");
                    marks[studentID][1] = sc.nextInt();

                    System.out.print("Enter marks for Chemistry: ");
                    marks[studentID][2] = sc.nextInt();

                    System.out.print("Enter marks for Physics: ");
                    marks[studentID][3] = sc.nextInt();

                    System.out.println("Marks added successfully!");
                }

            } else if (command.equalsIgnoreCase("update")) {
                int studentID = sc.nextInt();
                int subjectID = sc.nextInt();
                if (isValidStudent(studentID, n) && isValidSubject(subjectID)) {
                    System.out.print("Enter new mark: ");
                    marks[studentID][subjectID] = sc.nextInt();
                    System.out.println("Mark updated.");
                }

            } else if (command.equalsIgnoreCase("average_s")) {
                int subjectID = sc.nextInt();
                if (isValidSubject(subjectID)) {
                    double sum = 0;
                    int count = 0;
                    for (int i = 1; i <= n; i++) {
                        sum += marks[i][subjectID];
                        count++;
                    }
                    double average = (count > 0) ? sum / count : 0;
                    System.out.println("Average for subject " + subjectName(subjectID) + " is " + average);
                }

            } else if (command.equalsIgnoreCase("average")) {
                int studentID = sc.nextInt();
                if (isValidStudent(studentID, n)) {
                    int total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
                    System.out.println("Average for student " + studentID + " is " + (total / 3.0));
                }

            } else if (command.equalsIgnoreCase("total")) {
                int studentID = sc.nextInt();
                if (isValidStudent(studentID, n)) {
                    int total = marks[studentID][1] + marks[studentID][2] + marks[studentID][3];
                    System.out.println("Total for student " + studentID + " is " + total);
                }

            } else if (command.equalsIgnoreCase("grades")) {
                System.out.printf("\n%-10s%-12s%-12s%-12s\n", "StudentID", "Mathematics", "Chemistry", "Physics");
                for (int i = 1; i <= n; i++) {
                    String mathGrade = getGrade(marks[i][1]);
                    String chemGrade = getGrade(marks[i][2]);
                    String phyGrade = getGrade(marks[i][3]);
                    System.out.printf("%-10d%-12s%-12s%-12s\n", i, mathGrade, chemGrade, phyGrade);
                }

            } else {
                System.out.println("Invalid command.");
            }
        }
    }

    static boolean isValidStudent(int id, int n) {
        if (id < 1 || id > n) {
            System.out.println("Invalid student ID. Must be between 1 and " + n);
            return false;
        }
        return true;
    }

    static boolean isValidSubject(int id) {
        if (id < 1 || id > 3) {
            System.out.println("Invalid subject ID. Must be 1 (Math), 2 (Chem), 3 (Physics)");
            return false;
        }
        return true;
    }

    static String subjectName(int id) {
        return switch (id) {
            case 1 -> "Mathematics";
            case 2 -> "Chemistry";
            case 3 -> "Physics";
            default -> "Unknown";
        };
    }

    static String getGrade(int mark) {
        if (mark >= 90) return "Grade A";
        else if (mark >= 80) return "Grade B";
        else if (mark >= 70) return "Grade C";
        else if (mark >= 60) return "Grade D";
        else return "Fail";
    }
}
