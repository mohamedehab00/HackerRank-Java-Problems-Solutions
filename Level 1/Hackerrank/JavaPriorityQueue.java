import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class StudentComparator implements Comparator<Student>{

    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() < s2.getCgpa()){
            return 1;
        }
        else if (s1.getCgpa() > s2.getCgpa()){
            return -1;
        }
        else {
            if (s1.getName().compareTo(s2.getName()) > 0) {
                return 1;
            } else if (s1.getName().compareTo(s2.getName()) < 0) {
                return -1;
            } else {
                if (s1.getId() < s2.getId()) {
                    return 1;
                } else if (s1.getCgpa() > s2.getCgpa()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
class Priorities{
    public PriorityQueue<Student> queue;

    public Priorities() {
        this.queue = new PriorityQueue<>(new StudentComparator());
    }
    
    public List<Student> getStudents(List<String> events){
        for (int i = 0; i < events.size(); i++) {
            String[] arr = events.get(i).split(" ");
            if (arr[0].compareTo("ENTER") == 0){
                Student student = new Student(Integer.parseInt(arr[3]),arr[1],Double.parseDouble(arr[2]));
                this.queue.add(student);
            }
            else {
                this.queue.poll();
            }
        }
           List<Student> students = new ArrayList<>();

        while (!this.queue.isEmpty()){
            students.add(this.queue.poll());
        }
        
        return students;
    }
}
class Student{
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}