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

custFirstNameLabel = new JLabel("Fist Name");
custFirstNameLabel.setBounds(60,60,50,50);
panel.add(custFirstNameLabel);

custLastNameLabel = new JLabel("LastName");
custLastNameLabel.setBounds(60,110,50,50);
panel.add(custLastNameLabel);

custEmailLabel = new JLabel("Email Address");
custEmailLabel.setBounds(60,200,50,50);
panel.add(custEmailLabel);

custPlateLabel = new JLabel("License #");
custPlateLabel.setBounds(60,300,50,50);
panel.add(custPlateLabel);

firstNameTextField = new JTextField();
firstNameTextField.setBounds(130,60,60,60);
panel.add(firstNameTextField);

lastNameTextField = new JTextField();
lastNameTextField.setBounds(130,110,60,60);
panel.add(lastNameTextField);

emailTextField = new JTextField();
emailTextField.setBounds(110,200,60,60);
panel.add(emailTextField);

licenseTextField = new JTextField();
licenseTextField.setBounds(110,300,60,60);
panel.add(licenseTextField);

confirmButton = new JButton("Confirm");
confirmButton.setBounds(300,450,50,50);
//confirmButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//		MainMenuEmployee main = new MainMenuEmployee();
//	}
//});
panel.add(confirmButton);

cancelButton = new JButton("Cancel");
cancelButton.setBounds(400,450,50,50);
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
