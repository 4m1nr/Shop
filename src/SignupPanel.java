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


public class SignupPanel extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JTextField lastNameTextField;
	private JTextField nameTextField;
	private JTextField phoneNumberTextField;
	private JPasswordField passwordField;
	private JTextField addressTextField;
	private JTextField emailTextField;

	/**
	 * Create the panel.
	 */
	public SignupPanel(String error) {
		setBackground(new Color(0, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel signUpLabel = new JLabel("Sign up");
		signUpLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_signUpLabel = new GridBagConstraints();
		gbc_signUpLabel.gridwidth = 3;
		gbc_signUpLabel.anchor = GridBagConstraints.NORTH;
		gbc_signUpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_signUpLabel.gridx = 1;
		gbc_signUpLabel.gridy = 1;
		add(signUpLabel, gbc_signUpLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.SOUTH;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 2;
		add(nameLabel, gbc_nameLabel);
		
		JLabel lastNameLabel = new JLabel("Last name");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridx = 2;
		gbc_lastNameLabel.gridy = 2;
		add(lastNameLabel, gbc_lastNameLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone number");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
		gbc_phoneNumberLabel.anchor = GridBagConstraints.SOUTH;
		gbc_phoneNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberLabel.gridx = 3;
		gbc_phoneNumberLabel.gridy = 2;
		add(phoneNumberLabel, gbc_phoneNumberLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameTextField.setColumns(10);
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.anchor = GridBagConstraints.NORTH;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 3;
		add(nameTextField, gbc_nameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lastNameTextField.setColumns(10);
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.anchor = GridBagConstraints.NORTH;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameTextField.gridx = 2;
		gbc_lastNameTextField.gridy = 3;
		add(lastNameTextField, gbc_lastNameTextField);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberTextField.setColumns(10);
		GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
		gbc_phoneNumberTextField.anchor = GridBagConstraints.NORTH;
		gbc_phoneNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberTextField.gridx = 3;
		gbc_phoneNumberTextField.gridy = 3;
		add(phoneNumberTextField, gbc_phoneNumberTextField);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.SOUTH;
		gbc_addressLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addressLabel.gridx = 1;
		gbc_addressLabel.gridy = 4;
		add(addressLabel, gbc_addressLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.SOUTH;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 2;
		gbc_emailLabel.gridy = 4;
		add(emailLabel, gbc_emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.SOUTH;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 3;
		gbc_passwordLabel.gridy = 4;
		add(passwordLabel, gbc_passwordLabel);
		
		JButton signUpButton = new JButton("Sign up");
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = lastNameTextField.getText();
				String password = passwordField.getText();
				// To do
			}
		});
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressTextField.setColumns(10);
		GridBagConstraints gbc_addressTextField = new GridBagConstraints();
		gbc_addressTextField.anchor = GridBagConstraints.NORTH;
		gbc_addressTextField.insets = new Insets(0, 0, 5, 5);
		gbc_addressTextField.gridx = 1;
		gbc_addressTextField.gridy = 5;
		add(addressTextField, gbc_addressTextField);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.anchor = GridBagConstraints.NORTH;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 5);
		gbc_emailTextField.gridx = 2;
		gbc_emailTextField.gridy = 5;
		add(emailTextField, gbc_emailTextField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 5;
		add(passwordField, gbc_passwordField);
		
		JLabel errorLabel = new JLabel(error);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.gridwidth = 3;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 1;
		gbc_errorLabel.gridy = 6;
		add(errorLabel, gbc_errorLabel);
		signUpButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_signUpButton = new GridBagConstraints();
		gbc_signUpButton.gridwidth = 3;
		gbc_signUpButton.insets = new Insets(0, 0, 5, 5);
		gbc_signUpButton.gridx = 1;
		gbc_signUpButton.gridy = 7;
		add(signUpButton, gbc_signUpButton);
		
		JButton backToLoginButton = new JButton("Back to login");
		backToLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//To do: back to login panel: rahate natars
			}
		});
		backToLoginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_backToLoginButton = new GridBagConstraints();
		gbc_backToLoginButton.gridwidth = 3;
		gbc_backToLoginButton.anchor = GridBagConstraints.SOUTH;
		gbc_backToLoginButton.insets = new Insets(0, 0, 5, 5);
		gbc_backToLoginButton.gridx = 1;
		gbc_backToLoginButton.gridy = 8;
		add(backToLoginButton, gbc_backToLoginButton);

	}

}
