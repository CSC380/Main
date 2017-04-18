
import java.util.*;

public class Report {


private String month, day, year;
private String reportInfo;
private double payRoll,custPay;
private List<Report> reportList = new ArrayList<>();

public Report(String mo, String d, String y) {

month = mo;
day = d;
year = y;
reportList.add(this);
}

public String getMonth() {

return month;
}

public String getDay() {

return day;
}

public String getYear() {

return year;
}

public String getInfo() {

return reportInfo;
}

public void setReportInfo(String i) {

reportInfo = i;
}

public Report[] getReportList() {

Report [] temp = new Report[reportList.size()];
temp = reportList.toArray(temp);
return temp;
}

public List getListOfReports() {

return reportList;
}


public void displayReport() {

System.out.println("Report for " + this.getMonth() + " " + this.getDay() + " " + this.getYear() + "\n"+ this.getInfo());
}

public void displayFinances(Employee[] emps, Customer[] customers) {

double finance;
double custIncome;
finance = payRollSetUp(emps);
custIncome = customerPay(customers);

System.out.println("PayRoll Overhead " + finance + "\nIncome " + custIncome);
}

public double payRollSetUp(Employee[] emp) {

double temp;
for (int i = 0; i< emp.length; i++) {
	temp = emp[i].calculatePayCheck();
	payRoll = payRoll + temp;
}

return payRoll;
}

public double customerPay(Customer[] customers) {

double temp;
for (int i = 0; i< customers.length; i++) {
	temp = customers[i].getPay();
	custPay = custPay + temp;
}

return custPay;
}

public static void main(String[] args) {

Report a = new Report("January","10","1990");
a.setReportInfo("On this day the customers were terrible to the valet");
Report b = new Report("February","10","1990");
b.setReportInfo("On this day the customers were fantastic to the valet");
Report c = new Report("March","10","1990");
c.setReportInfo("On this day the valet, Charles, was terrible to the customers");
Report d = new Report("April","10","1990");
d.setReportInfo("On this day I did not do my job and this place is great");

a.displayReport();
b.displayReport();
c.displayReport();
d.displayReport();

System.out.println("\n\n\n");

GarageManager a1 = new GarageManager("tom","hanks","23hiop","71602903838");
a1.addReport(a);
a1.addReport(b);
a1.addReport(c);
a1.addReport(d);

Customer c2 = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
Customer b2 = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
Customer d2 = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");

c2.setPay(79);
b2.setPay(3000);
d2.setPay(40);

SecurityGuard g = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432");
Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651");

a1.addCustToList(c2);
a1.addCustToList(b2);
a1.addCustToList(d2);

g.setHoursWorked(10);
v1.setHoursWorked(20);

a1.addStaff(g);
a1.addStaff(v1);
a1.addStaff(a1);

a1.searchReportInfo("March","10","1990");
a.displayFinances(a1.getStaff(),a1.listOfCustomers());
}


}

