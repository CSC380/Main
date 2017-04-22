import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllCustomers {

static JLabel custInfoLabel;
static JLabel custBoxLabel;
static JComboBox custBox;
static JFrame customer;
static JButton mainMenuButton;
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

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(250,370,100,50);
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		customer.dispose();
		new MainMenuEmployee();
	}
});
mainMenuButton.setMargin(new Insets(0,0,0,0));
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

