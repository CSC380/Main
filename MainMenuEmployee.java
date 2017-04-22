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

	panel.setLayout(null);
	
	clockInButton = new JButton("Clock In");
	clockInButton.setBounds(150,30,100,50);
	clockInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(mainMenuEMP,"You have sucessfully clocked in");
	}
});
	clockInButton.setMargin(new Insets(0,0,0,0));
	panel.add(clockInButton);
	 
	clockOutButton = new JButton("Clock Out");
	clockOutButton.setBounds(350,30,100,50);
	clockOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(mainMenuEMP,"You have successfully clocked out");
	}
});
	clockOutButton.setMargin(new Insets(0,0,0,0));
	panel.add(clockOutButton);
	
	buildReportButton = new JButton("Build Report");
	buildReportButton.setBounds(150,130,100,50);
	buildReportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new ReportGUI();
	}
});
	buildReportButton.setMargin(new Insets(0,0,0,0));
	panel.add(buildReportButton);

	createCustomerButton = new JButton("Create Customer");
	createCustomerButton.setBounds(350,130,100,50);
	createCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new CreateCustomer();
	}
});
	createCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(createCustomerButton);
 
	checkHoursWorkedButton = new JButton("Check Hours Worked");
	checkHoursWorkedButton.setBounds(150,230,100,50);
	checkHoursWorkedButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(mainMenuEMP,"Your Have worked " + "method");
	}
});
	checkHoursWorkedButton.setMargin(new Insets(0,0,0,0));
	panel.add(checkHoursWorkedButton);

	searchCustomerButton = new JButton("Search Customer");
	searchCustomerButton.setBounds(350,230,100,50);
	searchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new SearchCustomer();
	}
});
	searchCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchCustomerButton);

	checkScheduleButton = new JButton("Check Schedule");
	checkScheduleButton.setBounds(150,330,100,50);
	checkScheduleButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new EmployeeSchedule();
	}
});
	checkScheduleButton.setMargin(new Insets(0,0,0,0));
	panel.add(checkScheduleButton);

	signOutButton = new JButton("Sign Out");
	signOutButton.setBounds(250,530,100,50);
	signOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new LoginScreen();
	}
});	
	signOutButton.setMargin(new Insets(0,0,0,0));
	panel.add(signOutButton);

	garageStatusButton = new JButton("Garage Stats");
	garageStatusButton.setBounds(150,430,110,50);
	//garageStatusButton.setEnabled(false);
	garageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new GarageStatus();
	}
});	
	garageStatusButton.setMargin(new Insets(0,0,0,0));
	panel.add(garageStatusButton);

	searchEmployeeButton = new JButton("Employee Search");
	searchEmployeeButton.setBounds(350,430,100,50);
	//searchEmployeeButton.setEnabled(false);
	searchEmployeeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new SearchStaff();
	}
});	
	searchEmployeeButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchEmployeeButton);

	createStaffButton = new JButton("New Staff Member");
	createStaffButton.setBounds(350,330,100,50);
	//createStaffButton.setEnabled(false);
	createStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		mainMenuEMP.dispose();
		new CreateStaff();
	}
});	
	createStaffButton.setMargin(new Insets(0,0,0,0));
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
