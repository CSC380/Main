import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeSchedule {

static JLabel scheduleLabel;

static JPanel weeklyPanel;
static JButton mainMenuButton;
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

panel.setLayout(null);

scheduleLabel = new JLabel();
scheduleLabel.setBounds(200,100,300,300);
panel.add(scheduleLabel);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(250,450,100,50);
mainMenuButton.setMargin(new Insets(0,0,0,0));
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		schedule.dispose();
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
