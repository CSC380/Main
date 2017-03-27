
import java.util.*;

public class GarageManager extends Employee {

private final double salary = 120000;
private Customer customerInfo;
private Valet valetInfo;
private SecurityGuard securityGuardInfo;
private List<Customer> numOfCustomers = new ArrayList<>();
private List<Employee> numOfEmployeeParking = new ArrayList<>();
public GarageManager(String last, String first, String id, String phone) {

super(last,first,id,phone);
}

public Customer[] listOfCustomers() {

Customer [] temp = numOfCustomers.toArray(new Customer[numOfCustomers.size()]);
return temp;
}

public double calculatePayCheck() {

return salary / 26;
}

public String printPayCheck() {

return f.format(calculatePayCheck());
}

public void setCustomer(Customer c) {

customerInfo = c;
}

public Customer getCustomer() {

return customerInfo;
}

public void setValet(Valet v) {

valetInfo = v;
}

public Valet getValet() {

return valetInfo;
}


public void setSecurityGuard(SecurityGuard sg) {

securityGuardInfo = sg;
}

public SecurityGuard getSecurityGuard() {

return securityGuardInfo;
}

public String scanLicensePlate(String licenseNum) {

return null;
}

public boolean addCustToList(Customer atl) {

return numOfCustomers.add(atl);
}

public boolean addEmployeeToPark(Employee emp) {

return numOfEmployeeParking.add(emp);
}

public int numOfRegisteredCustomers() {

return numOfCustomers.size();
}

public int numOfEmployeeParked() {

return numOfEmployeeParking.size();
}

public void printCustomerList() {

System.out.println(numOfCustomers);
}

public List<Customer> getCustList() {

return numOfCustomers;
}

public static void main(String[] args) {

GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
Customer c = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
Customer d = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
a.addCustToList(c);
a.addCustToList(b);
a.addCustToList(d);
System.out.println(a.numOfRegisteredCustomers());
a.printCustomerList();
System.out.println(a.getLastName());
System.out.println(a.getFirstName());
System.out.println(a.getID());
System.out.println(a.getEmployeeInfo());
System.out.println(a.printPayCheck());
System.out.println(a.getPhoneNumber());
a.setCustomer(c);
System.out.println(a.getCustomer().toString());

}


}
