
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginPanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel(String error) {
		setBackground(new Color(0, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Login with username and password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 5;
		add(passwordField, gbc_passwordField);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				// To do
			}
		});
		
		JLabel errorLabel = new JLabel(error);
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.fill = GridBagConstraints.VERTICAL;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 1;
		gbc_errorLabel.gridy = 6;
		add(errorLabel, gbc_errorLabel);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 7;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNoAccountSign = new JLabel("No account?");
		lblNoAccountSign.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNoAccountSign = new GridBagConstraints();
		gbc_lblNoAccountSign.anchor = GridBagConstraints.SOUTH;
		gbc_lblNoAccountSign.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoAccountSign.gridx = 1;
		gbc_lblNoAccountSign.gridy = 8;
		add(lblNoAccountSign, gbc_lblNoAccountSign);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sign upe amin chize khassi nis be abalfazl
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_btnSignUp = new GridBagConstraints();
		gbc_btnSignUp.anchor = GridBagConstraints.NORTH;
		gbc_btnSignUp.insets = new Insets(0, 0, 0, 5);
		gbc_btnSignUp.gridx = 1;
		gbc_btnSignUp.gridy = 9;
		add(btnSignUp, gbc_btnSignUp);

	}

}
