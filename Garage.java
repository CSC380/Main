import java.util.*;


public class Garage {

private int numOfSpots = 150;
private List<Customer> parkingSpaces = new ArrayList<>();
private List<Employee> employeeParking = new ArrayList<>();

private Customer customer;
private Valet valet;
private StoreAssociate storeAssociate;
private SecurityGuard securityGuard;
private StoreManager storeManager;
private GarageManager garageManager;

public Garage() {
}

public int getMaxNumOfSpots() {

return numOfSpots;
}

public int getAvailableSpots() {

return numOfSpots - spotsTaken();
}

public int spotsTaken() {

return garageManager.numOfRegisteredCustomers() + garageManager.numOfEmployeeParked();

}
 
public String getCustLicense(Customer c) {

return c.getLicense();
}

public void setGarageManager(GarageManager gm) {

garageManager = gm;
}

public boolean addCustomerVehicle(Customer cust) {

if (parkingSpaces.size() + employeeParking.size() != numOfSpots) {
	return parkingSpaces.add(cust);
} else {
	System.out.println("There are no more available spaces");
	return false;
}
}

public boolean addEmployeeVehicle(Employee emp) {

if (employeeParking.size() + parkingSpaces.size() != numOfSpots) {
	return employeeParking.add(emp);
} else {
	System.out.println("There are no more available spaces");
	return false;
}
}

public void occupieSpots() {}

public static void main(String[] args) {

Garage g = new Garage();
GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
g.setGarageManager(a);
Customer c = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
Customer d = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
a.addCustToList(c);
a.addCustToList(b);
a.addCustToList(d);
a.addEmployeeToPark(a);
System.out.println(g.getMaxNumOfSpots());
System.out.println(g.spotsTaken());
System.out.println(g.getAvailableSpots());
System.out.println(g.getCustLicense(b));
g.occupieSpots();
}

}
