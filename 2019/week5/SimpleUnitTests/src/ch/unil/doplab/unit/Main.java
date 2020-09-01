/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.unit;

import java.util.Scanner;

/**
 *
 * @author garbi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caesar caesar = new Caesar(0);
        String response = "y";
        
        do {
            System.out.println("-------------");

            System.out.print("Enter a key: ");
            int key = sc.nextInt();
            sc.nextLine();
            caesar.setKey(key);

            System.out.print("Enter a message: ");
            String message = sc.nextLine();

            String cipheredMessage = caesar.encode(message);
            System.out.println("Encrypted Message = " + cipheredMessage);
            System.out.println("Decrypted Message = " + caesar.decode(cipheredMessage));
            System.out.print("Do you want to continue? ");
            response = sc.nextLine();
        } while (response.equals("y"));
        System.out.println("");
        System.out.println("Tu quoque fili mi!!!");
        System.out.println("-------------");
    }
}
