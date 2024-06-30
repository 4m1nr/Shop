import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class AddProductPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField;
	private JTextField priceTextField;
	private JTextField imageTextField;
	private JTextField productCountTextField;

	/**
	 * Create the panel.
	 */
	public AddProductPanel(ShopControllerImpl controller) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 42, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel nameLabel = new JLabel("Product name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 0;
		add(nameLabel, gbc_nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_nameTextField = new GridBagConstraints();
		gbc_nameTextField.anchor = GridBagConstraints.WEST;
		gbc_nameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_nameTextField.gridx = 1;
		gbc_nameTextField.gridy = 0;
		add(nameTextField, gbc_nameTextField);
		nameTextField.setColumns(10);
		
		JLabel priceLabel = new JLabel("Product price:");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.EAST;
		gbc_priceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_priceLabel.gridx = 0;
		gbc_priceLabel.gridy = 1;
		add(priceLabel, gbc_priceLabel);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_priceTextField = new GridBagConstraints();
		gbc_priceTextField.anchor = GridBagConstraints.WEST;
		gbc_priceTextField.insets = new Insets(0, 0, 5, 0);
		gbc_priceTextField.gridx = 1;
		gbc_priceTextField.gridy = 1;
		add(priceTextField, gbc_priceTextField);
		priceTextField.setColumns(10);
		
		JLabel imageLabel = new JLabel("Product image:");
		imageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.anchor = GridBagConstraints.EAST;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 2;
		add(imageLabel, gbc_imageLabel);
		
		imageTextField = new JTextField();
		imageTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_imageTextField = new GridBagConstraints();
		gbc_imageTextField.anchor = GridBagConstraints.WEST;
		gbc_imageTextField.insets = new Insets(0, 0, 5, 0);
		gbc_imageTextField.gridx = 1;
		gbc_imageTextField.gridy = 2;
		add(imageTextField, gbc_imageTextField);
		imageTextField.setColumns(10);
		
		JLabel countLabel = new JLabel("Product count:");
		countLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_countLabel = new GridBagConstraints();
		gbc_countLabel.anchor = GridBagConstraints.EAST;
		gbc_countLabel.insets = new Insets(0, 0, 5, 5);
		gbc_countLabel.gridx = 0;
		gbc_countLabel.gridy = 3;
		add(countLabel, gbc_countLabel);
		
		productCountTextField = new JTextField();
		productCountTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		productCountTextField.setColumns(10);
		GridBagConstraints gbc_productCountTextField = new GridBagConstraints();
		gbc_productCountTextField.anchor = GridBagConstraints.WEST;
		gbc_productCountTextField.insets = new Insets(0, 0, 5, 0);
		gbc_productCountTextField.gridx = 1;
		gbc_productCountTextField.gridy = 3;
		add(productCountTextField, gbc_productCountTextField);
		
		JButton addButton = new JButton("Add product");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.WEST;
		gbc_addButton.gridx = 1;
		gbc_addButton.gridy = 4;
		add(addButton, gbc_addButton);

	}

}
