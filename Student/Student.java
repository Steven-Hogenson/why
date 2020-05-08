/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constructorpractice;

import java.util.ArrayList;

/**
 *
 * @author Steven Hogenson
 */
public class Student {

    int id;
    String firstName;
    String lastName;
    String major;
    String rawGrades;
    ArrayList<Integer> grades = new ArrayList<>();

    public Student() {
        this.id = -1;
        this.firstName = "";
        this.lastName = "";
        this.major = "";

    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = "";
    }

    public Student(int id, String firstName, String lastName, String major, ArrayList<Integer> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.grades = grades;
    }

    //****************MUTATORS*****************//
    public void setID(int id) {
        this.id = id;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    //****************ACCESSORS*****************//
    public int getID() {
        return id;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    /**
     *
     * @return full name of student
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getAverageScore() {
        double avgScore = 0;
        for (int i = 0; i < grades.size(); i++) {
            avgScore += grades.get(i);
        }
        avgScore /= grades.size();
        return avgScore;

    }

    public String getLetterGrade() {
        double avgScore = getAverageScore();

        if (avgScore >= 90) {
            return "A";
        } else if (avgScore >= 80) {
            return "B";
        } else if (avgScore >= 70) {
            return "C";
        } else if (avgScore >= 60) {
            return "D";
        } else if (avgScore >= 0) {
            return "F";
        } else {
            return "";
        }

    }

    public String listScores() {
        if (!grades.isEmpty()) {
            String s = "";
            for (int x : grades) {
                s += x + ", ";
            }
            return s.substring(0, s.length() - 2);//removes the last comma and space
        }
        return "";

    }

    @Override
    public String toString() {
        String result = "";
        result += "Student ID: " + getID();
        result += "\nName: " + getFullName();
        result += "\nMajor: " + getMajor();
        result += "\nScores: " + listScores();
        result += "\nAverage Score: " + getAverageScore();
        result += "\nGrade: " + getLetterGrade();

        return result;

    }

}
