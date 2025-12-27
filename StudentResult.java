import java.util.Scanner;

public class StudentResult 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter Class: ");
        String cl = sc.nextLine();

        System.out.print("Enter Section: ");
        String sec = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();

        System.out.print("Enter full marks: ");
        int fm = sc.nextInt();

        System.out.print("Enter marks in 6 subjects: ");
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int m5 = sc.nextInt();
        int m6 = sc.nextInt();

        int total = m1 + m2 + m3 + m4 + m5 + m6;
        double average = total / 6.0;
        double percentage = (total * 100.0) / fm;

        System.out.println("\n--- Result ---");
        System.out.println("Name: " + name);
        System.out.println("Class: " + cl);
        System.out.println("Section: " + sec);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Average: " + average);

        if (average >= 75) 
        {
            System.out.println("Your Grade is A");
            System.out.println("You have PASSED");
        } 
        else if (average >= 60) 
        {
            System.out.println("Your Grade is B");
            System.out.println("You have PASSED");
        } 
        else if (average >= 40) 
        {
            System.out.println("Your Grade is C");
            System.out.println("You have PASSED");
        } 
        else 
        {
            System.out.println("Your Grade is F");
            System.out.println("You have FAILED");
        }

        sc.close();
    }
}

