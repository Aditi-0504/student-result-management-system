import java.util.Scanner;

class Student 
{

    String name;
    String className;
    String section;
    int rollNo;
    int total;
    double average;
    double percentage;
    char grade;

    void calculateResult(int m1, int m2, int m3, int m4, int m5, int m6, int fullMarks) 
    {
        total = m1 + m2 + m3 + m4 + m5 + m6;
        average = total / 6.0;
        percentage = (total * 100.0) / fullMarks;
        grade = calculateGrade();
    }

    char calculateGrade() 
    {
        if (average >= 75) return 'A';
        else if (average >= 60) return 'B';
        else if (average >= 40) return 'C';
        else return 'F';
    }

    void display() 
    {
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Section: " + section);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + (grade == 'F' ? "FAIL" : "PASS"));
    }
}

public class StudentResultOOP 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) 
        {

            students[i] = new Student();

            System.out.println("\nEnter details for Student " + (i + 1));

            System.out.print("Enter name: ");
            students[i].name = sc.nextLine();

            System.out.print("Enter Class: ");
            students[i].className = sc.nextLine();

            System.out.print("Enter Section: ");
            students[i].section = sc.nextLine();

            System.out.print("Enter roll number: ");
            students[i].rollNo = sc.nextInt();

            System.out.print("Enter full marks: ");
            int fm = sc.nextInt();

            System.out.print("Enter marks in 6 subjects: ");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            int m4 = sc.nextInt();
            int m5 = sc.nextInt();
            int m6 = sc.nextInt();

            students[i].calculateResult(m1, m2, m3, m4, m5, m6, fm);

            sc.nextLine();
        }

        System.out.println("\n===== STUDENT RESULTS =====");

        for (int i = 0; i < n; i++) 
        {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            students[i].display();
        }

        sc.close();
    }
}

