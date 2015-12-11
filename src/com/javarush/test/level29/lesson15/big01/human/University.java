package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private String name;
    private int age;

    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for (Student student : students) {
            if (student.getAverageGrade() == grade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double max = 0.0;
        Student bestStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() > max){
                bestStudent = student;
                max = student.getAverageGrade();
            }
        }
        return bestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        double min = Double.MAX_VALUE;
        Student worstStudent = null;
        for (Student student : students) {
            if (student.getAverageGrade() < min){
                worstStudent = student;
                min = student.getAverageGrade();
            }
        }
        return worstStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
