public class Swap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double[] inputArray = {1, 2., 3., 4., 5, 6, 7, 8, 9, 10};
        printArray(inputArray);
        swap(4, inputArray);
        System.out.println("Swap 4 & 5");
        printArray(inputArray);
        swap(8, inputArray);
        System.out.println("Swap 8 & 9");
        printArray(inputArray);
        swap(1, inputArray);
        System.out.println("Swap 1 & 2");
        printArray(inputArray);
    }

    static void swap(int x, double[] array) {
        x -= 1;//correct for indexing issue (for example swap(4, array) will normally not swap the 4th index
        if (x >= 0 && x < array.length) {
            double temp = array[x];
            array[x] = array[x + 1];
            array[x + 1] = temp;

        } else {
            System.out.println("**index out of bounds exception***");
        }
    }

    static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 5 == 0 && i != 0) {//only 5 elements will print on a line
                System.out.println();
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
