import java.util.Scanner;

class Student {
    // Data members
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateFee() {
        return courseCredits * 1500;
    }

    // Method to calculate scholarship amount based on marks
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (marks >= 70 && marks <= 84) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship deduction
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name     : " + studentName);
        System.out.println("Roll Number      : " + rollNumber);
        System.out.println("Marks            : " + marks);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Course Credits   : " + courseCredits);
        System.out.println("Eligibility      : Eligible");
        System.out.println("Total Fee        : Rs. " + calculateFee());
        System.out.println("Scholarship      : Rs. " + calculateScholarship());
        System.out.println("Final Fee        : Rs. " + calculateFinalFee());
    }
}

public class Student1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);

    
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nStudent " + studentName + " (Roll No: " + rollNumber + ") is NOT ELIGIBLE for course registration.");
        }

        scanner.close();
    }
}