/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PG2Test;

import PG2.Valet;
import PG2.Customer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author xomin
 */
public class ValetTest {
    
    @Test
    public void getWeeklyHours(){
        Valet v1 = new Valet("Foster", "Will", "gv1234", "8457454254");
        v1.setWeeklyHours(30);
        assertEquals("Checks to see if weekly hours are set", 30, v1.getWeeklyHours(),0);
    }
    @Test
    public void geHoursWorked(){
        Valet v1 = new Valet("Foster", "Will", "gv1234", "8457454254");
        v1.setHoursWorked(30);
        assertEquals("Checks to see if hours worked  are set", 30, v1.getHoursWorked(0),0);
    }
    @Test
    public void calculatePaycheck(){
         Valet v1 = new Valet("Foster", "Will", "gv1234", "8457454254");
         v1.setHoursWorked(30);
         assertEquals(450,v1.calculatePayCheck(),0);
    }
    @Test
    public void printPaycheck(){
         Valet v1 = new Valet("Foster", "Will", "gv1234", "8457454254");
         v1.setHoursWorked(30);
         String s = "450.00";
         assertEquals(s, v1.printPayCheck());
    }
    @Test
    public void getCustomerInfo(){
        Customer c1 = new Customer("Migliori", "Samantha","migliorise@gmail.com", "LFG7854");
         Valet v1 = new Valet("Foster", "Will", "gv1234", "8457454254");
         
         v1.setCustomerInfo(c1);
         String name = "Last Name: " + "Migliori" + " First Name: " + "Samantha"
                + "\nEmail Address: " + "migliorise@gmail.com"
                + "\nPlates on File: " + "[LFG7854, KADKFJD, klajdf]";
         assertEquals(name, v1.getCustomerInfo());
        
    }
}
