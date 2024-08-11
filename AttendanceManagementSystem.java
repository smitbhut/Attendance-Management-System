import java.util.Scanner;

class Node {
    String studentName;
    boolean isPresent;
    Node next;

    Node(String name, boolean present) {
        this.studentName = name;
        this.isPresent = present;
        this.next = null;
    }
}

class AttendanceLinkedList {
    Node head;

    AttendanceLinkedList() {
        this.head = null;
    }

    void addStudent(String name, boolean present) {
        Node newNode = new Node(name, present);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void markAttendance(String name) {
        Node current = head;
        while (current != null) {
            if (current.studentName.equals(name)) {
                current.isPresent = true;
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found: " + name);
    }

    void removeStudent(String name) {
        if (head == null) {
            System.out.println("Attendance list is empty.");
            return;
        }

        if (head.studentName.equals(name)) {
            head = head.next;
            System.out.println(name + " has been removed from the list.");
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && !current.studentName.equals(name)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Student not found: " + name);
        } else {
            prev.next = current.next;
            System.out.println(name + " has been removed from the list.");
        }
    }

    boolean isStudentPresent(String name) {
        Node current = head;
        while (current != null) {
            if (current.studentName.equals(name)) {
                return current.isPresent;
            }
            current = current.next;
        }
        System.out.println("Student not found: " + name);
        return false;
    }

    double calculateAttendancePercentage() {
        if (head == null) {
            System.out.println("Attendance list is empty.");
            return 0.0;
        }

        int totalStudents = 0;
        int presentStudents = 0;

        Node current = head;
        while (current != null) {
            totalStudents++;
            if (current.isPresent) {
                presentStudents++;
            }
            current = current.next;
        }

        if (totalStudents == 0) {
            System.out.println("No students in the attendance list.");
            return 0.0;
        }

        double attendancePercentage = ((double) presentStudents / totalStudents) * 100;
        return attendancePercentage;
    }

    void displayAbsentStudents() {
        if (head == null) {
            System.out.println("Attendance list is empty.");
            return;
        }

        System.out.println("Absent Students:");
        Node current = head;
        while (current != null) {
            if (!current.isPresent) {
                System.out.println(current.studentName);
            }
            current = current.next;
        }
    }

    void clearAttendanceList() {
        head = null;
        System.out.println("Attendance list has been cleared.");
    }

    void displayPresentStudents() {
        if (head == null) {
            System.out.println("Attendance list is empty.");
            return;
        }

        System.out.println("Present Students:");
        Node current = head;
        while (current != null) {
            if (current.isPresent) {
                System.out.println(current.studentName);
            }
            current = current.next;
        }
    }

    String findStudentWithHighestAttendance() {
        if (head == null) {
            return "Attendance list is empty.";
        }

        Node current = head;
        String studentNameWithHighestAttendance = "";
        int highestAttendanceCount = 0;

        while (current != null) {
            int currentAttendanceCount = 0;
            Node innerCurrent = head;

            while (innerCurrent != null) {
                if (innerCurrent.studentName.equals(current.studentName) && innerCurrent.isPresent) {
                    currentAttendanceCount++;
                }
                innerCurrent = innerCurrent.next;
            }

            if (currentAttendanceCount > highestAttendanceCount) {
                highestAttendanceCount = currentAttendanceCount;
                studentNameWithHighestAttendance = current.studentName;
            }

            current = current.next;
        }

        return studentNameWithHighestAttendance;
    }

    String findStudentWithLowestAttendance() {
        if (head == null) {
            return "Attendance list is empty.";
        }

        Node current = head;
        String studentNameWithLowestAttendance = "";
        int lowestAttendanceCount = Integer.MAX_VALUE;

        while (current != null) {
            int currentAttendanceCount = 0;
            Node innerCurrent = head;

            while (innerCurrent != null) {
                if (innerCurrent.studentName.equals(current.studentName) && innerCurrent.isPresent) {
                    currentAttendanceCount++;
                }
                innerCurrent = innerCurrent.next;
            }

            if (currentAttendanceCount < lowestAttendanceCount) {
                lowestAttendanceCount = currentAttendanceCount;
                studentNameWithLowestAttendance = current.studentName;
            }

            current = current.next;
        }

        return studentNameWithLowestAttendance;
    }

    int getTotalStudents() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void displayAllStudents() {
        if (head == null) {
            System.out.println("Attendance list is empty.");
            return;
        }

        System.out.println("All Students:");
        Node current = head;
        while (current != null) {
            System.out.println(current.studentName);
            current = current.next;
        }
    }
}

class AttendanceManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceLinkedList attendanceList = new AttendanceLinkedList();

        while (true) {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Remove Student");
            System.out.println("4. Check Attendance");
            System.out.println("5. Calculate Attendance Percentage");
            System.out.println("6. Display Absent Students");
            System.out.println("7. Display Present Students");
            System.out.println("8. Find Student with Highest Attendance");
            System.out.println("9. Find Student with Lowest Attendance");
            System.out.println("10. Get Total Students");
            System.out.println("11. Display All Students");
            System.out.println("12. Clear Attendance List");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    attendanceList.addStudent(name, false);
                    System.out.println(name + " added to the list.");
                    break;
                case 2:
                    System.out.print("Enter student name to mark attendance: ");
                    String studentName = scanner.nextLine();
                    attendanceList.markAttendance(studentName);
                    break;
                case 3:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    attendanceList.removeStudent(removeName);
                    break;
                case 4:
                    System.out.print("Enter student name to check attendance: ");
                    String checkName = scanner.nextLine();
                    boolean isPresent = attendanceList.isStudentPresent(checkName);
                    if (isPresent) {
                        System.out.println(checkName + " is present.");
                    } else {
                        System.out.println(checkName + " is absent.");
                    }
                    break;
                case 5:
                    double attendancePercentage = attendanceList.calculateAttendancePercentage();
                    System.out.println("Attendance Percentage: " + attendancePercentage + "%");
                    break;
                case 6:
                    attendanceList.displayAbsentStudents();
                    break;
                case 7:
                    attendanceList.displayPresentStudents();
                    break;
                case 8:
                    String studentWithHighestAttendance = attendanceList.findStudentWithHighestAttendance();
                    System.out.println("Student with Highest Attendance: " + studentWithHighestAttendance);
                    break;
                case 9:
                    String studentWithLowestAttendance = attendanceList.findStudentWithLowestAttendance();
                    System.out.println("Student with Lowest Attendance: " + studentWithLowestAttendance);
                    break;
                case 10:
                    int totalStudents = attendanceList.getTotalStudents();
                    System.out.println("Total Students: " + totalStudents);
                    break;
                case 11:
                    attendanceList.displayAllStudents();
                    break;
                case 12:
                    attendanceList.clearAttendanceList();
                    break;
                case 13:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}