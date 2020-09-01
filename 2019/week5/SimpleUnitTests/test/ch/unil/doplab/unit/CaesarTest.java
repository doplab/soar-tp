/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unil.doplab.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

/**
 *
 * @author Admin
 */
public class CaesarTest {
    
    public CaesarTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setKey method, of class Caesar.
     */
    @Test
    public void testSetKey() {
        System.out.println("setKey");
        int key = 0;
        Caesar instance = null;
        instance.setKey(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encode method, of class Caesar.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        String message = "";
        Caesar instance = null;
        String expResult = "";
        String result = instance.encode(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decode method, of class Caesar.
     */
    @Test
    public void testDecode() {
        System.out.println("decode");
        String message = "";
        Caesar instance = null;
        String expResult = "";
        String result = instance.decode(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
   @org.testng.annotations.Test
    public void testEncodingWith_29() {
        int key = 29;
        System.out.println("encoding with key = " + key);
        String message = "Cowards die many times before their deaths";
        String expResult = "Frzdugv glh pdqb wlphv ehiruh wkhlu ghdwkv";
        Caesar instance = new Caesar(key);
        System.out.println(expResult);
        String result = instance.encode(message);
        assertEquals(result, expResult);
    }
    
}
