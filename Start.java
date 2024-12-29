package AppStart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

    public static void main(String[] args, int id) throws NumberFormatException, IOException, ClassNotFoundException {
        // Create BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean continueApp = true;  // Variable to control the while loop
        
        while (continueApp) {
            // Display menu options to the user
            System.out.println("\n--- Student Management System ---");
            System.out.println("Press 1 to ADD student");
            System.out.println("Press 2 to DELETE student");
            System.out.println("Press 3 to DISPLAY student");
            System.out.println("Press 4 to EXIT");
            
            int choice = Integer.parseInt(br.readLine());  // Read user choice
            
            switch (choice) {
            case 1:
                    // Add student...
                    System.out.println("Enter student name:");
                    String name = br.readLine();
                    
                    System.out.println("Enter student city:");
                    String city = br.readLine();
                    
                    // Create student object and add to database
                    Student student = new Student(id, name, city);
                    boolean isAdded = StudentDao.insertStudenttoDB(student, student);
                    
                    if (isAdded) {
                        System.out.println("Student added successfully: " + student);
                    } else {
                        System.out.println("Something went wrong, please try again.");
                    }
                    break;
                    
                case 2:
                    // Delete student...
                    System.out.println("Enter student ID to delete:");
                    int studentId = Integer.parseInt(br.readLine());
                    
                    boolean isDeleted = StudentDao.deleteStudentFromDB(studentId);
                    
                    if (isDeleted) {
                        System.out.println("Student with ID " + studentId + " deleted successfully.");
                    } else {
                        System.out.println("Student with ID " + studentId + " not found.");
                    }
                    break;
                    
                case 3:
                    // Display student...
                    System.out.println("Enter student ID to display:");
                    int displayId = Integer.parseInt(br.readLine());
                    
                    Student studentInfo = StudentDao.getStudentById(displayId);
                    
                    if (studentInfo != null) {
                        System.out.println("Student Details: " + studentInfo);
                    } else {
                        System.out.println("Student with ID " + displayId + " not found.");
                    }
                    break;
                    
                case 4:
                    // Exit the application
                    continueApp = false;
                    System.out.println("Thank you for using the Student Management System. See you soon!");
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
