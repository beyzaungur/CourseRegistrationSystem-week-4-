
package courseregistrationsystem1;
import java.util.ArrayList;
class Course {
    private String courseName;
    private int capacity;
    private ArrayList<Student> enrolledStudents;

   
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

 
    public boolean registerStudent(Student student) {
    
        if (enrolledStudents.size() >= capacity) {
            System.out.println("This course is full. Registration failed.");
            return false;
        }

  
        for (Student s : enrolledStudents) {
            if (s.getStudentID().equalsIgnoreCase(student.getStudentID())) {
                System.out.println("This student is already registered for this course.");
                return false;
            }
        }

   
        enrolledStudents.add(student);
        System.out.println("Registration successful.");
        return true;
    }


    public void displayCourseInfo() {
        System.out.println("\n-------------------------------------------");
        System.out.println("Course: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Enrolled: " + enrolledStudents.size());
        System.out.print("Enrolled Students: ");

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled yet.");
        } else {
            System.out.println();
            for (Student s : enrolledStudents) {
                System.out.println(" - " + s.getName() + " (ID: " + s.getStudentID() + ")");
            }
        }
        System.out.println("-------------------------------------------");
    }
}


