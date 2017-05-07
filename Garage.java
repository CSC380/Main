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
private Employee e1;

public Garage() {
}

public void setEmployee(Employee e){
e1 = e;
}

public Employee getEmployee(){

return e1;
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


public void occupieASpot(Customer c) {

for (int i = 0; i < spots.length; i++) {
	if (spots[i] == null) {
		spots[i] = c.getLicense();
		break;
		} 
	}


}

public void displayOccupiedSpots() {

for (int i = 0; i < spots.length; i++) {
	if (spots[i] != null) {
	 System.out.println("Spot " + i + " " + spots[i]);
	} 
}

}

public void occupieGarage(Customer [] c) {

for (Customer cust : c) {
	occupieASpot(cust);

}

}

public static void main(String[] args) {


Garage g = new Garage();
GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838","pj");
Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651","lk");
SecurityGuard g1 = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432","lkk");

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

//System.out.println(g.getMaxNumOfSpots());
//System.out.println(g.spotsTaken());
//System.out.println(g.getAvailableSpots());
//System.out.println(g.getCustLicense(b));
g.occupieASpot(c);
g.occupieASpot(b);
g.occupieASpot(d);
g.occupieASpot(f);
//g.occupieSpotsEmployee(a.getStaff());

g.displayOccupiedSpots();

}

}
