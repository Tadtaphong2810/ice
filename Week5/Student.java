public class Student {
    // Data properties
    private String studentId;
    private String firstName;
    private String lastName;
    private int age;
    private String major;
    private double gpa;
    private int year;
    
    // Constructor
    public Student(String studentId, String firstName, String lastName, int age, String major) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        this.gpa = 0.0;
        this.year = 1;
    }
    
    // Getter methods
    public String getStudentId() {
        return studentId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public int getYear() {
        return year;
    }
    
    // Setter methods
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA. GPA must be between 0.0 and 4.0");
        }
    }
    
    public void setYear(int year) {
        if (year >= 1 && year <= 4) {
            this.year = year;
        } else {
            System.out.println("Invalid year. Year must be between 1 and 4");
        }
    }
    
    // Method to update GPA
    public void updateGpa(double newGpa) {
        setGpa(newGpa);
    }
    
    // Method to promote to next year
    public void promoteYear() {
        if (year < 4) {
            year++;
            System.out.println(getFullName() + " has been promoted to year " + year);
        } else {
            System.out.println(getFullName() + " is already in the final year");
        }
    }
    
    // Method to get student information
    public String getStudentInfo() {
        return "Student ID: " + studentId + 
               "\nName: " + getFullName() + 
               "\nAge: " + age + 
               "\nMajor: " + major + 
               "\nYear: " + year + 
               "\nGPA: " + gpa;
    }
    
    // Method to check if student is passing
    public boolean isPassing() {
        return gpa >= 2.0;
    }
    
    // Method to get academic standing
    public String getAcademicStanding() {
        if (gpa >= 3.5) {
            return "Dean's List";
        } else if (gpa >= 3.0) {
            return "Good Standing";
        } else if (gpa >= 2.0) {
            return "Satisfactory";
        } else {
            return "Academic Probation";
        }
    }
    
    // toString method
    @Override
    public String toString() {
        return "Student{id='" + studentId + "', name='" + getFullName() + 
               "', age=" + age + ", major='" + major + 
               "', year=" + year + ", gpa=" + gpa + "}";
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create student1 object from Student class
        Student student1 = new Student("S001", "John", "Doe", 20, "Computer Science");
        
        // Set additional properties for student1
        student1.setGpa(3.7);
        student1.setYear(2);
        
        // Display student1 information
        System.out.println("=== Student1 Object ===");
        System.out.println("Student ID: " + student1.getStudentId());
        System.out.println("Full Name: " + student1.getFullName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Major: " + student1.getMajor());
        System.out.println("Year: " + student1.getYear());
        System.out.println("GPA: " + student1.getGpa());
        System.out.println("Academic Standing: " + student1.getAcademicStanding());
        System.out.println("Is Passing: " + student1.isPassing());
        
        // Display complete student info
        System.out.println("\n=== Complete Student1 Info ===");
        System.out.println(student1.getStudentInfo());
        
        // Display toString representation
        System.out.println("\n=== Student1 toString ===");
        System.out.println(student1);
        
        // Test some methods
        System.out.println("\n=== Testing Methods ===");
        System.out.println("Updating GPA...");
        student1.updateGpa(3.8);
        System.out.println("New GPA: " + student1.getGpa());
        System.out.println("New Academic Standing: " + student1.getAcademicStanding());
    }
}
