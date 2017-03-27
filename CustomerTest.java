/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PG2Test;
import PG2.Customer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author xomin
 */
public class CustomerTest {
    
  
    @Test  
    public void addLicense(){
        Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");
        String license = "AKR7894";
        assertTrue("Checking to see if adds license",c1.addLicense(license));
        
    }
    @Test  
    public void removeLicense(){
        Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");
        String license = "ASH458";
        c1.addLicense(license);
        assertTrue("Checking to see if removes license",c1.removeLicense(license));
        
    }
      @Test
    public void getLastNameTest() {
        Customer c1 = new Customer("cassel", "sam", "sam@gmail.com", "AKD8374K");

        String name = "cassel";
        assertEquals("Check to see equal", name, c1.getLastName());
    }

    @Test
    public void getFirstNameTest() {
         Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");

        String name = "Samantha";
        assertEquals("Check to see equal", name, c1.getFirstName());
    }
    
     @Test
    public void getEmail() {
         Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");

        String name = "migliorise@gmail.com";
        assertEquals("Check to see equal", name, c1.getEmail());
    }
    
     @Test
    public void getLicense() {
         Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");

        String name = "LFG7854";
        assertEquals("Check to see equal", name, c1.getLicense());
    }
    /*@Test
    public void getCustomer() {
         Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");

        String name = "Last Name: " + "Migliori" + " First Name: " + "Samantha"
                + "\nEmail Address: " + "migliorise@gmail.com"
                + "\nPlates on File: " + "LFG7854";
      
       
        assertEquals("Check to see equal", name, c1.getCustomer());
    }*/
    
}
