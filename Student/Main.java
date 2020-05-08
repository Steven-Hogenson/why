import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Steven Hogenson
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> tempGrades = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("enter id: ");
        int id = sc.nextInt();
        System.out.print("enter first name: ");
        String fName = sc.next();
        System.out.print("enter last name: ");
        String lName = sc.next();
        System.out.print("enter major: ");
        String major = sc.next();
        major += sc.nextLine();
        System.out.print("enter grades: ");
        String grades = sc.next();

        String tempString = grades;
        String result[] = tempString.split(",");//splits the string of scores at each comma
        for (String s : result) {
            tempGrades.add(Integer.parseInt(s));
        }
        Student student = new Student(id, fName, lName, major, tempGrades);
        System.out.println(student.toString() + "\n");
   }
}
