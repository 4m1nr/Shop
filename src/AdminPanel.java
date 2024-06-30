import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AdminPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	ShopControllerImpl controller;
	/**
	 * Create the panel.
	 */
	public AdminPanel(ShopControllerImpl controller) {
		this.controller = controller;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton addButton = new JButton("Add product");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.viewAddProductPanel();
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.insets = new Insets(0, 0, 0, 5);
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 0;
		add(addButton, gbc_addButton);
		
		JButton ordersButton = new JButton("Check orders");
		ordersButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ordersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.viewAllOrders();
			}
		});
		GridBagConstraints gbc_ordersButton = new GridBagConstraints();
		gbc_ordersButton.insets = new Insets(0, 0, 0, 5);
		gbc_ordersButton.gridx = 1;
		gbc_ordersButton.gridy = 0;
		add(ordersButton, gbc_ordersButton);
		
		JButton customersButton = new JButton("Check customers");
		customersButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		customersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.viewUsers();
			}
		});
		GridBagConstraints gbc_customersButton = new GridBagConstraints();
		gbc_customersButton.gridx = 2;
		gbc_customersButton.gridy = 0;
		add(customersButton, gbc_customersButton);

	}

}
