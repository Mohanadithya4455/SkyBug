import java.util.*;
class Course {
    String code;
    String title;
    String description;
    int capacity;
    int enrolledStudents;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code=code;
        this.title=title;
        this.description=description;
        this.capacity=capacity;
        this.enrolledStudents=0;
        this.schedule=schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public void enroll() {
        enrolledStudents++;
    }

    public void remove() {
        enrolledStudents--;
    }
}

class Student {
    int id;
    String name;
    List<Course> courses;

    Student(int id, String name) {
        this.id=id;
        this.name=name;
        this.courses=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void register(Course course) {
        courses.add(course);
        course.enroll();
    }

    public void drop(Course course) {
        courses.remove(course);
        course.remove();
    }
}

public class Task4 {
    private List<Course> courses;
    private List<Student> students;

    public Task4() {
        this.courses=new ArrayList<>();
        this.students=new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void registerStudent(Student s) {
        students.add(s);
    }

    public void displayCourses() {
        System.out.println("Course Listing:");
        for (Course c:courses) {
            System.out.println("Code: "+c.getCode());
            System.out.println("Title: "+c.getTitle());
            System.out.println("Description: "+c.getDescription());
            System.out.println("Capacity: "+c.getCapacity());
            System.out.println("Enrolled Students: "+c.getEnrolledStudents());
            System.out.println("Schedule: "+c.getSchedule());
            System.out.println("Available Slots: "+(c.getCapacity()-c.getEnrolledStudents()));
            System.out.println("------------------------------");
        }
    }

    public void displayStudentReg(int id) {
        Student student=findStudentById(id);
        if (student!=null) {
            System.out.println("Courses for "+student.getName()+" (ID: "+student.getId()+"):");
            List<Course> registeredCourses=student.getCourses();
            for (Course c:registeredCourses) {
                System.out.println("- "+c.getTitle());
            }
            System.out.println("------------------------------");
        } else {
            System.out.println("Student with ID "+id+" not found.");
        }
    }

    public void studentReg(int id, String code) {
        Student student=findStudentById(id);
        Course course=findCourseByCode(code);

        if (student!=null&&course!=null&&course.getEnrolledStudents()<course.getCapacity()) {
            student.register(course);
            System.out.println("Registration successful for student "+student.getName()+" in course "+course.getTitle());
        } else {
            System.out.println("Registration failed. Please check student ID and course availability.");
        }
    }

    public void courseRemoval(int id,String code) {
        Student student=findStudentById(id);
        Course course=findCourseByCode(code);

        if (student!=null&&course!=null&&student.getCourses().contains(course)) {
            student.drop(course);
            System.out.println("Course dropped successfully for student "+student.getName()+" in course "+course.getTitle());
        } else {
            System.out.println("Drop failed. Please check student ID and course registration.");
        }
    }

    public Student findStudentById(int id) {
        for (Student s:students) {
            if (s.getId()==id) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseByCode(String code) {
        for (Course c:courses) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Task4 obj=new Task4();
        Course c1=new Course("JVA", "Java Programming", "Introduction to Java", 50, "Mon/Wed/Fri 10:00 AM");
        Course c2=new Course("PYN", "Python Programming", "Introduction to Python", 40, "Tue/Thu 2:00 PM");
        Course c3=new Course("C", "C Programming", "Introduction to C", 30, "Mon/Wed 1:00 PM");
        Course c4=new Course("CPP", "C++ Programming", "Introduction to C++", 35, "Wed/Fri 3:00 PM");
        Course c5=new Course("JS", "JavaScript", "Introduction to JavaScript", 45, "Tue/Thu 10:00 AM");
        Course c6=new Course("DSA","Data structures","Introduction to Data Structures",50,"Mon/Tue 11:00 AM");
        obj.addCourse(c1);
        obj.addCourse(c2);
        obj.addCourse(c3);
        obj.addCourse(c4);
        obj.addCourse(c5);
        obj.addCourse(c6);
        Student s1=new Student(1001, "Mohanadithya");
        Student s2=new Student(1002, "Shannu");
        Student s3=new Student(1003, "Raju");
        Student s4=new Student(1004, "Pawankalyan");
        Student s5=new Student(1005, "vijay");
        Student s6=new Student(1006,"Ramesh");
        obj.registerStudent(s1);
        obj.registerStudent(s2);
        obj.registerStudent(s3);
        obj.registerStudent(s4);
        obj.registerStudent(s5);
        obj.registerStudent(s6);
        obj.displayCourses();

        obj.studentReg(1003, "JVA");
        obj.studentReg(1003, "PYN");
        obj.studentReg(1004, "C");
        obj.studentReg(1005, "CPP");
        obj.studentReg(1005, "JS");

        obj.displayStudentReg(1003);
        obj.displayStudentReg(1004);
        obj.displayStudentReg(1005);
        obj.courseRemoval(1003, "PYN");
        obj.displayStudentReg(1003);
    }
}
