import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllStaff {

static JLabel staffInfoLabel;
static JFrame staff;
static JButton mainMenu;
static JPanel allStaffInfoPanel;

public AllStaff() {

createGUI();
}

public static void createGUI() {

staff = new JFrame("All Staff");
staff.setSize(600,600);
staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

allStaffInfoPanel = new JPanel();
staff.add(allStaffInfoPanel);
placeComponents(allStaffInfoPanel);

staff.setVisible(true);
}

public static void placeComponents(JPanel panel) {

staffInfoLabel = new JLabel();
staffInfoLabel.setBounds(10,200,60,60);
panel.add(staffInfoLabel);

mainMenu = new JButton("Main Menu");
mainMenu.setBounds(20,20,50,50);
mainMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		staff.dispose();
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

}
