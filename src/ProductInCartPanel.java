import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductInCartPanel extends JPanel {
	ShopControllerImpl controller;
	Product product;
	int quantity;

	public ProductInCartPanel(Product product,int quantity,ShopControllerImpl controller) {
		this.controller = controller;
		this.product = product;
		this.quantity = quantity;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{192, 24, 49, 24, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel productImage = new JLabel("Product icon");
		GridBagConstraints gbc_productImage = new GridBagConstraints();
		gbc_productImage.insets = new Insets(0, 0, 5, 0);
		gbc_productImage.gridx = 0;
		gbc_productImage.gridy = 0;
		add(productImage, gbc_productImage);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel nameLabel = new JLabel("**product name**");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 0;
		panel_2.add(nameLabel, gbc_nameLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, -84, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton decreaseButton = new JButton("-");
		decreaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_decreaseButton = new GridBagConstraints();
		gbc_decreaseButton.anchor = GridBagConstraints.EAST;
		gbc_decreaseButton.insets = new Insets(0, 0, 0, 5);
		gbc_decreaseButton.gridx = 1;
		gbc_decreaseButton.gridy = 0;
		panel.add(decreaseButton, gbc_decreaseButton);
		
		JLabel countLabel = new JLabel("**count**");
		GridBagConstraints gbc_countLabel = new GridBagConstraints();
		gbc_countLabel.insets = new Insets(0, 0, 0, 5);
		gbc_countLabel.gridx = 2;
		gbc_countLabel.gridy = 0;
		panel.add(countLabel, gbc_countLabel);
		
		JButton increaseButton = new JButton("+");
		increaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_increaseButton = new GridBagConstraints();
		gbc_increaseButton.insets = new Insets(0, 0, 0, 5);
		gbc_increaseButton.anchor = GridBagConstraints.WEST;
		gbc_increaseButton.gridx = 3;
		gbc_increaseButton.gridy = 0;
		panel.add(increaseButton, gbc_increaseButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Final Price:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel priceTimesCountLabel = new JLabel("**final price**");
		GridBagConstraints gbc_priceTimesCountLabel = new GridBagConstraints();
		gbc_priceTimesCountLabel.anchor = GridBagConstraints.WEST;
		gbc_priceTimesCountLabel.gridx = 1;
		gbc_priceTimesCountLabel.gridy = 0;
		panel_1.add(priceTimesCountLabel, gbc_priceTimesCountLabel);

	}

}
