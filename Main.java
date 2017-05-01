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
		//samsCo.occupieGarage(customer);
		//samsCo.occupieSpotsCustomer(customer);


		new LoginScreen();


	 	LoginScreen.loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String id = LoginScreen.idText.getText();
		char [] pw = LoginScreen.passwordText.getPassword();
		if (loginCheck(emps,id,pw)) {
		LoginScreen.allGUI.show(LoginScreen.controlPanel, "2");
	}  else {
		JOptionPane.showMessageDialog(LoginScreen.login,"Wrong idNumber and/or password.","Login Error", JOptionPane.ERROR_MESSAGE);
		}

	}
});


		LoginScreen.confirmCreateCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	Customer cust = new Customer(LoginScreen.lastNameTextField.getText(),LoginScreen.firstNameTextField.getText(),LoginScreen.emailTextField.getText(),LoginScreen.licenseTextField.getText());
		if (gms.addCustToList(cust)) {
		samsCo.addCustomerVehicle(cust);
		//samsCo.occupieASpot(cust);
JOptionPane.showMessageDialog(LoginScreen.login,"The customer has been successfully added to the database and may now park.","Customer Registered", JOptionPane.INFORMATION_MESSAGE);
		} else {
JOptionPane.showMessageDialog(LoginScreen.login,"Customer can not be added to database.","Authentication Error", JOptionPane.ERROR_MESSAGE);
		}
	}
});
 

		LoginScreen.searchSearchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String customerIdentity = gms.searchCustomer(LoginScreen.custNameTextField.getText());
		int lg = customerIdentity.length() * 10;	
		LoginScreen.displayCustInfo.setBounds(80,130,lg,100);	
		LoginScreen.displayCustInfo.setText(customerIdentity);
		}
});


		LoginScreen.searchEmployeeSearchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String staffIdentity = gms.searchEmployee(LoginScreen.searchStaffNameTextField.getText());
		int lg = staffIdentity.length() * 10;	
		LoginScreen.searchDisplayStaffInfo.setBounds(80,130,lg,100);	
		LoginScreen.searchDisplayStaffInfo.setText(staffIdentity);
		}
});


		LoginScreen.confirmCreateStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
if (LoginScreen.staffLastNameTextField.getText().equals(null) || LoginScreen.staffFirstNameTextField.getText().equals(null) || LoginScreen.idTextField.getText().equals(null) || LoginScreen.phoneTextField.getText().equals(null) || LoginScreen.staffPasswordTextField.getPassword().equals(null)) {
JOptionPane.showMessageDialog(LoginScreen.login,"Employee can not be added to database. Missing required Field","Login Error", JOptionPane.ERROR_MESSAGE);
}
	if (LoginScreen.staffJobTextField.getText().equalsIgnoreCase("Valet")) {
		Valet vp = new Valet(LoginScreen.staffLastNameTextField.getText(),LoginScreen.staffFirstNameTextField.getText(),LoginScreen.idTextField.getText(),LoginScreen.phoneTextField.getText(),LoginScreen.staffPasswordTextField.getPassword().toString());
		gms.addStaff(vp);
JOptionPane.showMessageDialog(LoginScreen.login,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
	} else if (LoginScreen.staffJobTextField.getText().equalsIgnoreCase("Security Guard")) {
		SecurityGuard secG = new SecurityGuard(LoginScreen.staffLastNameTextField.getText(),LoginScreen.staffFirstNameTextField.getText(),LoginScreen.idTextField.getText(),LoginScreen.phoneTextField.getText(),LoginScreen.staffPasswordTextField.getPassword().toString());
		gms.addStaff(secG);
JOptionPane.showMessageDialog(LoginScreen.login,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
	} else if (LoginScreen.staffJobTextField.getText().equalsIgnoreCase("Garage Manager")) {
		GarageManager newGm = new GarageManager(LoginScreen.staffLastNameTextField.getText(),LoginScreen.staffFirstNameTextField.getText(),LoginScreen.idTextField.getText(),LoginScreen.phoneTextField.getText(),LoginScreen.staffPasswordTextField.getPassword().toString());
		gms.addStaff(newGm);
JOptionPane.showMessageDialog(LoginScreen.login,"The Staff member has been successfully added to the database.","Employee Registered", JOptionPane.INFORMATION_MESSAGE);
		} else {
JOptionPane.showMessageDialog(LoginScreen.login,"Employee can not be added to database. Invalid Job Title","Field Error", JOptionPane.ERROR_MESSAGE);
		}
	}
});

	LoginScreen.confirmReportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
	if (LoginScreen.dayLabel.getText().equals(null)) {
JOptionPane.showMessageDialog(LoginScreen.login,"The report cannot be added to the database.","Field Error", JOptionPane.INFORMATION_MESSAGE);
} else {
	Report newRep = new Report(LoginScreen.monthTextField.getText(),LoginScreen.dayTextField.getText(),LoginScreen.yearTextField.getText());
	newRep.setReportInfo(LoginScreen.reportInformationTextField.getText());
	gms.addReport(newRep);
JOptionPane.showMessageDialog(LoginScreen.login,"The report has been successfully added to the database.","Report Complete", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
});

	LoginScreen.garageEntities.addItem("Maximum Spots");
	LoginScreen.garageEntities.addItem("Available Space");
	LoginScreen.garageEntities.addItem("Spots Taken");
	LoginScreen.garageEntities.addItem("Display Occupied Spots");
	LoginScreen.garageEntities.addItem("Garage Manager Info");

	LoginScreen.confirmGarageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	if (LoginScreen.garageEntities.getSelectedItem().equals("Maximum Spots")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.getMaxNumOfSpots()));
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Available Space")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.getAvailableSpots()));
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Spots Taken")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.spotsTaken()));
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Display Occupied Spots")) {
		//LoginScreen.statusOutLabel.setText(samsCo.displayOccupiedSpots());
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Garage Manager Info")) {
		LoginScreen.statusOutLabel.setText(samsCo.getGarageManager().getEmployeeInfo());
		}
//System.out.println(samsCo.displayOccupiedSpots());
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

