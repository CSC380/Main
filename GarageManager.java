
import java.util.*;

public class GarageManager extends Employee {

private final double salary = 120000;
private Customer customerInfo;
private Valet valetInfo;
private SecurityGuard securityGuardInfo;
private Report reportInformation;

private List<Customer> numOfCustomers = new ArrayList<>();
private List<Employee> numOfEmployeeParking = new ArrayList<>();
private List<Employee> staffMembers = new ArrayList<>();
private List<Report> reports = new ArrayList<>();

public GarageManager(String last, String first, String id, String phone) {

super(last,first,id,phone);
}

public boolean addReport(Report rp) {

return reports.add(rp);
}

public void setReport(Report rp) {

reportInformation = rp;
}

public Report getReportInfo() {

return reportInformation;
}

public void searchReportInfo(String month, String day, String year) {



Report [] temp = new Report[reports.size()];
temp = reports.toArray(temp);

for (Report rp: temp) {
	if (rp.getMonth().equalsIgnoreCase(month)) {
		if (rp.getDay().equalsIgnoreCase(day)) {
			if (rp.getYear().equalsIgnoreCase(year)) {
				rp.displayReport();
				}
			}
		}
	}
}


public boolean addStaff(Employee o) {

return staffMembers.add(o);
}

public void showStaff() {

System.out.println(staffMembers);
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

public String scanID(String id) {

if (id != null) {
	for (Employee emp: staffMembers) {
		if (emp.getID().equals(id)) {
			return emp.getFirstName() + " " + emp.getLastName();
			}
		}
	}
return "Employee not apart of the staff";
}

public String searchCustomer(String name) {

for (Customer cust: numOfCustomers) {
	if (cust.getName().equalsIgnoreCase(name)) {
		return cust.getCustomer();
	}
}
return "That customer does not exist inside the database";
}
public static void main(String[] args) {

GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
a.addStaff(a);
/*
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
*/
System.out.println(a.scanID("23hiop"));

}


}
