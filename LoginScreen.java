import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginScreen {

static JButton loginButton;
static JButton closeButton;
static JLabel idLabel;
static JLabel passwordLabel;
static JTextField idText;
static JPasswordField passwordText;
static JFrame login;

public LoginScreen() {

createGUI();
}

    private static void createGUI() {

	login = new JFrame("Login Screen");
	login.setSize(700,600);
	login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel outline = new JPanel();
	login.add(outline);
	placeComponents(outline);

	//login.pack();
	login.setVisible(true);	
}

    private static void placeComponents(JPanel panel) {

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
	loginButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		login.dispose();
		new MainMenuEmployee();
	}
});
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

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		createGUI();
            }
        });
    }


}
