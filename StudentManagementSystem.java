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
        if (average >= 75) return 'A';
        else if (average >= 60) return 'B';
        else if (average >= 40) return 'C';
        else return 'F';
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

public class StudentManagementSystem 
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
            System.out.println("3. Search Student");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Summary");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudentMarks();
                case 5 -> deleteStudent();
                case 6 -> showSummary();
                case 7 -> {
                    System.out.println("Program terminated.");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }


    static void addStudent() 
    {

        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        if (findStudentByRoll(rollNo) != null) 
        {
            System.out.println("Student with this roll number already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter Class: ");
        String className = sc.nextLine();

        System.out.print("Enter Section: ");
        String section = sc.nextLine();

        System.out.print("Enter full marks: ");
        int fm = sc.nextInt();

        int[] marks = new int[6];
        System.out.print("Enter marks in 6 subjects: ");

        for (int i = 0; i < 6; i++) 
        {
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
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) 
        {
            System.out.println();
            s.display();
        }
    }

    static void searchStudent() 
    {

        System.out.print("Enter roll number to search: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = findStudentByRoll(rollNo);

        if (s == null) 
        {
            System.out.println("Student not found.");
        } 
        else 
        {
            s.display();
        }
    }

    static void updateStudentMarks() 
    {

        System.out.print("Enter roll number to update: ");
        int rollNo = sc.nextInt();

        Student s = findStudentByRoll(rollNo);

        if (s == null) 
        {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter full marks: ");
        int fm = sc.nextInt();

        int[] marks = new int[6];
        System.out.print("Enter new marks in 6 subjects: ");

        for (int i = 0; i < 6; i++) 
        {
            marks[i] = sc.nextInt();
        }
        sc.nextLine();

        s.calculateResult(marks, fm);
        System.out.println("Marks updated successfully.");
    }

    static void deleteStudent() 
    {

        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student s = findStudentByRoll(rollNo);

        if (s == null) 
        {
            System.out.println("Student not found.");
            return;
        }

        students.remove(s);
        System.out.println("Student deleted successfully.");
    }

    static void showSummary() 
    {

        if (students.isEmpty()) 
        {
            System.out.println("No data to summarize.");
            return;
        }

        int pass = 0, fail = 0;
        double totalPercentage = 0;

        for (Student s : students) 
        {
            totalPercentage += s.percentage;
            if (s.isPassed()) pass++;
            else fail++;
        }

        System.out.println("\n===== SUMMARY =====");
        System.out.println("Total Students: " + students.size());
        System.out.println("Passed: " + pass);
        System.out.println("Failed: " + fail);
        System.out.println("Class Average Percentage: " +
                (totalPercentage / students.size()));
    }


    static Student findStudentByRoll(int rollNo)
    {
        for (Student s : students) 
        {
            if (s.rollNo == rollNo) 
            {
                return s;
            }
        }
        return null;
    }
}
