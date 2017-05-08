import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class GarageManagerTest {

	@Test
	public void listOfCustomersTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Customer c1 = new Customer("tom","cassel","tomC@Gmail.com","rxd14");
	Customer c2 = new Customer("Sam","law","Law@Gmail.com","rxd87");
	g1.addCustToList(c1);
	g1.addCustToList(c2);
	Customer [] cust = new Customer[2];
	cust[0] = c1;
	cust[1] = c2;
        assertArrayEquals("checking for 2 Customers to be in list", cust, g1.listOfCustomers());
    }

	

/* 	@Test
	public void setCustomerTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Customer c1 = new Customer("sam","cassel","sam@gmail.com","rx44");
	g1.setCustomer(c1);
	assertEquals("Checking for boolean true, Customer Set",c1,g1.getCustomer());
	}
*/
	@Test
	public void getCustomerTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Customer c1 = new Customer("sam","cassel","sam@gmail.com","rx44");
	g1.setCustomer(c1);
	assertEquals("Checking for customer object equality",c1,g1.getCustomer());
	}

/* 	@Test
	public void setValetTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Valet v1 = new Valet("sam","cassel","6353534","555555555");
	g1.setValet(v1);
	assertEquals("Checking for boolean true, Customer Set",v1,g1.getValet());
	}
*/
	@Test
	public void getValetTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Valet v1 = new Valet("sam","cassel","6353534","555555555");
	g1.setValet(v1);
	assertEquals("Checking for valet object equality, Valet Set",v1,g1.getValet());
	}

/* 	@Test
	public void setSecurityTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Security s1 = new Security("sam","cassel","6353534","555555555");
	g1.setSecurity(s1);
	assertEquals("Checking for boolean true, Customer Set",s1,g1.getSecurity());
	}
*/
	@Test
	public void getSecurityTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	SecurityGuard s1 = new SecurityGuard("sam","cassel","6353534","555555555");
	g1.setSecurityGuard(s1);
	assertEquals("Checking for boolean true, Customer Set",s1,g1.getSecurityGuard());
	}

	@Test
	public void addCustToListTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Customer c1 = new Customer("sam","cassel","sam@gmail.com","rx44");
	assertTrue("Checking for the customer to have been added to the list",g1.addCustToList(c1));
	}

	@Test
	public void addEmployeeToParkTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	SecurityGuard s1 = new SecurityGuard("sam","cassel","6353534","555555555");
	assertTrue("Checking for the Employee to have been added to the list of employee spots",g1.addEmployeeToPark(s1));
	}

	@Test
	public void numOfRegisteredCustomersTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	Customer c1 = new Customer("sam","cassel","sam@gmail.com","rx44");
	Customer c2 = new Customer("Water","Law","law@gmail.com","rx437");
	g1.addCustToList(c1);
	g1.addCustToList(c2);
	assertEquals("Checking for the number of customers who are parked",2,g1.numOfRegisteredCustomers());
	}
	
	@Test
	public void numOfEmployeeParkedTest() {

	GarageManager g1 = new GarageManager("Monkey","Luffy","5420817","6467335555");
	SecurityGuard s1 = new SecurityGuard("sam","cassel","6353534","555555555");
	Valet v1 = new Valet("sam","Water","635ejg34","999555555");
	g1.addEmployeeToPark(s1);
	g1.addEmployeeToPark(v1);
	assertEquals("Checking for the number of Employee who are parked",2,g1.numOfEmployeeParked());
	}
/*
	@Test
	public void printCustomerListTest() {
	
	GarageManager g1 = new GarageManager("tom","hanks","23hiop","71602903838");
	Customer a = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
	Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
	Customer c = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
	g1.addCustToList(a);
	g1.addCustToList(b);
	g1.addCustToList(c);
	}
*/
	@Test
	public void getCustListTest() {
	
	GarageManager g1 = new GarageManager("tom","hanks","23hiop","71602903838");
	Customer a = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
	Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
	Customer c = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
	g1.addCustToList(a);
	g1.addCustToList(b);
	g1.addCustToList(c);
	List<Customer> mock = new ArrayList<>();
	mock.add(a);
	mock.add(b);
	mock.add(c);
	assertArrayEquals("Checking for list of customers to be accurate",mock.toArray(),g1.getCustList().toArray());
	}
	
}
