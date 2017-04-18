import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchCustomer {

static JLabel custName;
static JTextField custNameTextField;
static JLabel displayCustInfo;
static JButton searchButton;
static JButton mainMenuButton;
static JFrame search;
static JPanel searchPanel;

public SearchCustomer() {

createGUI();
}

public static void createGUI() {

search = new JFrame("Search Customer");
search.setSize(600,600);
search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

searchPanel = new JPanel();
search.add(searchPanel);
placeComponents(searchPanel);

search.setVisible(true);
}

public static void placeComponents(JPanel panel) {

custName = new JLabel("Customers Name");
custName.setBounds(10,200,60,60);
panel.add(custName);

custNameTextField = new JTextField();
custNameTextField.setBounds(60,200,80,80);
panel.add(custNameTextField);

displayCustInfo = new JLabel();
displayCustInfo.setBounds(40,300,100,100);
panel.add(displayCustInfo);

searchButton = new JButton("Search");
searchButton.setBounds(80,500,50,50);
panel.add(searchButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(170,500,50,50);
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		search.dispose();
		new MainMenuEmployee();
	}
});
panel.add(mainMenuButton);
}

public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
		createGUI();
            }
        });

}

}
