class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Kuunal", 20);
        Student s2 = new Student("Rahul", 21);

        System.out.println("Student 1");
        s1.display();

        System.out.println();

        System.out.println("Student 2");
        s2.display();
    }
}