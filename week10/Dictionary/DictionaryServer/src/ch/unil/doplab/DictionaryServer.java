/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author garbi
 */
public class DictionaryServer {
    
    public static void main(String[] args) {
        
        HashMap<String, String> dico = new HashMap<String, String>();
        dico.put("inheritance", "héritage");
        dico.put("distributed", "réparti");
        
    
        ServerSocket connectionServer = null;
        Socket clientSession = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            connectionServer = new ServerSocket(4444);
            clientSession = connectionServer.accept();
            out = new PrintWriter(clientSession.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSession.getInputStream()));
            String word, mot;

            while ((word = in.readLine()) != null) {
                mot = (String) dico.get(word);
                
                if (mot == null) {
                    mot = "sorry, no translation available for \"" + word + "\" !";
                }
                out.println(mot);
            }
            out.close();
            in.close();
            connectionServer.close();
            clientSession.close();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
