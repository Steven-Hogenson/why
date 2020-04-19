/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Steven Hogenson
 */
public class ShuffleCipher implements StringDecoder, StringEncoder {

    private int n;

    public ShuffleCipher(int n) {
        this.n = n;
    }

    /**
     * Repeatedly performs shuffle() method n times on plainText
     * @param plainText the input text to be encoded
     * @return shuffled plainText
     */
    public String encode(String plainText) {
        String s = plainText;
        for (int i = 0; i < n; i++) {
            s = shuffle(s);
        }
        return s;
    }

    /**
     * Splits plain text string in half, then adds the characters from each half (by index) to a single returned string
     * @param s the plain text to be shuffled
     * @return shuffled text (to be passed to encode() method)
     */
    private String shuffle(String s) {
        String result = "";
        int midpoint = s.length() - s.length() / 2;
        String firstHalf = s.substring(0, midpoint);
        String secondHalf = s.substring(midpoint, s.length());
        
        if (firstHalf.length() > secondHalf.length()) {
            for (int i = 0; i < firstHalf.length() - 1; i++) {
                result += firstHalf.charAt(i) + "" + secondHalf.charAt(i);
            }
            result += firstHalf.charAt(firstHalf.length() - 1);//add last character to end of string if there is an odd # of characters (to avoid out of bounds exception)
        } else {
            for (int i = 0; i < firstHalf.length(); i++) {
                result += firstHalf.charAt(i) + "" + secondHalf.charAt(i);
            }
        }
        
        return result;
    }

    /**
     * Performs unshuffle() method n times to decode cipher text to plain text
     * @param cipherText input text to be decoded
     * @return plain text string
     */
    public String decode(String cipherText) {
        String s = cipherText;
        for (int i = 0; i < n; i++) {
            s = unshuffle(s);
        }
        return s;
    }

    /**
     * Adds every other index character to a string to decode
     * @param s the encoded text
     * @return encoded text (to be passed to decode)
     */
    private String unshuffle(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i += 2) {
            result += s.charAt(i);
        }
        for (int i = 1; i < s.length(); i += 2) {
            result += s.charAt(i);
        }
        return result;
    }
}
