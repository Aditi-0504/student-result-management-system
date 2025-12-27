import java.util.Scanner;

public class StudentResultArray 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        String[] names = new String[n];
        String[] classes = new String[n];
        String[] sections = new String[n];
        int[] rollNos = new int[n];
        int[] totals = new int[n];
        double[] averages = new double[n];
        double[] percentages = new double[n];

        for (int i = 0; i < n; i++) 
        {

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter student name: ");
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

            totals[i] = m1 + m2 + m3 + m4 + m5 + m6;
            averages[i] = totals[i] / 6.0;
            percentages[i] = (totals[i] * 100.0) / fm;

            sc.nextLine(); // clear buffer
        }

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

            if (averages[i] >= 75) 
            {
                System.out.println("Grade: A");
                System.out.println("Status: PASS");
            } 
            else if (averages[i] >= 60) 
            {
                System.out.println("Grade: B");
                System.out.println("Status: PASS");
            } 
            else if (averages[i] >= 40) 
            {
                System.out.println("Grade: C");
                System.out.println("Status: PASS");
            } 
            else 
            {
                System.out.println("Grade: F");
                System.out.println("Status: FAIL");
            }
        }

        sc.close();
    }
}
