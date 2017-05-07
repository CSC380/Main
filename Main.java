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
		buildGMReports(reports,gms);
		parkCustomerVehicle(customer,samsCo);
		samsCo.occupieGarage(customer);


		new LoginScreen();

		buildCustCombo(customer,LoginScreen.custBox);
		buildEMPCombo(emps,LoginScreen.staffBox);
		buildGarageCombo(customer,LoginScreen.garageSpotsTaken);
		buildReviewReportCombo(reports,LoginScreen.comboReviewBox);
		buildGarageOptionsCombo(LoginScreen.garageEntities);


	 	LoginScreen.loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String id = LoginScreen.idText.getText();
		char [] pw = LoginScreen.passwordText.getPassword();
		if (loginCheck(emps,id,pw)) {
		String loggedInName = gms.scanID(id);
		Employee loggedON = gms.searchEmployee(loggedInName);
			if (!loggedON.getType().equalsIgnoreCase("GarageManager")) {
		LoginScreen.createStaffButton.setEnabled(false);
		LoginScreen.allGUI.show(LoginScreen.controlPanel, "2");
		LoginScreen.resetComponentsLoginScreen(LoginScreen.loginMenu);
		}
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
		samsCo.occupieASpot(cust);
		LoginScreen.garageSpotsTaken.addItem(cust.getLicense());
JOptionPane.showMessageDialog(LoginScreen.login,"The customer has been successfully added to the database and may now park.","Customer Registered", JOptionPane.INFORMATION_MESSAGE);
LoginScreen.resetComponentsCreateCustomer(LoginScreen.createCustomer);
		} else {
JOptionPane.showMessageDialog(LoginScreen.login,"Customer can not be added to database.","Authentication Error", JOptionPane.ERROR_MESSAGE);
		}
	}
});
 

		LoginScreen.searchSearchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Customer cIdentity = gms.searchCustomer(LoginScreen.custNameTextField.getText());
	if (cIdentity != null) {
		LoginScreen.searchCustNameTextField.setText(cIdentity.getName());
		LoginScreen.searchCustEmailTextField.setText(cIdentity.getEmail());
		LoginScreen.searchCustLicenseTextField.setText(cIdentity.getLicense());

		LoginScreen.searchCustNameLabel.setVisible(true);
		LoginScreen.searchCustNameTextField.setVisible(true);
		LoginScreen.searchCustEmailLabel.setVisible(true);
		LoginScreen.searchCustEmailTextField.setVisible(true);
		LoginScreen.searchCustLicenseLabel.setVisible(true);
		LoginScreen.searchCustLicenseTextField.setVisible(true);
		LoginScreen.resetComponentsSearchCustomer(LoginScreen.searchCustomer);
	}	else { 
JOptionPane.showMessageDialog(LoginScreen.login,"Customer can not be found in database.","Alert", JOptionPane.WARNING_MESSAGE);

	}

		}
});


		LoginScreen.searchEmployeeSearchButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Employee sIdentity = gms.searchEmployee(LoginScreen.searchStaffNameTextField.getText());
	if (sIdentity != null) {
		LoginScreen.searchEMPNameTextField.setText(sIdentity.getName());
		LoginScreen.searchEMPIDTextField.setText(sIdentity.getID());
		LoginScreen.searchEMPPhoneTextField.setText(sIdentity.getPhoneNumber());
		LoginScreen.searchEMPPositionTextField.setText("");

		LoginScreen.searchEMPNameLabel.setVisible(true);
		LoginScreen.searchEMPNameTextField.setVisible(true);
		LoginScreen.searchEMPIDLabel.setVisible(true);
		LoginScreen.searchEMPIDTextField.setVisible(true);
		LoginScreen.searchEMPPhoneLabel.setVisible(true);
		LoginScreen.searchEMPPhoneTextField.setVisible(true);
		LoginScreen.searchEMPPositionLabel.setVisible(true);
		LoginScreen.searchEMPPositionTextField.setVisible(true);
		LoginScreen.resetComponentsSearchEMP(LoginScreen.searchEMP);
	} else {
JOptionPane.showMessageDialog(LoginScreen.login,"Employee can not be found in database.","Alert", JOptionPane.WARNING_MESSAGE);
	
	}
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
LoginScreen.resetComponentsCreateEMP(LoginScreen.createEMP);
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
	LoginScreen.comboReviewBox.addItem(newRep.getCredentials());
JOptionPane.showMessageDialog(LoginScreen.login,"The report has been successfully added to the database.","Report Complete", JOptionPane.INFORMATION_MESSAGE);
		}	
LoginScreen.resetComponentsBuildReport(LoginScreen.buildReport);
	}
});

	
	LoginScreen.confirmGarageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	if (LoginScreen.garageEntities.getSelectedItem().equals("Maximum Spots")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.getMaxNumOfSpots()));
