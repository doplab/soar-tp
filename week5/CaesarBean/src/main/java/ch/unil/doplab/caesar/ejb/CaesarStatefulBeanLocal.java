/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.caesar.ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Admin
 */
@Remote
public interface CaesarStatefulBeanLocal {
    
    void setKey(int key);
    String encode(String message);
    String decode(String message);
    String cipher(String message);
    String decipher(String message);
    
    // We create a list of encoded messages
    List<String> getMessages();
    void addElement(String e);

}
