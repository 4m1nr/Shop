import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.util.Stack;

public class ProfilePanel extends JPanel {

	private JTextField nameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JPasswordField passwordField;
	private JTextField addBalanceTextField;
	ShopControllerImpl controller;
	User user;

	public ProfilePanel(ShopControllerImpl controller) {

		this.controller = controller;
		this.user = controller.user;
		String name = user.getName();
		String lastName = user.getLastName();
		String phoneNumber = user.getPhoneNumber();
		String email = user.getEmailAddress();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setText(name);
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.anchor = GridBagConstraints.WEST;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 0;
		add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last name:");
		lastNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 1;
		add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setText(lastName);
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.anchor = GridBagConstraints.WEST;
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_lastNameTextField.gridx = 1;
		gbc_lastNameTextField.gridy = 1;
		add(lastNameTextField, gbc_lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.EAST;
		gbc_emailLabel.insets = new Insets(0, 0, 5, 5);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 2;
		add(emailLabel, gbc_emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setText(email);
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTextField.setColumns(10);
		GridBagConstraints gbc_emailTextField = new GridBagConstraints();
		gbc_emailTextField.anchor = GridBagConstraints.WEST;
		gbc_emailTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailTextField.gridx = 1;
		gbc_emailTextField.gridy = 2;
		add(emailTextField, gbc_emailTextField);
		
		JLabel phoneNumberLabel = new JLabel("Phone number:");
		phoneNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
		gbc_phoneNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneNumberLabel.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberLabel.gridx = 0;
		gbc_phoneNumberLabel.gridy = 3;
		add(phoneNumberLabel, gbc_phoneNumberLabel);
		
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setText(phoneNumber);
		phoneNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneNumberTextField.setColumns(10);
		GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
		gbc_phoneNumberTextField.anchor = GridBagConstraints.WEST;
		gbc_phoneNumberTextField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneNumberTextField.gridx = 1;
		gbc_phoneNumberTextField.gridy = 3;
		add(phoneNumberTextField, gbc_phoneNumberTextField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.EAST;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 4;
		add(passwordLabel, gbc_passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 4;
		add(passwordField, gbc_passwordField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User newProfile;
				Stack<String> errorStack = new Stack<>();
				if(nameTextField.getText().isEmpty()){
					errorStack.add("Name cannot be empty");
				}
				if(!nameTextField.getText().matches("[a-zA-Z]+")){
					errorStack.add("Invalid name");
				}
				if(lastNameTextField.getText().isEmpty()){
					errorStack.add("Last Name cannot be empty");
				}
				if(!lastNameTextField.getText().matches("[a-zA-Z]+")){
					errorStack.add("Invalid name");
				}
				if(phoneNumberTextField.getText().isEmpty()){
					errorStack.add("Phone number cannot be empty");
				}
				if(phoneNumberTextField.getText().length() != 11 || !phoneNumberTextField.getText().startsWith("09") ||
					!phoneNumberTextField.getText().matches("\\d+")){
					errorStack.add("Invalid phone number");
				}
				if(emailTextField.getText().isEmpty()){
					errorStack.add("Email cannot be empty");
				}
				if(!emailTextField.getText().contains("@")){
					errorStack.add("Invalid email");
				}
				if(errorStack.isEmpty()){
					if (passwordField.getPassword().length == 0)
						newProfile = new User(user.getId(), nameTextField.getText(), lastNameTextField.getText(),
								phoneNumberTextField.getText(), emailTextField.getText(), user.getHashedPassword(),
								user.getBalance(), user.getAddresses(), user.getCart(), user.getRole());
					else
						newProfile = new User(user.getId(), nameTextField.getText(), lastNameTextField.getText(),
								phoneNumberTextField.getText(), emailTextField.getText(), User.HashPassword(new String(passwordField.getPassword())),
								user.getBalance(), user.getAddresses(), user.getCart(), user.getRole());

					try {
						if (JOptionPane.showConfirmDialog(null, "are you sure"
								, "update profile", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
							controller.updateProfile(newProfile);
					} catch (SQLException ex) {
						throw new RuntimeException(ex.getMessage());
					}
				}
            }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel errorLabel = new JLabel(error);
		errorLabel.setForeground(new Color(255, 0, 0));
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.gridwidth = 2;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 0;
		gbc_errorLabel.gridy = 6;
		add(errorLabel, gbc_errorLabel);
		
		JLabel currentBalanceLabel = new JLabel("Current balance:");
		currentBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_currentBalanceLabel = new GridBagConstraints();
		gbc_currentBalanceLabel.anchor = GridBagConstraints.EAST;
		gbc_currentBalanceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_currentBalanceLabel.gridx = 0;
		gbc_currentBalanceLabel.gridy = 7;
		add(currentBalanceLabel, gbc_currentBalanceLabel);
		
		JLabel balanceLabel = new JLabel(user.getBalance() + "");
		balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_balanceLabel = new GridBagConstraints();
		gbc_balanceLabel.anchor = GridBagConstraints.WEST;
		gbc_balanceLabel.insets = new Insets(0, 0, 5, 0);
		gbc_balanceLabel.gridx = 1;
		gbc_balanceLabel.gridy = 7;
		add(balanceLabel, gbc_balanceLabel);
		
		JLabel addBalanceLabel = new JLabel("Add balance:");
		addBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_addBalanceLabel = new GridBagConstraints();
		gbc_addBalanceLabel.anchor = GridBagConstraints.EAST;
		gbc_addBalanceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_addBalanceLabel.gridx = 0;
		gbc_addBalanceLabel.gridy = 8;
		add(addBalanceLabel, gbc_addBalanceLabel);
		
		addBalanceTextField = new JTextField();
		addBalanceTextField.setText("");
		addBalanceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addBalanceTextField.setColumns(6);
		GridBagConstraints gbc_addBalanceTextField = new GridBagConstraints();
		gbc_addBalanceTextField.anchor = GridBagConstraints.WEST;
		gbc_addBalanceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_addBalanceTextField.gridx = 1;
		gbc_addBalanceTextField.gridy = 8;
		add(addBalanceTextField, gbc_addBalanceTextField);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double balanceToAdd = Double.parseDouble(addBalanceTextField.getText());
                try {
					if (JOptionPane.showConfirmDialog(null, "are you sure you want to add "
							+ balanceToAdd + " to your balance?", "Bank", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
						controller.upadteUserBalance(balanceToAdd + user.getBalance());
						controller.viewProfile();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
		});
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.WEST;
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 9;
		add(addButton, gbc_addButton);

	}

}
