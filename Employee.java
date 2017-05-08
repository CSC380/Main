import java.text.DecimalFormat;
import java.util.HashMap;

public abstract class Employee {

DecimalFormat f = new DecimalFormat("#,###.00");
private String lastName, firstName;
private String idNumber;
private String phoneNumber;
private String password;


private HashMap<String, String> map = new HashMap<>();

public Employee(String last, String first, String id, String phone, String pw) {

lastName = last;
firstName = first;
idNumber = id;
phoneNumber = phone;
password = pw;
map.put(idNumber,password);
}

public char [] getPassword(String id) {

String pwTemp = map.get(id);
return pwTemp.toCharArray();
}

public HashMap getMap() {

return map;
}

public String getLastName() {

return lastName;
}

public String getFirstName() {

return firstName;
}

public String getName() {

return lastName + " " + firstName;
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

public abstract String getType();
//public abstract Customer searchCustomer(String name);



}
