import java.util.ArrayList;
import java.util.Scanner;

class Student {

    int id;
    String name;
    int age;
    String course;
    double cgpa;

    Student(int id, String name, int age, String course, double cgpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.cgpa = cgpa;
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        for (Student student : students){
            if (student.id == id){
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Student CGPA");
        double cgpa = sc.nextDouble();

        Student student = new Student(id, name, age, course, cgpa);

        students.add(student);

        System.out.println("Student added successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== STUDENT DETAILS =====");

        for (Student student : students) {

            System.out.println("ID: " + student.id);
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Course: " + student.course);
            System.out.println("CGPA: " + student.cgpa);
            System.out.println("----------------------------");
        }
    }

    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.id == id) {

                System.out.println("\nStudent found!");
                System.out.println("ID: " + student.id);
                System.out.println("Name: " + student.name);
                System.out.println("Age: " + student.age);
                System.out.println("Course: " + student.course);
                System.out.println("CGPA: " + student.cgpa);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        for (Student student : students) {

            if (student.id == id) {

                sc.nextLine();

                System.out.print("Enter new name: ");
                student.name = sc.nextLine();

                System.out.print("Enter new age: ");
                student.age = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter new course: ");
                student.course = sc.nextLine();

                System.out.println("Enter New CGPA: ");
                student.cgpa = sc.nextDouble();

                System.out.println("Student updated successfully!");

                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).id == id) {

                students.remove(i);

                System.out.println("Student deleted successfully!");

                return;
            }
        }

        System.out.println("Student not found.");
    }
}