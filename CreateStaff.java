import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreateStaff {

static JFrame createStaff;
static JPanel staffInfo;

static JLabel staffFirstNameLabel;
static JLabel staffLastNameLabel;
static JLabel staffIDLabel;
static JLabel staffPhoneLabel;
static JLabel staffJobLabel;
static JLabel staffPasswordLabel;

static JTextField firstNameTextField;
static JTextField lastNameTextField;
static JTextField idTextField;
static JTextField phoneTextField;
static JTextField staffJobTextField;
static JPasswordField staffPasswordTextField;

static JButton confirmButton;
static JButton cancelButton;

public CreateStaff() {

createGUI();
}

private static void createGUI() {

createStaff = new JFrame("Employee Info");
createStaff.setSize(600,600);
createStaff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

staffInfo = new JPanel();
placeComponents(staffInfo);

createStaff.add(staffInfo);
createStaff.setVisible(true);
}

private static void placeComponents(JPanel panel) {

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
		createStaff.dispose();
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
