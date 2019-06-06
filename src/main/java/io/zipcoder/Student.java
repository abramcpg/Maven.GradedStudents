package io.zipcoder;
import java.util.ArrayList;

public class Student {
    String firstName; //Instances
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores){ //Constructor

    }
    public String getFirstName(){ //Getter
        return this.firstName;
    }
    public void setFirstName(String firstName){ //Setter
        this.firstName = firstName;
    }
    public String getLastName(){
        return this.firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken(){ //Return number of tests taken by student
        return null;
    }
    public String getExamScores(String firstName, String lastName, Double[] examScores){
        String scores = "Exam Scores:\n";
        Integer count = 1;
        for (Double score : examScores){
            scores += String.format("\tExam %d -> %.0f\n", count++, score);
        }
        return scores;
    }

}

