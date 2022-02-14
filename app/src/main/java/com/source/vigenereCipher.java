package com.source;


/**
 * VigenereCipher uses the traditional ceaser cipher but it also encrypts special characters
 *
 * @author (Himanshu Mishra)
 * @version (version 1.1)
 */


public class vigenereCipher {
    CaesarCipher[] ciphers;

    public vigenereCipher(int[] key) {
        ciphers = new CaesarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaesarCipher(key[i]);
        }
    }

    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaesarCipher thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }

    public static void main(String []args) {
        vigenereCipher vc = new vigenereCipher(new int[]{10,20,12,15});
        String ans = vc.encrypt("Hello  123 #* my name is Himanshu Misrhra");
        System.out.println(ans);
        System.out.println(vc.decrypt(ans));
    }
}

