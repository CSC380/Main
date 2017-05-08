
public class SecurityGuard extends Employee {


private final String mainGate = "Main Gate";
private boolean stateOfGate;


private Customer customerInfo;
private SecurityGuard sc;

public SecurityGuard(String last, String first, String id, String phone, String pw) {

super(last,first,id,phone,pw);
}

public boolean setState(boolean state){

return stateOfGate = state;
}

public String getType() {

return "SecurityGuard";
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



public void setCustomerInfo(Customer ci) {

customerInfo = ci;
}

public Customer getCustomerInfo() {

return customerInfo;
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
