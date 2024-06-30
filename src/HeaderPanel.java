import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class HeaderPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	JButton btnNewButton_3;
	User user;
	ShopControllerImpl controller;

	/**
	 * Create the panel.
	 */
	public HeaderPanel(ShopControllerImpl controller) {
		this.controller = controller;
		this.user = controller.user;
		buildPanel();
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    controller.viewProfile(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
		});
		
		JButton btnExit = new JButton("Log out");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    controller.logout();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 0, 5);
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 0;
		add(btnExit, gbc_btnExit);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		//To do:
		/*if (user.role.equals("user")) {
			btnNewButton_3.setEnabled(false);
		}*/
		
		btnNewButton_3 = new JButton("Admin");
		this.updateAdmin();
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.viewAdminPanel();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 0;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                try {
                    controller.viewCart();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.EAST;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.viewProducts(1,controller.getSortByThis(),textField.getText());
				}
				catch (Exception ex){
					throw new RuntimeException("SQLException");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Products");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.openDefaultPanel();
				}
				catch (SQLException ex){
					throw new RuntimeException("SQLException");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridx = 6;
		gbc_btnNewButton_4.gridy = 0;
		add(btnNewButton_4, gbc_btnNewButton_4);

	}

	private void buildPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	public void updateAdmin() {
        try {
            this.user = controller.getUser();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        if (user != null)
            this.btnNewButton_3.setVisible(user.getRole().equalsIgnoreCase("admin"));
		this.repaint();
		this.revalidate();
	}

}
