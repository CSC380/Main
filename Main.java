import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
//mport java.util.ArrayList;
//import java.util.List;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.Scanner;
import org.xml.sax.SAXException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
	Garage samsCo;
	Employee [] emps;
	GarageManager gms;
	Valet [] valets;
	SecurityGuard [] security;
	Customer [] customer;
	Report [] reports;
	
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//30
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler handler = new MyHandler();
            System.out.println("Enter the input file name:");
            String input = kb.nextLine();
            File f = new File(input);
            saxParser.parse(f, handler);
	    samsCo = handler.getGarage();
	    gms = handler.getGM();
	    valets = handler.getValets();
	    security = handler.getSecurityGs();
	    customer = handler.getCust();
	    reports = handler.getReports();
	    emps = handler.getEmployee();
//45
		samsCo.setGarageManager(gms);
		populateGMCustomers(customer,gms);
		populateGMEmployees(valets,security,gms);
		parkCustomerVehicle(customer,samsCo);
		samsCo.occupieGarage(customer);
		samsCo.occupieSpotsCustomer(customer);

		//gms.printCustomerList();
		gms.showStaff();

		new LoginScreen();

	 	LoginScreen.loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String id = LoginScreen.idText.getText();
		char [] pw = LoginScreen.passwordText.getPassword();
		if (loginCheck(emps,id,pw)) {
		LoginScreen.login.dispose();
		new MainMenuEmployee();
	}  else {
		JOptionPane.showMessageDialog(LoginScreen.login,"Wrong idNumber and/or password.","Login Error", JOptionPane.ERROR_MESSAGE);
		}

	}
});

		new CreateCustomer();

		CreateCustomer.confirmButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	Customer cust = new Customer(CreateCustomer.lastNameTextField.getText(),CreateCustomer.firstNameTextField.getText(),CreateCustomer.emailTextField.getText(),CreateCustomer.licenseTextField.getText());
		if (gms.addCustToList(cust)) {
		samsCo.addCustomerVehicle(cust);
JOptionPane.showMessageDialog(CreateCustomer.createCust,"The customer has been successfully added to the database and may now park.","Customer Registered", JOptionPane.INFORMATION_MESSAGE);
		} else {
JOptionPane.showMessageDialog(CreateCustomer.createCust,"Customer can not be added to database.","Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}
});

		new SearchCustomer();

		SearchCustomer.searchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String customerIdentity = gms.searchCustomer(SearchCustomer.custNameTextField.getText());
		int lg = customerIdentity.length() * 10;	
		SearchCustomer.displayCustInfo.setBounds(80,130,lg,100);	
		SearchCustomer.displayCustInfo.setText(customerIdentity);
		}
});

		new SearchStaff();

		SearchStaff.searchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String staffIdentity = gms.searchEmployee(SearchStaff.staffNameTextField.getText());
		int lg = staffIdentity.length() * 10;	
		SearchStaff.displayStaffInfo.setBounds(80,130,lg,100);	
		SearchStaff.displayStaffInfo.setText(staffIdentity);
		}
});

		new CreateStaff();

		CreateStaff.confirmButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
if (CreateStaff.lastNameTextField.getText().equals(null) || CreateStaff.firstNameTextField.getText().equals(null) || CreateStaff.idTextField.getText().equals(null) || CreateStaff.phoneTextField.getText().equals(null) || CreateStaff.staffPasswordTextField.getPassword().equals(null)) {
JOptionPane.showMessageDialog(CreateCustomer.createCust,"Employee can not be added to database.","Login Error", JOptionPane.ERROR_MESSAGE);
}
	if (CreateStaff.staffJobTextField.getText().equalsIgnoreCase("Valet")) {
		Valet vp = new Valet(CreateStaff.lastNameTextField.getText(),CreateStaff.firstNameTextField.getText(),CreateStaff.idTextField.getText(),CreateStaff.phoneTextField.getText(),CreateStaff.staffPasswordTextField.getPassword().toString());
		gms.addStaff(vp);
JOptionPane.showMessageDialog(CreateStaff.createStaff,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
	} else if (CreateStaff.staffJobTextField.getText().equalsIgnoreCase("Security Guard")) {
		SecurityGuard secG = new SecurityGuard(CreateStaff.lastNameTextField.getText(),CreateStaff.firstNameTextField.getText(),CreateStaff.idTextField.getText(),CreateStaff.phoneTextField.getText(),CreateStaff.staffPasswordTextField.getPassword().toString());
		gms.addStaff(secG);
JOptionPane.showMessageDialog(CreateStaff.createStaff,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
	} else if (CreateStaff.staffJobTextField.getText().equalsIgnoreCase("Garage Manager")) {
		GarageManager newGm = new GarageManager(CreateStaff.lastNameTextField.getText(),CreateStaff.firstNameTextField.getText(),CreateStaff.idTextField.getText(),CreateStaff.phoneTextField.getText(),CreateStaff.staffPasswordTextField.getPassword().toString());
		gms.addStaff(newGm);
JOptionPane.showMessageDialog(CreateStaff.createStaff,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
		} else {
JOptionPane.showMessageDialog(CreateCustomer.createCust,"Employee can not be added to database.","Login Error", JOptionPane.ERROR_MESSAGE);
		}
	}
});
 

	new ReportGUI();

	ReportGUI.confirmButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
	if (ReportGUI.dayLabel.getText().equals(null)) {
JOptionPane.showMessageDialog(ReportGUI.report,"The report cannot be added to the database.","Report Error", JOptionPane.INFORMATION_MESSAGE);
} else {
	Report newRep = new Report(ReportGUI.monthTextField.getText(),ReportGUI.dayTextField.getText(),ReportGUI.yearTextField.getText());
	newRep.setReportInfo(ReportGUI.reportInformationTextField.getText());
	gms.addReport(newRep);
JOptionPane.showMessageDialog(ReportGUI.report,"The report has been successfully added to the database.","Report Complete", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
});


	new GarageStatus();

