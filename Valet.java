

public class Valet extends Employee {

private Customer customerInfo;


public Valet(String last, String first, String id, String phone, String pw) {

super(last,first,id,phone,pw);
}


public String getType() {

return "Valet";
}


public void setCustomerInfo(Customer c) {

customerInfo = c;
}

public Customer getCustomerInfo() {

return customerInfo;
}



}



}

