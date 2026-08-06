import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-5d %-15s %-6.2f", id, name, age, course, marks);
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();
    private int nextId = 1;

    public Student addStudent(String name, int age, String course, double marks) {
        Student s = new Student(nextId++, name, age, course, marks);
        students.add(s);
        return s;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean updateStudent(int id, String name, int age, String course, double marks) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        if (name != null && !name.isEmpty()) {
            s.setName(name);
        }
        if (age >= 0) {
            s.setAge(age);
        }
        if (course != null && !course.isEmpty()) {
            s.setCourse(course);
        }
        if (marks >= 0) {
            s.setMarks(marks);
        }
        return true;
    }

    public boolean deleteStudent(int id) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        students.remove(s);
        return true;
    }

    public double getAverageMarks() {
        if (students.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Student s : students) {
            total += s.getMarks();
        }
        return total / students.size();
    }

    public Student getTopStudent() {
        if (students.isEmpty()) {
            return null;
        }
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getMarks() > top.getMarks()) {
                top = s;
            }
        }
        return top;
    }

    public int getCount() {
        return students.size();
    }
}

public class StudentManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
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
                    showStatistics();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Statistics");
        System.out.println("7. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age = readInt("Enter age: ");
        System.out.print("Enter course: ");
        String course = scanner.nextLine();
        double marks = readDouble("Enter marks: ");
        Student s = manager.addStudent(name, age, course, marks);
        System.out.println("Student added with ID: " + s.getId());
    }

    private static void viewAllStudents() {
        List<Student> students = manager.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        printHeader();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void searchStudent() {
        System.out.println("Search by 1. ID  2. Name");
        int option = readInt("Enter option: ");
        if (option == 1) {
            int id = readInt("Enter ID: ");
            Student s = manager.findById(id);
            if (s == null) {
                System.out.println("Student not found.");
            } else {
                printHeader();
                System.out.println(s);
            }
        } else if (option == 2) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            List<Student> results = manager.findByName(name);
            if (results.isEmpty()) {
                System.out.println("No students found.");
            } else {
                printHeader();
                for (Student s : results) {
                    System.out.println(s);
                }
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private static void updateStudent() {
        int id = readInt("Enter ID of student to update: ");
        Student existing = manager.findById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name (leave blank to keep unchanged): ");
        String name = scanner.nextLine();
        int age = readInt("Enter new age (-1 to keep unchanged): ");
        System.out.print("Enter new course (leave blank to keep unchanged): ");
        String course = scanner.nextLine();
        double marks = readDouble("Enter new marks (-1 to keep unchanged): ");
        boolean updated = manager.updateStudent(id, name, age, course, marks);
        System.out.println(updated ? "Student updated." : "Update failed.");
    }

    private static void deleteStudent() {
        int id = readInt("Enter ID of student to delete: ");
        boolean deleted = manager.deleteStudent(id);
        System.out.println(deleted ? "Student deleted." : "Student not found.");
    }

    private static void showStatistics() {
        System.out.println("Total students: " + manager.getCount());
        System.out.printf("Average marks: %.2f%n", manager.getAverageMarks());
        Student top = manager.getTopStudent();
        if (top != null) {
            System.out.println("Top student: " + top.getName() + " (" + top.getMarks() + ")");
        }
    }

    private static void printHeader() {
        System.out.printf("%-5s %-15s %-5s %-15s %-6s%n", "ID", "Name", "Age", "Course", "Marks");
        System.out.println("---------------------------------------------------");
    }

    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static double readDouble(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}