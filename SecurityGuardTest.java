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
