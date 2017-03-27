// Customer class in which a customers attributes are recorded for the database

import java.util.*;

public class Customer {

private String lastName, firstName;
private String emailAddress;
private String licensePlate;

private List<String> licensePlates = new ArrayList<>();

private Garage myVehicle;
public Customer(String lastN, String firstN, String email, String license) {

lastName = lastN;
firstName = firstN;
emailAddress = email;
licensePlate = license;
licensePlates.add(licensePlate);


}


public  boolean addLicense(String license) {
return licensePlates.add(license);
}

public  boolean removeLicense(String license) {
if (!licensePlates.contains(license)) {
	return false;
} else {
	return licensePlates.remove(license);
}

}

public String getName() {
return lastName + ", " + firstName;
}

public String getFirstName() {

return firstName;
}

public String getLastName() {

return lastName;
}

public String getEmail() {
return emailAddress;
}

public String getLicense() {
return licensePlate;
}

public List<String> printPlates() {

return licensePlates;
}


public String getCustomer() {

return "Last Name: " + lastName + " First Name: " + firstName +
		    "\nEmail Address: " + emailAddress +
	            "\nPlates on File: " + licensePlates.toString();
}

@Override
public String toString() {

return getCustomer();
}

public static void main(String[] args) {

Customer c = new Customer("lone","wolf","loneWolf@gmail.com","thanks325");
Food food = null;

c.addToCart(food.Soda);
c.addToCart(food.Candy);
c.addToCart(food.Cake);

System.out.println(c.showMyCart());
System.out.println(c.cartPrice());

}

}
