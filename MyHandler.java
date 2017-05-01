import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

private Customer customer;
private GarageManager gManage;
private Valet valet;
private SecurityGuard sg;
private Report reports;
private Garage opening;

//private HashMap<String, String> map = new HashMap<>();
private ArrayList<Employee> emps = new ArrayList<>();
private ArrayList<Customer> cust = new ArrayList<>();
private ArrayList<Valet> valets = new ArrayList<>();
private ArrayList<SecurityGuard> securityGs = new ArrayList<>();
private ArrayList<Report> report = new ArrayList<>();


   @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if (qName.equalsIgnoreCase("Garage")) {
opening = new Garage();
} 
	else if (qName.equalsIgnoreCase("Customer")) {
customer = new Customer(attributes.getValue("firstName"),attributes.getValue("lastName"),attributes.getValue("emailAddress"),attributes.getValue("licensePlate"));
}
	 else if (qName.equalsIgnoreCase("Employee")) {
	if (attributes.getValue("type").equals("GarageManager")) {
gManage = new GarageManager(attributes.getValue("firstName"), attributes.getValue("lastName"), attributes.getValue("idNumber"), attributes.getValue("phoneNumber"),attributes.getValue("password"));
emps.add(gManage);
}	else if (attributes.getValue("type").equals("Valet")) {
valet = new Valet(attributes.getValue("firstName"), attributes.getValue("lastName"), attributes.getValue("idNumber"), attributes.getValue("phoneNumber"),attributes.getValue("password"));
emps.add(valet);
}	else if (attributes.getValue("type").equals("SecurityGuard")) {
sg = new SecurityGuard(attributes.getValue("firstName"), attributes.getValue("lastName"), attributes.getValue("idNumber"), attributes.getValue("phoneNumber"),attributes.getValue("password"));
emps.add(sg);
}
}
	else if (qName.equalsIgnoreCase("Report")) {
reports = new Report(attributes.getValue("month"),attributes.getValue("day"),attributes.getValue("year"));
reports.setReportInfo(attributes.getValue("reportInfo"));
} 

}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {

	if (qName.equalsIgnoreCase("Customer")) {
	cust.add(customer);
	//opening.addCustomerVehicle(customer);
}	if (qName.equalsIgnoreCase("Employee")) {
	//gManage.addStaff(gManage);
	//gManage.addStaff(valet);
	//gManage.addStaff(sg);
	valets.add(valet);
	securityGs.add(sg);
}	if (qName.equalsIgnoreCase("Report")) {
	report.add(reports);
}

}

/*
public GarageManager [] getManagers() {

GarageManager [] temp = garageMs.toArray(new GarageManager[garageMs.size()]);
return temp;
}
*/

public GarageManager getGM() {

return gManage;
}

public Valet [] getValets() {

Valet [] temp = valets.toArray(new Valet[valets.size()]);
return temp;
}

public SecurityGuard [] getSecurityGs() {

SecurityGuard [] temp = securityGs.toArray(new SecurityGuard[securityGs.size()]);
return temp;
}

public Customer [] getCust() {

Customer [] temp = cust.toArray(new Customer[cust.size()]);
return temp;
}

public Report [] getReports() {

Report [] temp = report.toArray(new Report[report.size()]);
return temp;
}

public Employee [] getEmployee() {

Employee [] temp = emps.toArray(new Employee[emps.size()]);
return temp;
}

public Garage getGarage() {

return opening;
}

//public HashMap getMapParsed() {

//return map;
//}

}