//LoginScreen.resetComponentsGarageStatus(LoginScreen.garageStatus);
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Available Space")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.getAvailableSpots()));
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Spots Taken")) {
		LoginScreen.statusOutLabel.setText(Integer.toString(samsCo.spotsTaken()));
//LoginScreen.resetComponentsGarageStatus(LoginScreen.garageStatus);
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Display Occupied Spots")) {
		LoginScreen.garageSpotsTaken.setVisible(true);
//LoginScreen.resetComponentsGarageStatus(LoginScreen.garageStatus);
	} else if (LoginScreen.garageEntities.getSelectedItem().equals("Garage Manager Info")) {
		LoginScreen.statusOutLabel.setText(samsCo.getGarageManager().getEmployeeInfo());
//LoginScreen.resetComponentsGarageStatus(LoginScreen.garageStatus);	
	}
	}

  });


	LoginScreen.custBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Customer cIdentity = gms.searchCustomer((String) LoginScreen.custBox.getSelectedItem());
		LoginScreen.allCustNameTextField.setText(cIdentity.getName());
		LoginScreen.allCustEmailTextField.setText(cIdentity.getEmail());
		LoginScreen.allCustLicenseTextField.setText(cIdentity.getLicense());
		
		LoginScreen.custNameLabel.setVisible(true);
		LoginScreen.allCustNameTextField.setVisible(true);
		LoginScreen.custAllCustEmailLabel.setVisible(true);
		LoginScreen.allCustEmailTextField.setVisible(true);
		LoginScreen.custAllCustLicenseLabel.setVisible(true);
		LoginScreen.allCustLicenseTextField.setVisible(true);
		}
  });

	LoginScreen.staffBox.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Employee eIdentity = gms.searchEmployee((String)LoginScreen.staffBox.getSelectedItem());

		LoginScreen.allStaffNameTextField.setText(eIdentity.getName());
		LoginScreen.allStaffIDTextField.setText(eIdentity.getID());
		LoginScreen.allStaffPhoneTextField.setText(eIdentity.getPhoneNumber());
		LoginScreen.allStaffPositionTextField.setText("");
		LoginScreen.allStaffPositionTextField.setVisible(true);
		LoginScreen.staffAllStaffNameLabel.setVisible(true);
		LoginScreen.allStaffNameTextField.setVisible(true);
		LoginScreen.staffAllStaffIDLabel.setVisible(true);
		LoginScreen.allStaffIDTextField.setVisible(true);
		LoginScreen.staffAllStaffPhoneLabel.setVisible(true);
		LoginScreen.allStaffPhoneTextField.setVisible(true);
		LoginScreen.allStaffPositionLabel.setVisible(true);
		LoginScreen.resetComponentsAllCust(LoginScreen.allCust);
		}
  });

		LoginScreen.confirmReviewReportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		Report rIdentity = gms.searchReport((String)LoginScreen.comboReviewBox.getSelectedItem());

		LoginScreen.monthReviewTextField.setText(rIdentity.getMonth());
		LoginScreen.dayReviewTextField.setText(rIdentity.getDay());
		LoginScreen.yearReviewTextField.setText(rIdentity.getYear());
		LoginScreen.reportInformationReviewTextField.setText(rIdentity.getInfo());
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

g.addStaff(g);

}

public static void parkCustomerVehicle(Customer [] c, Garage g) {

for (Customer cust : c) {
	g.addCustomerVehicle(cust);
	}
}

public static void buildGMReports(Report [] r, GarageManager gm) {

for (Report report : r) {
	gm.addReport(report);
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

public static void buildCustCombo(Customer [] cust, JComboBox cb) {

for (Customer c : cust) {
	cb.addItem(c.getName());
}
	cb.setSelectedIndex(-1);
}

public static void buildEMPCombo(Employee [] emp, JComboBox cb) {

for (Employee e : emp) {
	cb.addItem(e.getName());
}
	cb.setSelectedIndex(-1);

}

public static void buildGarageCombo(Customer [] cust, JComboBox cb) {

for (Customer c : cust) {
	cb.addItem(c.getLicense());
}
	cb.setSelectedIndex(-1);

}

public static void buildReviewReportCombo(Report [] r, JComboBox cb) {

for (Report report : r) {
	cb.addItem(report.getReportCredentials());
}
	cb.setSelectedIndex(-1);

}

public static void buildGarageOptionsCombo(JComboBox cb) {

cb.addItem("Maximum Spots");
cb.addItem("Available Space");
cb.addItem("Spots Taken");
cb.addItem("Display Occupied Spots");
cb.addItem("Garage Manager Info");


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

