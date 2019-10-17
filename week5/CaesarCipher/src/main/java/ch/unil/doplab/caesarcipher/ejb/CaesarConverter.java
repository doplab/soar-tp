/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.caesarcipher.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class CaesarConverter {

    private int key = 0;


    public void setKey(String key) {
        this.key = Integer.parseInt(key) % 26;
    }
    
    public int getKey(){
        return this.key;
    }

    public String encode(String message) {
        return cipher(message);
//        return "not implemented yet";
    }

    public String decode(String message) {
        return decipher(message);
        //return "not implemented yet";
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
