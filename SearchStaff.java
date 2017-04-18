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

staffName = new JLabel("Staff Member Name");
staffName.setBounds(10,200,60,60);
panel.add(staffName);

staffNameTextField = new JTextField();
staffNameTextField.setBounds(60,200,80,80);
panel.add(staffNameTextField);

displayStaffInfo = new JLabel();
displayStaffInfo.setBounds(40,300,100,100);
panel.add(displayStaffInfo);

searchButton = new JButton("Search Staff");
searchButton.setBounds(80,500,50,50);
panel.add(searchButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(170,500,50,50);
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
