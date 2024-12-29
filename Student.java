package com.student.manage;

public class Student {

    private int studentId;
    private String studentName;
    private String studentCity;

    // Constructor with studentId, studentName, and studentCity
    public Student(int studentId2, String studentName, String studentCity) {
        this.studentId = studentId2;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }


    // Default constructor (if needed for certain frameworks or serialization)
    public Student() {
        // No initialization
    }

    // Getter and Setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    // Override toString() for better representation of the student object
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity + "]";
    }

    // Override equals() and hashCode() for proper comparison in collections or databases
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        try {
			return Integer.hashCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


	

	

	
	
}
