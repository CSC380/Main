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
static JTextField reportInformationTextField;
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

panel.setLayout(null);

monthLabel = new JLabel("Month");
monthLabel.setBounds(20,20,80,80);
panel.add(monthLabel);

dayLabel = new JLabel("Day");
dayLabel.setBounds(205,20,80,80);
panel.add(dayLabel);

yearLabel = new JLabel("Year");
yearLabel.setBounds(390,20,80,80);
panel.add(yearLabel);

monthTextField = new JTextField();
monthTextField.setBounds(90,46,80,30);
panel.add(monthTextField);

dayTextField = new JTextField();
dayTextField.setBounds(255,46,80,30);
panel.add(dayTextField);

yearTextField = new JTextField();
yearTextField.setBounds(445,46,80,30);
panel.add(yearTextField);

reportInformationTextField = new JTextField();
reportInformationTextField.setBounds(63,100,450,300);
panel.add(reportInformationTextField);

confirmButton = new JButton("Confirm");
confirmButton.setBounds(150,450,100,50);
confirmButton.setMargin(new Insets(0,0,0,0));
panel.add(confirmButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(350,450,100,50);
mainMenuButton.setMargin(new Insets(0,0,0,0));
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
