

public class StoreAssociate extends Employee {

private double hoursWorked, weeklyHours;
private final double wage = 12.00;
private Customer custOrder;

public StoreAssociate(String last, String first, String id, String phone) {

super(last,first,id,phone);
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

public double getHoursWorked(double ghw) {

return hoursWorked;
}

public String getCustOrder(Customer co) {
return null;
}

}
