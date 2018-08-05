package main.Part1.Chapter2Sorting;

/**
 * @Author: Lwq
 * @Date: 2018/8/5 14:28
 * @Version 1.0
 * @Describe
 */
public class Student implements Comparable{

    String name;
    Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Object o) {
        Student student = (Student)o;
        return this.score.equals(student.score)?this.name.compareTo(student.name):this.score.compareTo(student.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
