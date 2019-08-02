package io.zipcoder;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.String.format;

public class Student {
    private String firstName; //Instances
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>(0);

    public Student(String firstName, String lastName, Double[] testScores) { //Constructor
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() { //Getter
        return this.firstName;
    }

    public void setFirstName(String firstName) { //Setter
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() { //Return number of tests taken by student
        return null;
    }

    public Double getAnExamScore(Integer testIndex){
        return examScores.get(testIndex);
    }

    public String getExamScores() {
        String scores = "Exam Scores:\n";
        Integer count = 1;
        for (Double score : examScores) {
            scores += format("\tExam %d -> %.0f\n", count++, score);
        }
        return scores;
    }

    public void addExamScore(Double examScore) {
        examScores.add(examScore);
    }

    public boolean setExamScore(int examNumber, double newScore) {
        if (examNumber >= 0 && examNumber <= examScores.size()) {
            examScores.set(examNumber, newScore);
            return true;
        }
        return false;
    }

    public Double getAverageExamScore() {
        Double averageScore = 0d;
        for (Double score : examScores) {
            averageScore += score;
        }

        return averageScore /= examScores.size();
    }
    @Override
    public String toString(){
        String studentInfo = format(">Student Name: % %\nAverage Score: %\n>Exam Scores:\n",
                this.firstName, this.lastName, this.getAverageExamScore());
        int count =1;
        for(Double score:examScores){
            studentInfo += format("\tExam %d -> %.0f\n", count++,score);
        }
        return studentInfo;
    }

}
