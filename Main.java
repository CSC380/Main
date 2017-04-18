
import java.util.Scanner;

public class Main {

public static void main(String [] args) {
Garage myGarage = new Garage();
GarageManager a = new GarageManager("tom","hanks","23hiop","71602903838");
SecurityGuard g = new SecurityGuard("wolf", "lone", "90yftvsh", "9786254432");
Valet v = new Valet("Jones", "Karl", "0192837465", "9144434651");
Customer c1 = new Customer("lone","wolf","loneWolf@gmail.com","thanks325");
Customer c2 = new Customer("Johnson", "Marie","mj@gmail.com", "JDH9384");
Customer c3 = new Customer("wolfomina", "tylon", "tywolf@gmail.com", "o98ncg78dc");
Customer c4 = new Customer("Migs", "Tori", "khttgfdb@gmail.com", "hdu7364");

a.addStaff(a);
a.addStaff(g);
a.addStaff(v);
a.addCustToList(c1);
a.addCustToList(c2);
a.addCustToList(c3);
a.addCustToList(c4);
a.addEmployeeToPark(a);

LoginScreen login = new LoginScreen();
Scanner kb = new Scanner(System.in);
String id;
String password;
System.out.println("Welcome to database, Please follow the login process");
System.out.println("Enter ID #");
id = kb.nextLine();
System.out.println("Enter password");
password = kb.nextLine();


// for employee other than manager selection list
System.out.println("Welcome: " + a.scanID(id));
System.out.println("What would you like to do today?");
System.out.println("Menu options are below");
System.out.println("Clock in" +
		   "\nClock out" +
		   "\nCheck Schedule" +
		   "\nCheck hours worked" +
 		   "\nSearch Customer" +
		   "\nSign up Customer" +
		   "\nBuild report" +
	           "\nView previous report" +
                   "\nCheck previous shift worker" + 
	           "\nSign out" );
		    


String command;
command = kb.nextLine();

if (command.equalsIgnoreCase("Search Customer")) {
	System.out.println("Please Enter the customers name(Last,First) or license plate #");
	String customer;
	customer = kb.nextLine();
	System.out.println(a.searchCustomer(customer));
	} else if (command.equalsIgnoreCase("Sign up Customer")) {
	System.out.println("Please enter the customers Last Name, First name, Email, license Plate");
	Customer c5 = new Customer(kb.next(),kb.next().trim(),kb.next().trim(),kb.nextLine().trim());
	a.setCustomer(c5);
	System.out.println(a.getCustomer().toString());
	} else {
	System.out.println("Not a valid selection");
}


}

}
