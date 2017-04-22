import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AllStaff {

static JLabel staffInfoLabel;
static JLabel staffBoxLabel;
static JComboBox staffBox;
static JFrame staff;
static JButton mainMenuButton;
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

panel.setLayout(null);

staffBoxLabel = new JLabel("Staff");
staffBoxLabel.setBounds(30,30,50,50);
panel.add(staffBoxLabel);

staffInfoLabel = new JLabel();
staffInfoLabel.setBounds(250,300,60,60);
panel.add(staffInfoLabel);

staffBox = new JComboBox();
staffBox.setBounds(85,43,300,30);
panel.add(staffBox);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(250,370,100,50);
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		staff.dispose();
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
