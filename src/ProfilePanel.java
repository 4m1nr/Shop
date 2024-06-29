import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField phoneNumberTextField;
	private JPasswordField newPasswordField;
	private JTextField addBalanceTextField;
	private JPasswordField oldPasswordField;

	/**
	 * Create the panel.
	 */
	public ProfilePanel() {
		
		//To do: string haye name, lastname, phone number, email va address ro az data base meghdar dehi kon <3
		String name="";
		String lastName="";
		String phoneNumber="";
		String email="";
		String address="";
		
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
		
		JLabel oldPasswordLabel = new JLabel("Old password:");
		oldPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_oldPasswordLabel = new GridBagConstraints();
		gbc_oldPasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_oldPasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_oldPasswordLabel.gridx = 0;
		gbc_oldPasswordLabel.gridy = 4;
		add(oldPasswordLabel, gbc_oldPasswordLabel);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		oldPasswordField.setColumns(10);
		GridBagConstraints gbc_oldPasswordField = new GridBagConstraints();
		gbc_oldPasswordField.anchor = GridBagConstraints.WEST;
		gbc_oldPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_oldPasswordField.gridx = 1;
		gbc_oldPasswordField.gridy = 4;
		add(oldPasswordField, gbc_oldPasswordField);
		
		JLabel newPasswordLabel = new JLabel("New password:");
		newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_newPasswordLabel = new GridBagConstraints();
		gbc_newPasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_newPasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newPasswordLabel.gridx = 0;
		gbc_newPasswordLabel.gridy = 5;
		add(newPasswordLabel, gbc_newPasswordLabel);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newPasswordField.setColumns(10);
		GridBagConstraints gbc_newPasswordField = new GridBagConstraints();
		gbc_newPasswordField.anchor = GridBagConstraints.WEST;
		gbc_newPasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_newPasswordField.gridx = 1;
		gbc_newPasswordField.gridy = 5;
		add(newPasswordField, gbc_newPasswordField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//To do: Upda
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel currentBalanceLabel = new JLabel("Current balance:");
		currentBalanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_currentBalanceLabel = new GridBagConstraints();
		gbc_currentBalanceLabel.anchor = GridBagConstraints.EAST;
		gbc_currentBalanceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_currentBalanceLabel.gridx = 0;
		gbc_currentBalanceLabel.gridy = 7;
		add(currentBalanceLabel, gbc_currentBalanceLabel);
		
		JLabel balanceLabel = new JLabel("**balance**");
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
				int balanceToAdd = Integer.parseInt(addBalanceTextField.getText());
				//To do
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
