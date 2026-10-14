
package courseregistrationsystem1;


class Student {
    private String studentID;
    private String name;

  
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

 
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }


    public void printStudentInfo() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
    }
    
}
