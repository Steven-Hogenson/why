public class Main {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
        SubstitutionCipher subC = new SubstitutionCipher(3);
        System.out.println(subC.encode("outstanding"));
        System.out.println(subC.decode("outstanding"));
        
        ShuffleCipher shuffleC = new ShuffleCipher(1);
        System.out.println(shuffleC.encode("outstanding"));
        System.out.println(shuffleC.decode("outstanding"));
      }
    }
