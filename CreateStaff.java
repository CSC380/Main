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
static JTextField firstNameTextField;
static JTextField lastNameTextField;
static JTextField idTextField;
static JTextField phoneTextField;
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

staffFirstNameLabel = new JLabel("Fist Name");
staffFirstNameLabel.setBounds(60,60,50,50);
panel.add(staffFirstNameLabel);

staffLastNameLabel = new JLabel("LastName");
staffLastNameLabel.setBounds(60,110,50,50);
panel.add(staffLastNameLabel);

staffIDLabel = new JLabel("ID #");
staffIDLabel.setBounds(60,200,50,50);
panel.add(staffIDLabel);

staffPhoneLabel = new JLabel("Phone #");
staffPhoneLabel.setBounds(60,300,50,50);
panel.add(staffPhoneLabel);

firstNameTextField = new JTextField();
firstNameTextField.setBounds(130,60,60,60);
panel.add(firstNameTextField);

lastNameTextField = new JTextField();
lastNameTextField.setBounds(130,110,60,60);
panel.add(lastNameTextField);

idTextField = new JTextField();
idTextField.setBounds(110,200,60,60);
panel.add(idTextField);

phoneTextField = new JTextField();
phoneTextField.setBounds(110,300,60,60);
panel.add(phoneTextField);

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
