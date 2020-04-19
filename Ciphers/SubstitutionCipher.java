/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Steven Hogenson
 */
public class SubstitutionCipher implements StringEncoder, StringDecoder {

    private int shift;

    public SubstitutionCipher(int shift) {
        this.shift = shift;
    }

    public String encode(String plainText) {
        char charArr[] = plainText.toCharArray();
        String result = "";
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isLetter(charArr[i])) {//excludes cases for non-letters
                if (Character.isLowerCase(charArr[i])) {
                    result += (char) (((int) charArr[i] + shift - 97) % 26 + 97);//97 ASCII value for 'a'; if character is lower case
                } else {
                    result += (char) (((int) charArr[i] + shift - 65) % 26 + 65);//65 ASCII value for 'A'; if character is upper case
                }
            } else {
                result += charArr[i];
            }
        }

        return result;
    }

   
    public String decode(String cipherText) {
        char charArr[] = cipherText.toCharArray();
        String result = "";
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isLetter(charArr[i])) {//excludes cases for non-letters
                if (Character.isLowerCase(charArr[i])) {
                    result += (char) (((int) charArr[i] - shift - 97) % 26 + 97);//97 ASCII value for 'a'; if character is lower case (same as encode but subtract shift value)
                } else {
                    result += (char) (((int) charArr[i] - shift - 65) % 26 + 65);//65 ASCII value for 'A'; if character is upper case (same as encode but subtract shift value)
                }
            } else {
                result += charArr[i];
            }
        }

        return result;
    }

}
