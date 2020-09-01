/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.caesar.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author Admin
 */
@Stateful
public class CaesarStatefulBean implements CaesarStatefulBeanLocal {
    
    private int key = 0;
    
    @Override
    public void setKey(int key) {
        this.key = key;
    }
    
    @Override
    public String cipher(String message) {
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
    
    @Override
    public String decipher(String message) {
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

    @Override
    public String encode(String message) {
        return cipher(message);
    }

    @Override
    public String decode(String message) {
        return decipher(message);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    List<String> values = new ArrayList<>();

    @Override
    public List<String> getMessages() {
        return values;
    }

    @Override
    public void addElement(String e) {
        values.add(e);
    }



   

    
}
