import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReportGUI {

static JLabel monthLabel;
static JLabel dayLabel;
static JLabel yearLabel;
static JTextField monthTextField;
static JTextField dayTextField;
static JTextField yearTextField;
static JButton confirmButton;
static JButton mainMenuButton;
static JFrame report;
static JPanel reportPanel;

public ReportGUI() {

createGUI();
}

private static void createGUI() {

report = new JFrame("Report");
report.setSize(600,600);
report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

reportPanel = new JPanel();
placeComponents(reportPanel);
report.add(reportPanel);

report.setVisible(true);
}

private static void placeComponents(JPanel panel) {

monthLabel = new JLabel("Month");
monthLabel.setBounds(20,20,40,40);
panel.add(monthLabel);

dayLabel = new JLabel("Day");
dayLabel.setBounds(60,20,40,40);
panel.add(dayLabel);

yearLabel = new JLabel("Year");
yearLabel.setBounds(100,20,40,40);
panel.add(yearLabel);

monthTextField = new JTextField();
monthTextField.setBounds(30,20,50,50);
panel.add(monthTextField);

dayTextField = new JTextField();
dayTextField.setBounds(70,20,50,50);
panel.add(dayTextField);

yearTextField = new JTextField();
yearTextField.setBounds(110,20,50,50);
panel.add(yearTextField);

confirmButton = new JButton("Confirm");
confirmButton.setBounds(80,500,50,50);
panel.add(confirmButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(170,500,50,50);
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		report.dispose();
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
