import java.util.*;


public class Garage {

private int numOfSpots = 150;
private String[] spots = new String[numOfSpots];

private List<Customer> parkingSpaces = new ArrayList<>();
private List<Employee> employeeParking = new ArrayList<>();

private Customer customer;
private Valet valet;
private SecurityGuard securityGuard;
private GarageManager garageManager;

public Garage() {
}

public void setValet(Valet v) {

valet = v;
}

public Valet getValet() {

return valet;
}

public void setSecurity(SecurityGuard g) {

securityGuard = g;
}

public SecurityGuard getSecurity() {

return securityGuard;
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

public GarageManager getGarageManager() {

return garageManager;
}

public boolean addCustomerVehicle(Customer cust) {

if (parkingSpaces.size() + employeeParking.size() != numOfSpots) {
	System.out.println("The customer vehicle is now parked in the garage");
	return parkingSpaces.add(cust);
} else {
	System.out.println("There are no more available spaces");
	return false;
}
}

public void printVehicles() {

for (int i = 0; i < parkingSpaces.size(); i++) {
System.out.println(parkingSpaces.get(i).getLicense());
}

}

public boolean addEmployeeVehicle(Employee emp) {

if (employeeParking.size() + parkingSpaces.size() != numOfSpots) {
	System.out.println("The employee vehicle is now parked in the garage");
	return employeeParking.add(emp);
} else {
	System.out.println("There are no more available spaces");
	return false;
}

}

public void occupieSpotsCustomer(Customer[] customers) {

for (int j = 0; j < spots.length; j++) {
	for (int i = 0; i < customers.length; i++) {
		if (spots[j] == null) {
		spots[j] = customers[i].getLicense();
		} 
	}

}

}

/*public void occupieSpotsEmployee(Employee[] employees) {



}
*/

public void occupieGarage(Customer [] cust /*Employee [] emp*/) {

occupieSpotsCustomer(cust);
//occupieSpotsEmployee(emp);
}

public String displayOccupiedSpots() {

for (int i = 0; i < spots.length; i++) {
	if (spots[i] == null) {
	break;
} else {
return "Spot " + i + " " + spots[i];
}
}
return "No spots are being occupied";
}

public static void main(String[] args) {

/*
Garage g = new Garage();
GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651");
SecurityGuard g1 = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432");

g.setGarageManager(a);

Customer c = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
Customer d = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
Customer f = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdun378");

a.addCustToList(c);
a.addCustToList(b);
a.addCustToList(d);
a.addCustToList(f);

//a.addEmployeeToPark(a);
//a.addEmployeeToPark(v1);
//a.addEmployeeToPark(g1);

System.out.println(g.getMaxNumOfSpots());
System.out.println(g.spotsTaken());
System.out.println(g.getAvailableSpots());
//System.out.println(g.getCustLicense(b));
g.occupieGarage(a.listOfCustomers());
//g.occupieSpotsEmployee(a.getStaff());

g.displayOccupiedSpots();
*/
}

}
