import java.util.Scanner;

public class Marks {
    static int[][] marks;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        marks = new int[n + 1][4]; // 1-based index; subjects: 1 to 3

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
                    System.out.println("Average for subject " + subjectID + " is " + average);
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
}
