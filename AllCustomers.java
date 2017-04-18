import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllCustomers {

static JLabel custInfoLabel;
static JFrame customer;
static JPanel allCustInfoPanel;

public AllCustomers() {

createGUI();
}

public static void createGUI() {

customer = new JFrame("All Customers");
customer.setSize(600,600);
customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

allCustInfoPanel = new JPanel();
placeComponents(allCustInfoPanel);
customer.add(allCustInfoPanel);

customer.setVisible(true);
}

public static void placeComponents(JPanel panel) {

custInfoLabel = new JLabel();
custInfoLabel.setBounds(10,200,60,60);
panel.add(custInfoLabel);

mainMenu = new JButton("Main Menu");
mainMenu.setBounds(20,200,50,50);
mainMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		customer.dispose();
		new MainMenuEmployee();
	}
});
panel.add(mainMenu);

}

public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
		createGUI();
            }
        });

}

}

