package Queues.misc;


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueComparator {

    public static void main(String args[]) {
        Student s1 = new Student("abc", 1);
        Student s2 = new Student("abc1", 5);
        Student s3 = new Student("abc2", 3);
        Student s4 = new Student("abc3", 4);
        Student s5 = new Student("abc5", 0);
        PriorityQueue<Student> pq = new PriorityQueue<Student>(new StudnetComparator());
        pq.add(s1);
        pq.add(s2);
        pq.add(s3);pq.add(s4);pq.add(s5);
        for (Student s : pq) {
            System.out.println(s.getId());
        }
    }
}
class StudnetComparator implements Comparator<Student> {
@Override
public int compare(Student o1, Student o2) {
        if (o1.getId() < o2.getId())
        return 1;
        else if (o1.getId() > o2.getId())
        return -1;
        else
        return 0;
        }
        }
class Student {
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
