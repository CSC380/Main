import java.text.DecimalFormat;

public abstract class Employee {

DecimalFormat f = new DecimalFormat("#,###.00");
private String lastName, firstName;
private String idNumber;
private String phoneNumber;

public Employee(String last, String first, String id, String phone) {

lastName = last;
firstName = first;
idNumber = id;
phoneNumber = phone;
}

public String getLastName() {

return lastName;
}

public String getFirstName() {

return firstName;
}

public String getID() {

return idNumber;
}

public String getPhoneNumber() {

return phoneNumber;
}

public String getEmployeeInfo() {

return "Name:  " + lastName + ", " + firstName + "\tId Number: " + idNumber + "  Phone Number: " + phoneNumber;
}

@Override
public String toString() {

return getEmployeeInfo();
}

public abstract String printPayCheck();
public abstract double calculatePayCheck();



}
