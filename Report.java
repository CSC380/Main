
import java.util.*;

public class Report {

private String month, day, year;
private String reportInfo;
private double payRoll;
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

/*public void searchReportInfo(String month, String day, String year) {

Report [] temp = new Report[reportList.size()];
temp = reportList.toArray(temp);

for (Report rp: temp) {
	if (rp.getMonth().equalsIgnoreCase(month)) {
		if (rp.getDay().equalsIgnoreCase(day)) {
			if (rp.getYear().equalsIgnoreCase(year)) {
System.out.println("Report for " + month + " " + day + " " + year + "\n"+ rp.getInfo());
				}
			}
		}
	}
}
*/

public void displayReport() {

System.out.println("Report for " + this.getMonth() + " " + this.getDay() + " " + this.getYear() + "\n"+ this.getInfo());
}
public void payRollSetUp(Employee empPay) {

double temp = empPay.calculatePayCheck();
payRoll = payRoll + temp;
}

public double payPeriod(GarageManager gm) {

return payRoll;
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

a1.searchReportInfo("March","10","1990");
}


}

