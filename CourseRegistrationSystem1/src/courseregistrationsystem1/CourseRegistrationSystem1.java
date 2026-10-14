
package courseregistrationsystem1;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Course> courses = new ArrayList<>();
        
        System.out.println("=== COURSE SETUP ===");
        int numberOfCourses = 0;
        while (numberOfCourses < 3) {
            System.out.print("How many courses would you like to create? (At least 3): ");
            if (scanner.hasNextInt()) {
                numberOfCourses = scanner.nextInt();
                if (numberOfCourses < 3) {
                    System.out.println("You must create at least 3 courses!");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
        }
        scanner.nextLine(); 

        for (int i = 1; i <= numberOfCourses; i++) {
            System.out.println("\nEntering details for Course #" + i);
            System.out.print("Course Name: ");
            String cName = scanner.nextLine().trim();

            int cap = 0;
            while (cap <= 0) {
                System.out.print("Classroom Capacity: ");
                if (scanner.hasNextInt()) {
                    cap = scanner.nextInt();
                    if (cap <= 0) {
                        System.out.println("Capacity must be greater than 0.");
                    }
                } else {
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            courses.add(new Course(cName, cap));
        }

       
        System.out.println("\n--- Available Courses Created ---");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " (Capacity: " + c.getCapacity() + ")");
        }

      
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Register a Student to a Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Select an option (1-3): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                   
                    System.out.println("\n--- Student Registration ---");
                    System.out.print("Enter Student ID: ");
                    String sId = scanner.nextLine().trim();

                    System.out.print("Enter Student Name: ");
                    String sName = scanner.nextLine().trim();

                    System.out.print("Enter Target Course Name: ");
                    String targetCourseName = scanner.nextLine().trim();


                    Course foundCourse = null;
                    for (Course c : courses) {
                        if (c.getCourseName().equalsIgnoreCase(targetCourseName)) {
                            foundCourse = c;
                            break;
                        }
                    }

                    if (foundCourse == null) {
                        System.out.println("No course found with that name.");
                    } else {
                        Student newStudent = new Student(sId, sName);
                        foundCourse.registerStudent(newStudent);
                    }
                    break;

                case "2":
                    
                    System.out.println("\n=== ALL COURSES INFORMATION ===");
                    for (Course c : courses) {
                        c.displayCourseInfo();
                    }
                    break;

                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid selection! Please choose 1, 2, or 3.");
                    break;
            }
        }

        scanner.close();
    }
}
