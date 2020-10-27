/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.shoppingwebsite_v3.models.managers;

import javax.ejb.Remote;

/**
 *
 * @author Melike Geçer
 */
@Remote
public interface ModelManagerSessionBeanRemote {

    String userLogsIn(String username, String password);

    String userLogsout();

    
}
