/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author garbi
 */
public class CaesarNGTest {

    public CaesarNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of encode method, of class Caesar, with key = 7
     */
    @Test
    public void testEncodingWith_7() {
        int key = 7;
        System.out.println("encoding with key = " + key);
        String message = "Cowards die many times before their deaths";
        Caesar instance = new Caesar(key);
        String expResult = "Jvdhykz kpl thuf aptlz ilmvyl aolpy klhaoz";
        String result = instance.encode(message);
        assertEquals(result, expResult);
    }

    /**
     * Test of decode method, of class Caesar, with key = 7
     */
    @Test
    public void testDecodingWith_7() {
        int key = 7;
        System.out.println("decoding with key = " + key);
        String message = "Jvdhykz kpl thuf aptlz ilmvyl aolpy klhaoz";
        Caesar instance = new Caesar(key);;
        String expResult = "Cowards die many times before their deaths";
        String result = instance.decode(message);
        assertEquals(result, expResult);
    }

    /**
     * Test of encode method, of class Caesar, with key = 26 (idempotent)
     */
    @Test
    public void testEncodingWitch_26() {
        int key = 26;
        System.out.println("encoding with key = " + key);
        Caesar instance = new Caesar(key);
        String message = "Cowards die many times before their deaths";
        String result = instance.encode(message);
        assertEquals(result, message);
    }

    /**
     * Test of decode method, of class Caesar, with key = 26 (idempotent)
     */
    @Test
    public void testDecodingWith_26() {
        int key = 26;
        System.out.println("decoding with key = " + key);
        Caesar instance = new Caesar(key);;
        String message = "Cowards die many times before their deaths";
        String result = instance.decode(message);
        assertEquals(result, message);
    }

}
