

public class Valet extends Employee {

private Customer customerInfo;
private double hoursWorked, weeklyHours;
private final double wage = 15.00;

public Valet(String last, String first, String id, String phone) {

super(last,first,id,phone);
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

public double getHoursWorked(double ghw) {

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

public String scanLicensePlate(String licenseNum) {

return null;
}

public static void main(String[] args){

Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651");
Customer c1 = new Customer("Johnson", "Marie","mj@gmail.com", "JDH9384");

v1.setWeeklyHours(50);
System.out.println(v1.getWeeklyHours());
v1.setHoursWorked(23.5);
v1.calculatePayCheck();
System.out.println(v1.printPayCheck());
v1.setCustomerInfo(c1);
System.out.println(v1.getCustomerInfo().toString());
}


}
