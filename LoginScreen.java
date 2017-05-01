import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen {

static JButton loginButton;
static JButton closeButton;
static JLabel idLabel;
static JLabel passwordLabel;
static JTextField idText;
static JPasswordField passwordText;
static JFrame login;
static JPanel controlPanel = new JPanel();

static JPanel loginMenu = new JPanel();
static JPanel mainMenu = new JPanel();
static JPanel buildReport = new JPanel();
static JPanel createCustomer = new JPanel();
static JPanel searchCustomer = new JPanel();
static JPanel checkSchedule = new JPanel();
static JPanel garageStatus = new JPanel();
static JPanel searchEMP = new JPanel();
static JPanel createEMP = new JPanel();
static JPanel allCust = new JPanel();
static JPanel allEMPS = new JPanel();

// main menu
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

// all customers
static JLabel custInfoLabel;
static JLabel custBoxLabel;
static JComboBox custBox;
static JButton mainMenuAllCustomersButton;

//allStaff
static JLabel staffInfoLabel;
static JLabel staffBoxLabel;
static JComboBox staffBox;
static JButton mainMenuAllStaffButton;

//createCustomer
static JLabel custFirstNameLabel;
static JLabel custLastNameLabel;
static JLabel custEmailLabel;
static JLabel custPlateLabel;
static JTextField firstNameTextField;
static JTextField lastNameTextField;
static JTextField emailTextField;
static JTextField licenseTextField;
static JButton confirmCreateCustomerButton;
static JButton cancelCreateCustomerButton;

//CreateStaff
static JLabel staffFirstNameLabel;
static JLabel staffLastNameLabel;
static JLabel staffIDLabel;
static JLabel staffPhoneLabel;
static JLabel staffJobLabel;
static JLabel staffPasswordLabel;

static JTextField staffFirstNameTextField;
static JTextField staffLastNameTextField;
static JTextField idTextField;
static JTextField phoneTextField;
static JTextField staffJobTextField;
static JPasswordField staffPasswordTextField;

static JButton confirmCreateStaffButton;
static JButton cancelCreateStaffButton;

// EmployeeSchedule
static JLabel scheduleLabel;
static JButton mainMenuEmployeeScheduleButton;

//GarageStatus
static JLabel statusLabel;
static JLabel statusOutLabel;
static JButton confirmGarageStatusButton;
static JButton mainMenuGarageStatusButton;
static JComboBox garageEntities;

//SearchCustomer
static JLabel custName;
static JTextField custNameTextField;
static JLabel displayCustInfo;
static JButton searchSearchCustomerButton;
static JButton mainMenuSearchCustomerButton;

//BuilReport
static JLabel monthLabel;
static JLabel dayLabel;
static JLabel yearLabel;
static JTextField monthTextField;
static JTextField dayTextField;
static JTextField yearTextField;
static JTextField reportInformationTextField;
static JButton confirmReportButton;
static JButton mainMenuReportButton;

//Search Employee
static JLabel searchStaffName;
static JTextField searchStaffNameTextField;
static JLabel searchDisplayStaffInfo;
static JButton searchEmployeeSearchButton;
static JButton searchEmployeeMainMenuButton;

static CardLayout allGUI = new CardLayout();


public LoginScreen() {

createGUI();
}

    private static void createGUI() {

	login = new JFrame("Login Screen");
	login.setSize(700,700);
	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	controlPanel.setLayout(allGUI);
	controlPanel.add(loginMenu, "1");
	controlPanel.add(mainMenu, "2");
	controlPanel.add(buildReport, "3");
	controlPanel.add(createCustomer, "4");
	controlPanel.add(searchCustomer, "5");
	controlPanel.add(checkSchedule, "6");
	controlPanel.add(garageStatus, "7");
	controlPanel.add(searchEMP, "8");
	controlPanel.add(createEMP, "9");
	controlPanel.add(allCust, "10");
	controlPanel.add(allEMPS, "11");



	placeComponentsLoginScreen(loginMenu);
	placeComponentsMainMenu(mainMenu);
	placeComponentsAllCust(allCust);
	placeComponentsAllEMPS(allEMPS);
	placeComponentsCreateCustomer(createCustomer);
	placeComponentsCreateEMP(createEMP);
	placeComponentsCheckSchedule(checkSchedule);
	placeComponentsGarageStatus(garageStatus);
	placeComponentsSearchCustomer(searchCustomer);
	placeComponentsBuildReport(buildReport);	
	placeComponentsSearchEMP(searchEMP);

	allGUI.show(controlPanel, "1");

	login.add(controlPanel);
	//login.pack();
	login.setVisible(true);	
}

    private static void placeComponentsLoginScreen(JPanel panel) {

        panel.setLayout(null);

        idLabel = new JLabel("ID #");
        idLabel.setBounds(10,20,80,25);
        panel.add(idLabel);

        idText = new JTextField(20);
        idText.setBounds(100,20,165,25);
        panel.add(idText);


        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);


        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);


        loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
	panel.add(loginButton);

	closeButton = new JButton("close");
	closeButton.setBounds(100, 80, 80, 25);
	closeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
});
	panel.add(closeButton);
}

	private static void placeComponentsMainMenu(JPanel panel) {

	panel.setLayout(null);
	
	clockInButton = new JButton("Clock In");
	clockInButton.setBounds(150,30,100,50);
	clockInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(login,"You have sucessfully clocked in");
	}
});
	clockInButton.setMargin(new Insets(0,0,0,0));
	panel.add(clockInButton);
	 
	clockOutButton = new JButton("Clock Out");
	clockOutButton.setBounds(350,30,100,50);
	clockOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	JOptionPane.showMessageDialog(login,"You have successfully clocked out");
	}
});
	clockOutButton.setMargin(new Insets(0,0,0,0));
	panel.add(clockOutButton);
	
	buildReportButton = new JButton("Build Report");
	buildReportButton.setBounds(150,130,100,50);
	buildReportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "3");
	}
});
	buildReportButton.setMargin(new Insets(0,0,0,0));
	panel.add(buildReportButton);

	createCustomerButton = new JButton("Create Customer");
	createCustomerButton.setBounds(350,130,100,50);
	createCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "4");
	}
});
	createCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(createCustomerButton);
 
	checkHoursWorkedButton = new JButton("Check Hours Worked");
	checkHoursWorkedButton.setBounds(150,230,100,50);
	checkHoursWorkedButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(login,"Your Have worked " + "method");
	}
});
	checkHoursWorkedButton.setMargin(new Insets(0,0,0,0));
	panel.add(checkHoursWorkedButton);

	searchCustomerButton = new JButton("Search Customer");
	searchCustomerButton.setBounds(350,230,100,50);
	searchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "5");
	}
});
	searchCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchCustomerButton);

	checkScheduleButton = new JButton("Check Schedule");
	checkScheduleButton.setBounds(150,330,100,50);
	checkScheduleButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "6");
	}
});
	checkScheduleButton.setMargin(new Insets(0,0,0,0));
	panel.add(checkScheduleButton);

	signOutButton = new JButton("Sign Out");
	signOutButton.setBounds(250,530,100,50);
	signOutButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "1");
	}
});	
	signOutButton.setMargin(new Insets(0,0,0,0));
	panel.add(signOutButton);

	garageStatusButton = new JButton("Garage Stats");
	garageStatusButton.setBounds(150,430,110,50);
	garageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "7");
	}
});	
	garageStatusButton.setMargin(new Insets(0,0,0,0));
	panel.add(garageStatusButton);

	searchEmployeeButton = new JButton("Employee Search");
	searchEmployeeButton.setBounds(350,430,100,50);
	searchEmployeeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "8");
	}
});	
	searchEmployeeButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchEmployeeButton);

	createStaffButton = new JButton("New Staff Member");
	createStaffButton.setBounds(350,330,100,50);
	createStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "9");
	}
});	
	createStaffButton.setMargin(new Insets(0,0,0,0));
	panel.add(createStaffButton);
}
	public static void placeComponentsAllCust(JPanel panel) {

	panel.setLayout(null);

	custBoxLabel = new JLabel("Customers");
	custBoxLabel.setBounds(30,30,150,50);
	panel.add(custBoxLabel);

	custInfoLabel = new JLabel();
	custInfoLabel.setBounds(250,300,60,60);
	panel.add(custInfoLabel);

	custBox = new JComboBox();
	custBox.setBounds(185,43,300,30);
	panel.add(custBox);

	mainMenuAllCustomersButton = new JButton("Main Menu");
	mainMenuAllCustomersButton.setBounds(250,370,100,50);
	mainMenuAllCustomersButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	mainMenuAllCustomersButton.setMargin(new Insets(0,0,0,0));
	panel.add(mainMenuAllCustomersButton);

}

	public static void placeComponentsAllEMPS(JPanel panel) {

	panel.setLayout(null);
	
	staffBoxLabel = new JLabel("Staff");
	staffBoxLabel.setBounds(30,30,50,50);
	panel.add(staffBoxLabel);

	staffInfoLabel = new JLabel();
	staffInfoLabel.setBounds(250,300,60,60);
	panel.add(staffInfoLabel);

	staffBox = new JComboBox();
	staffBox.setBounds(85,43,300,30);
	panel.add(staffBox);

	mainMenuAllStaffButton = new JButton("Main Menu");
	mainMenuAllStaffButton.setBounds(250,370,100,50);
	mainMenuAllStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	mainMenuAllStaffButton.setMargin(new Insets(0,0,0,0));
	panel.add(mainMenuAllStaffButton);

}

	private static void placeComponentsCreateCustomer(JPanel panel) {

	panel.setLayout(null);

	custFirstNameLabel = new JLabel("Fist Name");
	custFirstNameLabel.setBounds(60,60,100,50);
	panel.add(custFirstNameLabel);

	custLastNameLabel = new JLabel("LastName");
	custLastNameLabel.setBounds(330,60,100,50);
	panel.add(custLastNameLabel);

	custEmailLabel = new JLabel("Email Address");
	custEmailLabel.setBounds(60,150,100,50);
	panel.add(custEmailLabel);
	
	custPlateLabel = new JLabel("License #");
	custPlateLabel.setBounds(60,250,100,50);
	panel.add(custPlateLabel);
	
	firstNameTextField = new JTextField();
	firstNameTextField.setBounds(160,70,130,35);
	panel.add(firstNameTextField);

	lastNameTextField = new JTextField();
	lastNameTextField.setBounds(430,70,130,35);
	panel.add(lastNameTextField);
	
	emailTextField = new JTextField();
	emailTextField.setBounds(180,158,160,35);
	panel.add(emailTextField);

	licenseTextField = new JTextField();
	licenseTextField.setBounds(160,258,160,35);
	panel.add(licenseTextField);

	confirmCreateCustomerButton = new JButton("Confirm");
	confirmCreateCustomerButton.setBounds(150,400,100,50);
	confirmCreateCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(confirmCreateCustomerButton);

	cancelCreateCustomerButton = new JButton("Cancel");
	cancelCreateCustomerButton.setBounds(350,400,100,50);
	cancelCreateCustomerButton.setMargin(new Insets(0,0,0,0));
	cancelCreateCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
		
	}
});
	panel.add(cancelCreateCustomerButton);

}

	private static void placeComponentsCreateEMP(JPanel panel) {

	panel.setLayout(null);

	staffFirstNameLabel = new JLabel("Fist Name");
	staffFirstNameLabel.setBounds(60,60,100,50);
	panel.add(staffFirstNameLabel);

	staffLastNameLabel = new JLabel("LastName");
	staffLastNameLabel.setBounds(330,60,100,50);
	panel.add(staffLastNameLabel);

	staffIDLabel = new JLabel("ID #");
	staffIDLabel.setBounds(60,150,100,50);
	panel.add(staffIDLabel);

	staffJobLabel = new JLabel("Staff Position");
	staffJobLabel.setBounds(60,250,150,50);
	panel.add(staffJobLabel);

	staffPhoneLabel = new JLabel("Phone #");
	staffPhoneLabel.setBounds(330,150,100,50);
	panel.add(staffPhoneLabel);

	staffPasswordLabel = new JLabel("Password");
	staffPasswordLabel.setBounds(330,250,100,50);
	panel.add(staffPasswordLabel);

	firstNameTextField = new JTextField();
	firstNameTextField.setBounds(160,70,130,35);
	panel.add(firstNameTextField);

	lastNameTextField = new JTextField();
	lastNameTextField.setBounds(430,70,130,35);
	panel.add(lastNameTextField);
	
	idTextField = new JTextField();
	idTextField.setBounds(160,158,130,35);
	panel.add(idTextField);
	
	phoneTextField = new JTextField();
	phoneTextField.setBounds(430,157,130,35);
	panel.add(phoneTextField);
	
	staffJobTextField = new JTextField();
	staffJobTextField.setBounds(175,257,130,35);
	panel.add(staffJobTextField);
		
	staffPasswordTextField = new JPasswordField();
	staffPasswordTextField.setBounds(430,257,130,35);
	panel.add(staffPasswordTextField);
	
	confirmCreateStaffButton = new JButton("Confirm");
	confirmCreateStaffButton.setBounds(150,400,100,50);
	confirmCreateStaffButton.setMargin(new Insets(0,0,0,0));
	panel.add(confirmCreateStaffButton);

	cancelCreateStaffButton = new JButton("Cancel");
	cancelCreateStaffButton.setBounds(350,400,100,50);
	cancelCreateStaffButton.setMargin(new Insets(0,0,0,0));
	cancelCreateStaffButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(cancelCreateStaffButton);


}

	private static void placeComponentsCheckSchedule(JPanel panel) {

	panel.setLayout(null);
	
	scheduleLabel = new JLabel();
	scheduleLabel.setBounds(200,100,300,300);
	panel.add(scheduleLabel);

	mainMenuEmployeeScheduleButton = new JButton("Main Menu");
	mainMenuEmployeeScheduleButton.setBounds(250,450,100,50);
	mainMenuEmployeeScheduleButton.setMargin(new Insets(0,0,0,0));
	mainMenuEmployeeScheduleButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(mainMenuEmployeeScheduleButton);

}

	private static void placeComponentsGarageStatus(JPanel panel) {

	panel.setLayout(null);

	statusLabel = new JLabel("Options");
	statusLabel.setBounds(20,50,100,50);
	panel.add(statusLabel);

	statusOutLabel = new JLabel();
	statusOutLabel.setBounds(100,100,500,300);
	panel.add(statusOutLabel);

	garageEntities = new JComboBox();
	garageEntities.setBounds(90,59,170,30);
	panel.add(garageEntities);

	confirmGarageStatusButton = new JButton("Confirm");
	confirmGarageStatusButton.setBounds(150,400,100,50);
	confirmGarageStatusButton.setMargin(new Insets(0,0,0,0));
	panel.add(confirmGarageStatusButton);
	
	mainMenuGarageStatusButton = new JButton("Main Menu");
	mainMenuGarageStatusButton.setBounds(350,400,100,50);
	mainMenuGarageStatusButton.setMargin(new Insets(0,0,0,0));
	mainMenuGarageStatusButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(mainMenuGarageStatusButton);
}

	public static void placeComponentsSearchCustomer(JPanel panel) {

	panel.setLayout(null);

	custName = new JLabel("Customers Name");
	custName.setBounds(30,60,150,50);
	panel.add(custName);

	custNameTextField = new JTextField();
	custNameTextField.setBounds(170,70,160,30);
	panel.add(custNameTextField);
	
	displayCustInfo = new JLabel("meow");
	//displayCustInfo.setBounds(80,130,100,100);
	panel.add(displayCustInfo);
	
	searchSearchCustomerButton = new JButton("Search");
	searchSearchCustomerButton.setBounds(150,450,100,50);
	searchSearchCustomerButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchSearchCustomerButton);
	
	mainMenuSearchCustomerButton = new JButton("Main Menu");
	mainMenuSearchCustomerButton.setBounds(350,450,100,50);
	mainMenuSearchCustomerButton.setMargin(new Insets(0,0,0,0));
	mainMenuSearchCustomerButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(mainMenuSearchCustomerButton);

}

	private static void placeComponentsBuildReport(JPanel panel) {

	panel.setLayout(null);

	monthLabel = new JLabel("Month");
	monthLabel.setBounds(20,20,80,80);
	panel.add(monthLabel);
	
	dayLabel = new JLabel("Day");
	dayLabel.setBounds(205,20,80,80);
	panel.add(dayLabel);
	
	yearLabel = new JLabel("Year");
	yearLabel.setBounds(390,20,80,80);
	panel.add(yearLabel);

	monthTextField = new JTextField();
	monthTextField.setBounds(90,46,80,30);
	panel.add(monthTextField);
	
	dayTextField = new JTextField();
	dayTextField.setBounds(255,46,80,30);
	panel.add(dayTextField);
	
	yearTextField = new JTextField();
	yearTextField.setBounds(445,46,80,30);
	panel.add(yearTextField);
	
	reportInformationTextField = new JTextField();
	reportInformationTextField.setBounds(63,100,450,300);
	panel.add(reportInformationTextField);
	
	confirmReportButton = new JButton("Confirm");
	confirmReportButton.setBounds(150,450,100,50);
	confirmReportButton.setMargin(new Insets(0,0,0,0));
	panel.add(confirmReportButton);
	
	mainMenuReportButton = new JButton("Main Menu");
	mainMenuReportButton.setBounds(350,450,100,50);
	mainMenuReportButton.setMargin(new Insets(0,0,0,0));
	mainMenuReportButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(mainMenuReportButton);

}

	public static void placeComponentsSearchEMP(JPanel panel) {

	panel.setLayout(null);

	searchStaffName = new JLabel("Staff Members Name");
	searchStaffName.setBounds(30,60,150,50);
	panel.add(searchStaffName);

	searchStaffNameTextField = new JTextField();
	searchStaffNameTextField.setBounds(195,70,160,30);
	panel.add(searchStaffNameTextField);

	searchDisplayStaffInfo = new JLabel("meow");
	searchDisplayStaffInfo.setBounds(80,130,100,100);
	panel.add(searchDisplayStaffInfo);

	searchEmployeeSearchButton = new JButton("Search");
	searchEmployeeSearchButton.setBounds(150,450,100,50);
	searchEmployeeSearchButton.setMargin(new Insets(0,0,0,0));
	panel.add(searchEmployeeSearchButton);

	searchEmployeeMainMenuButton = new JButton("Main Menu");
	searchEmployeeMainMenuButton.setBounds(350,450,100,50);
	searchEmployeeMainMenuButton.setMargin(new Insets(0,0,0,0));
	searchEmployeeMainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		allGUI.show(controlPanel, "2");
	}
});
	panel.add(searchEmployeeMainMenuButton);

}

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		createGUI();
            }
        });
    }


}
