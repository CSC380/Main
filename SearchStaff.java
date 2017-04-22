import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchStaff {

static JLabel staffName;
static JTextField staffNameTextField;
static JLabel displayStaffInfo;
static JButton searchButton;
static JButton mainMenuButton;
static JFrame search;
static JPanel searchPanel;

public SearchStaff() {

createGUI();
}

public static void createGUI() {

search = new JFrame("Search Staff");
search.setSize(600,600);
search.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

searchPanel = new JPanel();
search.add(searchPanel);
placeComponents(searchPanel);

search.setVisible(true);
}

public static void placeComponents(JPanel panel) {

panel.setLayout(null);

staffName = new JLabel("Staff Members Name");
staffName.setBounds(30,60,150,50);
panel.add(staffName);

staffNameTextField = new JTextField();
staffNameTextField.setBounds(195,70,160,30);
panel.add(staffNameTextField);

displayStaffInfo = new JLabel("meow");
//displayStaffInfo.setBounds(80,130,100,100);
panel.add(displayStaffInfo);

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
