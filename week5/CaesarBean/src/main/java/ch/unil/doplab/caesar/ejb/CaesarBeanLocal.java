/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.caesar.ejb;

import javax.ejb.Local;

/**
 *
 * @author garbi
 */
@Local
public interface CaesarBeanLocal {
    
    String encode(String message, int key);
    String decode(String message, int key);

}
