


public class StoreManager extends Employee {

private final double salary = 50000;
private StoreAssociate storeAssociateInfo;

public StoreManager(String last, String first, String id, String phone) {

super(last,first,id,phone);
}

public double calculatePayCheck() {
return salary / 26;
}

public String printPayCheck() {
return f.format(calculatePayCheck());
}

public void setStoreAssociate(StoreAssociate sa) {

storeAssociateInfo = sa;
}

public StoreAssociate getAssociate() {

return storeAssociateInfo;
}





}
