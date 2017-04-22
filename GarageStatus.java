import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GarageStatus {

static JLabel statusLabel;
static JLabel statusOutLabel;
static JButton confirmButton;
static JButton mainMenuButton;
static JFrame garageOptions;
static JPanel garagePanel;
static JComboBox garageEntities;

public GarageStatus() {

createGUI();
}

private static void createGUI() {

garageOptions = new JFrame("Garage");
garageOptions.setSize(600,600);
garageOptions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

garagePanel = new JPanel();
placeComponents(garagePanel);
garageOptions.add(garagePanel);

garageOptions.setVisible(true);
}

private static void placeComponents(JPanel panel) {

panel.setLayout(null);

statusLabel = new JLabel("Options");
statusLabel.setBounds(20,50,100,50);
panel.add(statusLabel);

statusOutLabel = new JLabel();
statusOutLabel.setBounds(100,100,500,300);
panel.add(statusOutLabel);

garageEntities = new JComboBox();
garageEntities.setBounds(90,59,170,30);
panel.add(garageEntities);

confirmButton = new JButton("Confirm");
confirmButton.setBounds(150,400,100,50);
confirmButton.setMargin(new Insets(0,0,0,0));
//confirmButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//		MainMenuEmployee main = new MainMenuEmployee();
//	}
//});
panel.add(confirmButton);

mainMenuButton = new JButton("Main Menu");
mainMenuButton.setBounds(350,400,100,50);
mainMenuButton.setMargin(new Insets(0,0,0,0));
mainMenuButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		garageOptions.dispose();
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
