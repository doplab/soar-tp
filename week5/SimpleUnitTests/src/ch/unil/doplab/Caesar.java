/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab;

/**
 *
 * @author garbi
 */
public class Caesar {

    private int key;

    public Caesar(int key) {
        this.key = key;
    }

    public void setKey(int key) {
        this.key = key % 26;
    }

    public String encode(String message) {
//        return cipher(message);
        return "not implemented yet";
    }

    public String decode(String message) {
//        return decipher(message);
        return "not implemented yet";
    }

    private String cipher(String message) {
        String encryptedMessage = "";
        char ch;

        for (int i = 0; i < message.length(); ++i) {
            ch = message.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + key);

                if (ch > 'z') {
                    ch = (char) (ch - 'z' + 'a' - 1);
                }

                encryptedMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + key);

                if (ch > 'Z') {
                    ch = (char) (ch - 'Z' + 'A' - 1);
                }

                encryptedMessage += ch;
            } else {
                encryptedMessage += ch;
            }
        }
        return encryptedMessage;
    }

    private String decipher(String message) {
        String decryptedMessage = "";
        char ch;

        for (int i = 0; i < message.length(); ++i) {
            ch = message.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - key);

                if (ch < 'a') {
                    ch = (char) (ch + 'z' - 'a' + 1);
                }

                decryptedMessage += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - key);

                if (ch < 'A') {
                    ch = (char) (ch + 'Z' - 'A' + 1);
                }

                decryptedMessage += ch;
            } else {
                decryptedMessage += ch;
            }
        }
        return decryptedMessage;
    }
}
