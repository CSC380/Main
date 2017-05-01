
public class SecurityGuard extends Employee {

private final double wage = 18.00;
private final String mainGate = "Main Gate";
private String [] schedule = new String[7];
private boolean stateOfGate;

private double hoursWorked, weeklyHours;

private Customer customerInfo;
private SecurityGuard sc;

public SecurityGuard(String last, String first, String id, String phone, String pw) {

super(last,first,id,phone,pw);
}

public boolean setState(boolean state){

return stateOfGate = state;
}

// ternary operator, result = testCondition ? value1 : value2
public String gateStatus() {

return stateOfGate ? "open" : "closed"; 
}

public void setMainGateWorker(SecurityGuard mgw) {

sc = mgw;
}

public SecurityGuard getMainGateEMP() {

return sc;
}

public double calculatePayCheck() {

return hoursWorked * wage;
}

public String printPayCheck() {
return f.format(calculatePayCheck());
}

public void setWeeklyHours(double wh) {

weeklyHours = wh;
}

public double getWeeklyHours() {

return weeklyHours;
}

public void setHoursWorked(double hw) {

hoursWorked = hw;
}

public double getHoursWorked() {

return hoursWorked;
}

public void setCustomerInfo(Customer ci) {

customerInfo = ci;
}

public Customer getCustomerInfo() {

return customerInfo;
}

public void setSchedule(String mon, String tues, String wed, String thurs, String fri, String sat, String sun) {

schedule[0] = "Monday - " + mon;
schedule[1] = "Tuesday - " + tues;
schedule[2] = "Wednesday - " + wed;
schedule[3] = "Thursday - " + thurs;
schedule[4] = "Friday - " + fri;
schedule[5] = "Saturday - " + sat;
schedule[6] = "Sunday - " + sun;
}

public void displaySchedule() {

for (int i = 0; i < schedule.length; i++) {
	System.out.println(schedule[i]);
}

}

public static void main(String[] args) {
/*
SecurityGuard g = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432");
Customer c = new Customer("wolfomina", "tylon", "tywolf@gmail.com", "o98ncg78dc");

g.setState(false);
System.out.println("The main gate is " + g.gateStatus());
g.setMainGateWorker(g);
System.out.println(g.getMainGateEMP().toString());
g.setHoursWorked(72);
System.out.println(g.printPayCheck());
g.setCustomerInfo(c);
System.out.println(g.getCustomerInfo().toString());
System.out.println(g.getHoursWorked());
g.setWeeklyHours(40);
System.out.println(g.getWeeklyHours());
g.setState(true);
System.out.println("The main gate is " + g.gateStatus());
*/
}

}
