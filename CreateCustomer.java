import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateCustomer {

static JFrame createCust;
static JPanel custInfo;
static JLabel custFirstNameLabel;
static JLabel custLastNameLabel;
static JLabel custEmailLabel;
static JLabel custPlateLabel;
static JTextField firstNameTextField;
static JTextField lastNameTextField;
static JTextField emailTextField;
static JTextField licenseTextField;
static JButton confirmButton;
static JButton cancelButton;

public CreateCustomer() {

createGUI();
}

private static void createGUI() {

createCust = new JFrame("Customer Info");
createCust.setSize(600,600);
createCust.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

custInfo = new JPanel();
placeComponents(custInfo);

createCust.add(custInfo);
createCust.setVisible(true);
}

private static void placeComponents(JPanel panel) {

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

confirmButton = new JButton("Confirm");
confirmButton.setBounds(150,400,100,50);
confirmButton.setMargin(new Insets(0,0,0,0));
//confirmButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//		MainMenuEmployee main = new MainMenuEmployee();
//	}
//});
panel.add(confirmButton);

cancelButton = new JButton("Cancel");
cancelButton.setBounds(350,400,100,50);
cancelButton.setMargin(new Insets(0,0,0,0));
cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		createCust.dispose();
		new MainMenuEmployee();
	}
});
panel.add(cancelButton);

}

public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
	public void run() {
		createGUI();
	}
   });
}

}
