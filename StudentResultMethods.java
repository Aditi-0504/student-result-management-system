import java.util.Scanner;

public class StudentResultMethods 
{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        String[] classes = new String[n];
        String[] sections = new String[n];
        int[] rollNos = new int[n];
        int[] totals = new int[n];
        double[] averages = new double[n];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        inputStudentData(n, names, classes, sections, rollNos, totals, averages, percentages, grades);
        displayAllResults(n, names, classes, sections, rollNos, totals, averages, percentages, grades);

        sc.close();
    }


    static void inputStudentData(
            int n,
            String[] names,
            String[] classes,
            String[] sections,
            int[] rollNos,
            int[] totals,
            double[] averages,
            double[] percentages,
            char[] grades) 
            {

            for (int i = 0; i < n; i++) 
            {

                System.out.println("\nEnter details for Student " + (i + 1));

                System.out.print("Enter name: ");
                names[i] = sc.nextLine();

                System.out.print("Enter Class: ");
                classes[i] = sc.nextLine();

                System.out.print("Enter Section: ");
                sections[i] = sc.nextLine();

                System.out.print("Enter roll number: ");
                rollNos[i] = sc.nextInt();

                System.out.print("Enter full marks: ");
                int fm = sc.nextInt();

                System.out.print("Enter marks in 6 subjects: ");
                int m1 = sc.nextInt();
                int m2 = sc.nextInt();
                int m3 = sc.nextInt();
                int m4 = sc.nextInt();
                int m5 = sc.nextInt();
                int m6 = sc.nextInt();

                totals[i] = calculateTotal(m1, m2, m3, m4, m5, m6);
                averages[i] = calculateAverage(totals[i]);
                percentages[i] = calculatePercentage(totals[i], fm);
                grades[i] = calculateGrade(averages[i]);

                sc.nextLine();
            }
    }

    static int calculateTotal(int a, int b, int c, int d, int e, int f) 
    {
        return a + b + c + d + e + f;
    }

    static double calculateAverage(int total) 
    {
        return total / 6.0;
    }

    static double calculatePercentage(int total, int fm) 
    {
        return (total * 100.0) / fm;
    }

    static char calculateGrade(double average) 
    {
        if (average >= 75) return 'A';
        else if (average >= 60) return 'B';
        else if (average >= 40) return 'C';
        else return 'F';
    }

    static void displayAllResults(
            int n,
            String[] names,
            String[] classes,
            String[] sections,
            int[] rollNos,
            int[] totals,
            double[] averages,
            double[] percentages,
            char[] grades) 
            {

                System.out.println("\n===== STUDENT RESULTS =====");

                for (int i = 0; i < n; i++) 
                {

                    System.out.println("\n--- Student " + (i + 1) + " ---");
                    System.out.println("Name: " + names[i]);
                    System.out.println("Class: " + classes[i]);
                    System.out.println("Section: " + sections[i]);
                    System.out.println("Roll No: " + rollNos[i]);
                    System.out.println("Total Marks: " + totals[i]);
                    System.out.println("Percentage: " + percentages[i] + "%");
                    System.out.println("Average: " + averages[i]);
                    System.out.println("Grade: " + grades[i]);

                    if (grades[i] == 'F')
                        System.out.println("Status: FAIL");
                    else
                        System.out.println("Status: PASS");
                }
            }
}

