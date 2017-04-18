import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuEmployee {

static JButton clockInButton;
static JButton clockOutButton;
static JButton buildReportButton;
static JButton createCustomerButton;
static JButton checkHoursWorkedButton;
static JButton searchCustomerButton;
static JButton checkScheduleButton;
static JButton signOutButton;
static JButton garageStatusButton;
static JButton searchEmployeeButton;
static JButton createStaffButton;
static JFrame mainMenuEMP;
static JPanel mainPanel;

public MainMenuEmployee() {

createGUI();
}

	private static void createGUI() {

	mainMenuEMP = new JFrame("Main Menu");
	mainMenuEMP.setSize(600,600);
	mainMenuEMP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	mainPanel = new JPanel();
	mainMenuEMP.add(mainPanel);
	placeComponents(mainPanel);

	mainMenuEMP.setVisible(true);
}

	private static void placeComponents(JPanel panel) {
	
	clockInButton = new JButton("Clock In");
	clockInButton.setBounds(80,300,50,50);
	clockInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(mainMenuEMP,"You have sucessfully clocked in");
	}
});
	panel.add(clockInButton);
	 
	clockOutButton = new JButton("Clock Out");
	clockOutButton.setBounds(80,330,50,50);
	clockOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(mainMenuEMP,"You have successfully clocked out");
	}
});
	panel.add(clockOutButton);
	
	buildReportButton = new JButton("Build Report");
	buildReportButton.setBounds(80,360,50,50);
	//buildReportButton.addActionListener(new ActionListener() {
	//	public void actionPerformed(ActionEvent e) {
	//	MainMenuEmployee main = new MainMenuEmployee();
	//}
//});
	panel.add(buildReportButton);

	createCustomerButton = new JButton("Create Customer");
	createCustomerButton.setBounds(80,390,50,50);
	createCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new CreateCustomer();
	}
});
	panel.add(createCustomerButton);
 
	checkHoursWorkedButton = new JButton("Check Hours Worked");
	checkHoursWorkedButton.setBounds(140,300,50,50);
	checkHoursWorkedButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(mainMenuEMP,"Your Have worked " + "method");
	}
});
	panel.add(checkHoursWorkedButton);

	searchCustomerButton = new JButton("Search Customer");
	searchCustomerButton.setBounds(140,330,50,50);
	searchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new SearchCustomer();
	}
});
	panel.add(searchCustomerButton);

	checkScheduleButton = new JButton("Check Schedule");
	checkScheduleButton.setBounds(140,360,50,50);
	checkScheduleButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new EmployeeSchedule();
	}
});
	panel.add(checkScheduleButton);

	signOutButton = new JButton("Sign Out");
	signOutButton.setBounds(140,390,50,50);
	signOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new LoginScreen();
	}
});	
	panel.add(signOutButton);

	garageStatusButton = new JButton("Garage Stats");
	garageStatusButton.setBounds(60,60,50,50);
	garageStatusButton.setEnabled(false);
	garageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new GarageStatus();
	}
});	
	panel.add(garageStatusButton);

	searchEmployeeButton = new JButton("Employee Search");
	searchEmployeeButton.setBounds(70,70,50,50);
	searchEmployeeButton.setEnabled(false);
	searchEmployeeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new SearchStaff();
	}
});	
	panel.add(searchEmployeeButton);

	createStaffButton = new JButton("New Staff Member");
	createStaffButton.setBounds(100,300,50,50);
	createStaffButton.setEnabled(false);
	createStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new CreateStaff();
	}
});	
	panel.add(createStaffButton);
}

	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		createGUI();
            }
        });
    }



}
