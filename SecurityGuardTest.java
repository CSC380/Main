import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class SecurityGuardTest {

	@Test
	public void setStateTest() {
	
	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	assertTrue("Checking for the gate to be open",g1.setState(true));
	}

	@Test
	public void gateStatusTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	String closed = "closed";
	g1.setState(false);
	assertEquals("Checking for string output match",closed,g1.gateStatus());
	}

	@Test
	public void gateStatusOpenTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	String open = "open";
	g1.setState(true);
	assertEquals("Checking for string output match",open,g1.gateStatus());
	}
/*
	@Test
	public void setMainGateWorkerTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setMainGateWorker(g1);
	assertEquals("Checking for the main gate emp to have been set",g1,g1.getMainGateEMP());
	}
*/
	@Test
	public void getMainGateWorkerTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setMainGateWorker(g1);
	assertEquals("Checking for the main gate emp to have been set",g1,g1.getMainGateEMP());
	}

	@Test
	public void calculatePayCheckTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setHoursWorked(40);
	assertEquals("Checking for calculated paycheck",720,g1.calculatePayCheck(),.01);
	}

	@Test
	public void printPayCheckTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setHoursWorked(40);
	String pay = "720.00";
	assertEquals("Checking for calculated paycheck output match",pay,g1.printPayCheck());
	}
/*
	@Test
	public void setWeeklyHoursTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setWeeklyHours(40);
	double hours = 40;
	assertEquals("Checking for hours to match",hours,g1.getWeeklyHours(),0);
	}
*/
	@Test
	public void getWeeklyHoursTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setWeeklyHours(40);
	double hours = 40;
	assertEquals("Checking for hours to match",hours,g1.getWeeklyHours(),0);
	}
/*
	@Test
	public void setHoursWorkedTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setHoursWorked(40);
	double worked = 40;
	assertEquals("Checking for hours worked",worked,g1.getHoursWorked(),0);
	}
*/
	@Test
	public void getHoursWorkedTest() {

	SecurityGuard g1 = new SecurityGuard("Law","Thomas","8765556","34577776545");
	g1.setHoursWorked(40);
	double worked = 40;
	assertEquals("Checking for hours worked",worked,g1.getHoursWorked(),0);
	}
}

/*

public void setCustomerInfo(Customer ci) {

customerInfo = ci;
}

public Customer getCustomerInfo() {

return customerInfo;
}

public String scanLicensePlate(String licenseNum) {

return null;
}
*/
