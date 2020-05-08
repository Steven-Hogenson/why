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
        
        String id = JOptionPane.showInputDialog("Enter ID: ");
        int idNum = Integer.parseInt(id);
        String firstName = JOptionPane.showInputDialog("Enter first name: ");
        String lastName = JOptionPane.showInputDialog("Enter last name: ");
        String major = JOptionPane.showInputDialog("Enter major: ");
        String grades = JOptionPane.showInputDialog("Enter grades separated by comma: ");
        String tempString = grades;
        String result[] = tempString.split(",");//splits the string of scores at each comma
        for (String s : result) {
            tempGrades.add(Integer.parseInt(s));
        }
        Student student = new Student(idNum, firstName, lastName, major, tempGrades);
        //System.out.println(student.toString() + "\n");
        JOptionPane.showMessageDialog(null, student.toString() + "\n");
   }
}
