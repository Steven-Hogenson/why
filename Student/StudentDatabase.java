/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Steven Hogenson
 */
public class StudentDatabase {

    public static void main(String args[]) throws IOException {

        final String INPUT_FILE = "student_records.txt";
        Scanner sc = new Scanner(System.in);

        try {
            ArrayList<Student> studentList = readStudents(INPUT_FILE);

            for (Student student : studentList) {
                System.out.println(student + "\n");
            }

            System.out.print("Do you want to save all the players in the file? [Y/N]");
            String fileOption = sc.nextLine();

            if (fileOption.equalsIgnoreCase("y")) {
                System.out.print("Enter output file name: ");
                String outputFile = sc.nextLine();
                saveStudents(outputFile + ".txt", studentList);
            }

            // Catch statement that will throw an exception is the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("File Error: " + INPUT_FILE + " is not found.");
        }
        sc.close();

    }

    private static ArrayList<Student> readStudents(String fileName) throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));

        while (sc.hasNextLine()) {
            String[] newLine = sc.nextLine().split(",");
            int studentId = Integer.parseInt(newLine[0]);
            String fullName = newLine[1];
            String[] fullNameSplit = fullName.split(" ");
            String firstName = fullNameSplit[0];
            String lastName = fullNameSplit[1];
            String major = newLine[2];

            ArrayList<Integer> scores = new ArrayList<>();
            for (int i = 3; i < newLine.length; i++) {
                scores.add(Integer.parseInt(newLine[i]));
            }

            Student newStudent = new Student(studentId, firstName, lastName, major, scores);
            studentList.add(newStudent);
        }
        return studentList;
    }

    private static void saveStudents(String fileName, ArrayList<Student> studentList) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(fileName);
        File f = new File(fileName);
        for (Student currentPlayer : studentList) {
            printWriter.println(currentPlayer + "\n");
        }

        System.out.println("Output file saved to " + f.getAbsolutePath());
        printWriter.close();
    }

}
