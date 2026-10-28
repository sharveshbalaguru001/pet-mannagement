import java.util.ArrayList;
import java.util.Scanner;

// Class representing a Student Entity
class pet {
    private String id;
    private String name;
    private int age;
    private String course;

    public Student(String id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course;
    }
}

// Main Management System Class
public class StudentManagementSystem {
    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Information");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose an option between 1 and 5.");
            }
        }
    }

    // 1. CREATE: Add a new student record
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        
        // Validation to ensure uniqueness of ID
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.println("Error: A student with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a valid integer for Age: ");
            scanner.next();
        }
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Student Course: ");
        String course = scanner.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("Student profile added successfully!");
    }

    // 2. READ: View all active student records
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- Student Database Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // 3. UPDATE: Modify an existing record matching an ID
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                System.out.print("Enter New Name (leave blank to keep original): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) s.setName(newName);

                System.out.print("Enter New Age (or enter 0 to keep original): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid input. Enter an integer: ");
                    scanner.next();
                }
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (newAge > 0) s.setAge(newAge);

                System.out.print("Enter New Course (leave blank to keep original): ");
                String newCourse = scanner.nextLine();
                if (!newCourse.trim().isEmpty()) s.setCourse(newCourse);

                System.out.println("Student record updated successfully!");
                return;
            }
        }
        System.out.println("Student record with ID " + id + " not found.");
    }

    // 4. DELETE: Remove a record from the collection
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                studentList.remove(i);
                System.out.println("Student record removed successfully.");
                return;
            }
        }
        System.out.println("Student record with ID " + id + " not found.");
    }
}
Use code with caution.
Features Built into This Code:
• In-Memory Collection: Uses ArrayList to dynamically handle records without needing an external database.
• Input Protection: Checks for proper integer types (like age and menu selections) to prevent code crashes.
• Uniqueness Validation: Restricts duplicate entry generations for Student IDs.
If you would like to expand this project further, let me know if you need to add a database connection (MySQL), build a Graphical User Interface (Swing UI), or handle a different industry type like an Inventory or Library Management System.
• 
GitHub
GitHub - Ajaysinh1290/College-Management-System-In-Java: College Management system in java with MySQL · GitHub
Technologies: Java Swing, MySQL (database 'collegedata'). Features: Course, subject, student, and faculty management; attendance a...
• 
Medium
Java Project — Student Management
Get Prakash Karuppusamy's stories in your inbox Join Medium for free to get updates from this writer. Code Link:https://github.com...
• 
GeeksforGeeks
CRUD Operations in Student Management System in Java
A. File: StudentRecordLinkedList.java out. println("9: Exit program"); System. out. print("Enter your selection : "); } } B. File:
Show all
                