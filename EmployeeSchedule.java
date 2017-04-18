import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeSchedule {

static JLabel mondayLabel;
static JLabel tuesdayLabel;
static JLabel wednesdayLabel;
static JLabel thursdayLabel;
static JLabel fridayLabel;
static JLabel saturdayLabel;
static JLabel sundayLabel;
static JLabel mondaySetLabel;
static JLabel tuesdaySetLabel;
static JLabel wednesdaySetLabel;
static JLabel thursdaySetLabel;
static JLabel fridaySetLabel;
static JLabel saturdaySetLabel;
static JLabel sundaySetLabel;
static JPanel weeklyPanel;
static JButton mainMenu;
static JFrame schedule;

public EmployeeSchedule() {

createGUI();
}

private static void createGUI() {

schedule = new JFrame("Employee Schedule");
schedule.setSize(600,600);
schedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

weeklyPanel = new JPanel();
placeComponents(weeklyPanel);
schedule.add(weeklyPanel);

schedule.setVisible(true);
}

private static void placeComponents(JPanel panel) {

mondayLabel = new JLabel("Monday");
mondayLabel.setBounds(10,30,50,50);
panel.add(mondayLabel);

tuesdayLabel = new JLabel("Tuesday");
tuesdayLabel.setBounds(15,20,50,50);
panel.add(tuesdayLabel);

wednesdayLabel = new JLabel("Wednesday");
wednesdayLabel.setBounds(25,35,50,50);
panel.add(wednesdayLabel);

thursdayLabel = new JLabel("Thursday");
thursdayLabel.setBounds(45,55,50,50);
panel.add(thursdayLabel);

fridayLabel = new JLabel("Friday");
fridayLabel.setBounds(5,7,50,50);
panel.add(fridayLabel);

saturdayLabel = new JLabel("Saturday");
saturdayLabel.setBounds(6,8,50,50);
panel.add(saturdayLabel);

sundayLabel = new JLabel("Sunday");
sundayLabel.setBounds(9,13,50,50);
panel.add(sundayLabel);

mondaySetLabel = new JLabel();
mondaySetLabel.setBounds(10,20,30,40);
panel.add(mondaySetLabel);

tuesdaySetLabel = new JLabel();
tuesdaySetLabel.setBounds(5,15,30,40);
panel.add(tuesdaySetLabel);

wednesdaySetLabel = new JLabel();
wednesdaySetLabel.setBounds(25,35,30,40);
panel.add(wednesdaySetLabel);

thursdaySetLabel = new JLabel();
thursdaySetLabel.setBounds(11,19,30,40);
panel.add(thursdaySetLabel);

fridaySetLabel = new JLabel();
fridaySetLabel.setBounds(21,31,30,40);
panel.add(fridaySetLabel);

saturdaySetLabel = new JLabel();
saturdaySetLabel.setBounds(22,32,30,40);
panel.add(saturdaySetLabel);

sundaySetLabel = new JLabel();
sundaySetLabel.setBounds(23,33,30,40);
panel.add(sundaySetLabel);

mainMenu = new JButton("Main Menu");
mainMenu.setBounds(20,20,50,50);
mainMenu.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		schedule.dispose();
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
