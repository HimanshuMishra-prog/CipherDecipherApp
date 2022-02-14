package com.source;

/**
 * CeaserCipher uses the traditional ceaser cipher but it also encrypts special characters
 *
 * @author (Himanshu Mishra)
 * @version (version 1.1)
 */

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;

    private int key;
    private int specialKey;
    private String  specialAlphabet;
    private String shiftedSpecialAlphabet;

    public CaesarCipher(int k) {
        //if %26 than Capital is replaced by Capital if %52 than replace space is 52 so captial can be replaced by small
        key = k%26;
        if(key == 0)key++;
        specialKey = k%29;
        if(specialKey == 0)key++;
        specialAlphabet = "0123456789@%+/'!#$^?:.(){}[]~";
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0,key);
        shiftedSpecialAlphabet = specialAlphabet.substring(specialKey)+
                specialAlphabet.substring(0,specialKey);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {

        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    private String transform(String input, String from, String to){
        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            int index = specialAlphabet.indexOf(c);

            if(index != -1) {

                if(from == shiftedAlphabet)c = transformLetter(c, shiftedSpecialAlphabet, specialAlphabet );
                else c = transformLetter(c, specialAlphabet, shiftedSpecialAlphabet);
            }
            else {
                c = transformLetter(c, from, to);
            }
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }

    public String encrypt(String input) {

        return transform(input, alphabet, shiftedAlphabet);
    }

    public String decrypt(String input) {
        return transform(input, shiftedAlphabet, alphabet);
    }

    public String toString() {
        return "" + key;
    }

    public static void main(String [] args) {
        String message = "HZello1 my name is himanshu";
        CaesarCipher ch = new CaesarCipher(52);
        String ans = ch.encrypt(message);
        System.out.println(ch.encrypt(message));
        System.out.println(ch.decrypt(ans));
    }

}

