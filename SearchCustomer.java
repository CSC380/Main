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

searchButton = new JButton("Search");
searchButton.setBounds(150,450,100,50);
searchButton.setMargin(new Insets(0,0,0,0));
panel.add(searchButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(350,450,100,50);
mainMenuButton.setMargin(new Insets(0,0,0,0));
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