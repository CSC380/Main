

public class Report {

private String month, day, year;
private double moneyGained, payRoll;


public void payRollSetUp(Employee empPay) {

double temp = empPay.calculatePayCheck();
payRoll = payRoll + temp;
}

public double payPeriod(GarageManager gm) {

return payRoll;
}


public static void main(String[] args) {

GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
SecurityGuard g = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432");
Valet v1 = new Valet("Jones", "Karl", "0192837465", "9144434651");
Report jan = new Report();
Customer c = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");
Customer b = new Customer("M", "Ti", "khdb@gmail.com", "h017364");
Customer d = new Customer("g", "miles", "kmsnnngfdb@gmail.com", "hdu09opl64");
a.addCustToList(c);
a.addCustToList(b);
a.addCustToList(d);
g.setHoursWorked(72);
System.out.println(g.printPayCheck());
v1.setHoursWorked(23.5);
System.out.println(v1.printPayCheck());
System.out.println(a.printPayCheck());
jan.payRollSetUp(a);
jan.payRollSetUp(g);
jan.payRollSetUp(v1);

System.out.println(jan.payPeriod(a));
}


}

