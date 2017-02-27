/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PG.Employee;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author xomin
 */
public class EmployeeTest {

    @Test
    public void getLicenseTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        e1.setLicense("HIJ2574");
        String l = "HIJ2574";
        assertEquals("checking for equality", l, e1.getLicense());
    }

    @Test
    public void setLicenseTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        assertTrue("checking for equality", e1.setLicense("HIJ2575"));

    }

    @Test
    public void getLicensePlates() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        e1.setLicense("HIJ2574");
        e1.setLicense("HIJ2575");
        e1.setLicense("HIJ2576");
        e1.setLicense("HIJ2577");
        String[] temp = new String[4];
        temp[0] = "HIJ2574";
        temp[1] = "HIJ2575";
        temp[2] = "HIJ2576";
        temp[3] = "HIJ2577";

        assertArrayEquals("checing for equality", temp, e1.getLicencePlates());
    }

    @Test
    public void printPlatesTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        e1.setLicense("HIJ2574");
        e1.setLicense("HIJ2575");
        e1.setLicense("HIJ2576");
        e1.setLicense("HIJ2577");

        List<String> test = Arrays.asList("HIJ2574", "HIJ2575", "HIJ2576", "HIJ2577");

        assertEquals("checking for equality", test, e1.printPlates());
    }

    @Test
    public void getLastNameTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        String name = "cassel";
        assertEquals("Check to see equal", name, e1.getLastName());
    }

    @Test
    public void getFirstNameTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        String name = "sam";
        assertEquals("Check to see equal", name, e1.getFirstName());
    }

    @Test
    public void getOccupationTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        String job = "Garage Manager";
        assertEquals("Check to see equal", job, e1.getOccupation());
    }

    @Test
    public void setHoursTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        e1.setHours(20.5);
        double hours = 20.5;

        assertEquals(hours, e1.getHours(), 0);

    }

    @Test
    public void getHoursTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        e1.setHours(20.5);
        double hours = 20.5;

        assertEquals(hours, e1.getHours(), 0);

    }

    @Test
    public void getIDTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");
        String temp = "AKD8374K";
        assertEquals("Check for equality", temp, e1.getID());
    }

    @Test
    public void getPaymentTypeTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        String temp = "Salary: 72,000.00";

        assertEquals("Check equality", temp, e1.getPaymentType());

        Employee e2 = new Employee("cassel", "sam", "Store Manager", "AKD8374K");

        String temp2 = "Salary: 42,000.00";

        assertEquals("Check equality", temp2, e2.getPaymentType());

        Employee e3 = new Employee("cassel", "sam", "Valet", "AKD8374K");

        String temp3 = "Hourly Rate: 15.00";

        assertEquals("Check equality", temp3, e3.getPaymentType());

        Employee e4 = new Employee("cassel", "sam", "Store Associate", "AKD8374K");

        String temp4 = "Hourly Rate: 12.50";

        assertEquals("Check equality", temp4, e4.getPaymentType());

        Employee e5 = new Employee("cassel", "sam", "Booth Sitter", "AKD8374K");

        String temp5 = "Hourly Rate: 18.00";

        assertEquals("Check equality", temp5, e5.getPaymentType());

    }

    @Test
    public void printPayCheckTest() {
        Employee e1 = new Employee("cassel", "sam", "Garage Manager", "AKD8374K");

        String temp = "PayCheck: 2,769.23";

        assertEquals("Check equality", temp, e1.printPayCheck(72000));

        Employee e2 = new Employee("cassel", "sam", "Store Manager", "AKD8374K");

        String temp2 = "PayCheck: 1,615.38";

        assertEquals("Check equality", temp2, e2.printPayCheck(42000));

        Employee e3 = new Employee("cassel", "sam", "Valet", "AKD8374K");
        e3.setHours(20.5);
        String temp3 = "PayCheck: 307.50";

        assertEquals("Check equality", temp3, e3.printPayCheck(15));

        Employee e4 = new Employee("cassel", "sam", "Store Associate", "AKD8374K");
        e4.setHours(20.5);
        String temp4 = "PayCheck: 256.25";

        assertEquals("Check equality", temp4, e4.printPayCheck(12.50));

        Employee e5 = new Employee("cassel", "sam", "Booth Sitter", "AKD8374K");

        e5.setHours(10);
        String temp5 = "PayCheck: 180.00";

        assertEquals("Check equality", temp5, e5.printPayCheck(18.00));

    }
}
