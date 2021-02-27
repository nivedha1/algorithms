package Queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueImpl {

    public static void main(String args[]) {
        PriorityQueueImpl object = new PriorityQueueImpl();
        object.generateStudents();
    }

    //Always use arraylist insead of priorityqueue
    private void generateStudents() {
        ArrayList<Student> obj = new ArrayList<Student>();
        obj.add(new Student("abc1", 7));
        obj.add(new Student("abc2", 2));
        obj.add(new Student("abc3", 1));
        obj.add(new Student("abc5", 4));
        obj.add(new Student("abc4", 3));
        obj.add(new Student("abc6", 0));
        int i = 0;
        Collections.sort(obj);//if this is not there it will not sort
        while (!obj.isEmpty()) {
            Student a = obj.get(i++);
            System.out.println(a.getName() + " " + a.getAge());
        }
    }
}

class Student implements Comparable<Student> {//dont use comparator se only comparable

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o1) {
        if (this.getAge() > o1.getAge())
            return -1;
        else if (this.getAge() < o1.getAge())
            return 1;
        else
            return 0;
    }

}