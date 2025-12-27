import java.util.ArrayList;
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

    Student(String name, String className, String section, int rollNo) 
    {
        this.name = name;
        this.className = className;
        this.section = section;
        this.rollNo = rollNo;
    }

    void calculateResult(int[] marks, int fullMarks) 
    {
        total = 0;
        for (int m : marks) 
        {
            total += m;
        }
        average = total / 6.0;
        percentage = (total * 100.0) / fullMarks;
        grade = calculateGrade();
    }

    char calculateGrade() 
    {
        if (average >= 75) 
            return 'A';
        else if (average >= 60) 
            return 'B';
        else if (average >= 40) 
            return 'C';
        else 
            return 'F';
    }

    boolean isPassed() 
    {
        return grade != 'F';
    }

    void display() 
    {
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Section: " + section);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Status: " + (isPassed() ? "PASS" : "FAIL"));
    }
}

public class StudentResultMenu 
{

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) 
    {

        while (true) 
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addStudent() 
    {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter Class: ");
        String className = sc.nextLine();

        System.out.print("Enter Section: ");
        String section = sc.nextLine();

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();

        System.out.print("Enter full marks: ");
        int fm = sc.nextInt();

        int[] marks = new int[6];
        System.out.print("Enter marks in 6 subjects: ");
        for (int i = 0; i < 6; i++) {
            marks[i] = sc.nextInt();
        }
        sc.nextLine();

        Student s = new Student(name, className, section, rollNo);
        s.calculateResult(marks, fm);
        students.add(s);

        System.out.println("Student added successfully.");
    }

    static void displayStudents() 
    {

        if (students.isEmpty()) 
        {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");
        for (Student s : students) 
        {
            System.out.println();
            s.display();
        }
    }
}

