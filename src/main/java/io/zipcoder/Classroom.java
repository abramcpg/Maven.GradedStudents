package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Classroom {

    Student[] students;

    public Classroom(int maxNumberofStudents){
        this.students = new Student[maxNumberofStudents];
    }
    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom(){
        this.students = new Student[30];
    }

    public Student[] getStudents() { return students; }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for(Student x: students){
            average += x.getAverageExamScore();
        }

        return average;
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null)
                students[i] = student;
                break;
        }
    }
    public void removeStudent(String firstName, String lastName){
        Student student = new Student(firstName, lastName, new Double[0]);
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(student)){
                for (int j = 0; j < students.length-1; j++) {
                    students[j] = students[j+1];
                }
            }
        }
    }
    public HashMap<Student, String> getStudentsByScore(){
        Arrays.sort(students);
        Double highScore = students[0].getAnExamScore(0);
        Double lowScore = students[0].getAnExamScore(0);
        for(Student x : students){
            if(x.getAnExamScore(0)>highScore) highScore = x.getAnExamScore(0);
            else if(x.getAnExamScore(0)<lowScore) lowScore = x.getAnExamScore(0);
        }
        HashMap<Student, String> gradeBook = new HashMap<>(students.length);
        int count = 1;
        for(Student x:students){
            gradeBook.put(x, getLetterGrade(new Double(count++)/students.length));
        }
        return gradeBook;
    }
    public String getLetterGrade(Double percentile){
        if(percentile >= .90) return "A";
        else if (percentile >= .71) return "B";
        else if (percentile >= .50) return "C";
        else if (percentile >= .11) return "D";
        else return "F";
    }
}
