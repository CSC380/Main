

public class Valet extends Employee {

private Customer customerInfo;
private double hoursWorked, weeklyHours;
private final double wage = 15.00;
private String[] schedule = new String[7];

public Valet(String last, String first, String id, String phone, String pw) {

super(last,first,id,phone,pw);
}

public void setWeeklyHours(double wh) {

weeklyHours = wh;
}

public double getWeeklyHours() {

return weeklyHours;
}

public String getType() {

return "Valet";
}

public void setHoursWorked(double hw) {

hoursWorked = hw;
}

public double getHoursWorked() {

return hoursWorked;
}

public double calculatePayCheck() {

return wage * hoursWorked;
}

public String printPayCheck() {

return f.format(calculatePayCheck());
}

public void setCustomerInfo(Customer c) {

customerInfo = c;
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

public static void main(String[] args){
/*
Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651");
Customer c1 = new Customer("Johnson", "Marie","mj@gmail.com", "JDH9384");

v1.setSchedule("7am-5pm","7am-5pm","4am-12pm","4am-12pm","7am-2;30pm","7am-5pm","7am-5pm");


v1.displaySchedule();
}
*/
}

}