/*
static JLabel statusLabel;
static JLabel statusOutLabel;
static JButton confirmButton;
static JButton mainMenuButton;
static JFrame garageOptions;
static JPanel garagePanel;
static JComboBox garageEntities;
*/

	GarageStatus.garageEntities.addItem("Maximum Spots");
	GarageStatus.garageEntities.addItem("Available Space");
	GarageStatus.garageEntities.addItem("Spots Taken");
	GarageStatus.garageEntities.addItem("Display Occupied Spots");
	GarageStatus.garageEntities.addItem("Garage Manager Info");

	GarageStatus.confirmButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	if (GarageStatus.garageEntities.getSelectedItem().equals("Maximum Spots")) {
		GarageStatus.statusOutLabel.setText(Integer.toString(samsCo.getMaxNumOfSpots()));
	} else if (GarageStatus.garageEntities.getSelectedItem().equals("Available Space")) {
		GarageStatus.statusOutLabel.setText(Integer.toString(samsCo.getAvailableSpots()));
	} else if (GarageStatus.garageEntities.getSelectedItem().equals("Spots Taken")) {
		GarageStatus.statusOutLabel.setText(Integer.toString(samsCo.spotsTaken()));
	} else if (GarageStatus.garageEntities.getSelectedItem().equals("Display Occupied Spots")) {
		GarageStatus.statusOutLabel.setText(samsCo.displayOccupiedSpots());
	} else if (GarageStatus.garageEntities.getSelectedItem().equals("Garage Manager Info")) {
		GarageStatus.statusOutLabel.setText(samsCo.getGarageManager().getEmployeeInfo());
		}
System.out.println(samsCo.displayOccupiedSpots());
	}

});



} catch (ParserConfigurationException | SAXException | IOException e) {
          //  e.printStackTrace();
        }
    }

public static void populateGMCustomers(Customer [] cust, GarageManager g) {

for (Customer c : cust) {
	g.addCustToList(c);
}

}

public static void populateGMEmployees(Valet [] v, SecurityGuard [] s, GarageManager g) {

for (int i = 0; i < v.length; i++) {
	if (v[i] != null) {
		g.addStaff(v[i]);
	}
}

for (int i = 0; i < s.length; i++) {
	if (s[i] != null) {
		g.addStaff(s[i]);
	}
}

}

public static void parkCustomerVehicle(Customer [] c, Garage g) {

for (Customer cust : c) {
	g.addCustomerVehicle(cust);
	}
}

public static boolean loginCheck(Employee [] emp, String id, char [] input) {

        boolean isCorrect = false;
        char [] correctPass; 

for (int i = 0; i < emp.length; i++) {
	if (emp[i].getID().equals(id)) {
		correctPass = emp[i].getPassword(id);
			if (input.length != correctPass.length) {
            			isCorrect = false;
				break;
			} else {
	 			if (Arrays.equals(input, correctPass)) {
              			isCorrect = true;
				break;
        			}
			}
		}	
	}	


 return isCorrect;
}


// stop clock
// create new report
// create new customer
// check hours worked
// search customer
// check schedule
// add garage methods to combo box
// search employee
// create new staff

}

