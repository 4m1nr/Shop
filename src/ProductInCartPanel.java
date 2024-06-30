import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ProductInCartPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField countTextField;

	/**
	 * Create the panel.
	 */
	
	//To do: needs constructor
	public ProductInCartPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{192, 24, 24, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel productImage = new JLabel("Product icon");
		GridBagConstraints gbc_productImage = new GridBagConstraints();
		gbc_productImage.insets = new Insets(0, 0, 5, 0);
		gbc_productImage.gridx = 0;
		gbc_productImage.gridy = 0;
		add(productImage, gbc_productImage);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel countLabel = new JLabel("Count:");
		GridBagConstraints gbc_countLabel = new GridBagConstraints();
		gbc_countLabel.anchor = GridBagConstraints.EAST;
		gbc_countLabel.insets = new Insets(0, 0, 0, 5);
		gbc_countLabel.gridx = 0;
		gbc_countLabel.gridy = 0;
		panel.add(countLabel, gbc_countLabel);
		
		countTextField = new JTextField();
		GridBagConstraints gbc_countTextField = new GridBagConstraints();
		gbc_countTextField.anchor = GridBagConstraints.WEST;
		gbc_countTextField.insets = new Insets(0, 0, 0, 5);
		gbc_countTextField.gridx = 1;
		gbc_countTextField.gridy = 0;
		panel.add(countTextField, gbc_countTextField);
		countTextField.setColumns(10);
		
		JButton saveButton = new JButton("Save");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.anchor = GridBagConstraints.WEST;
		gbc_saveButton.gridx = 2;
		gbc_saveButton.gridy = 0;
		panel.add(saveButton, gbc_saveButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
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
		
		JLabel finalPriceLabel = new JLabel("**final price**");
		GridBagConstraints gbc_finalPriceLabel = new GridBagConstraints();
		gbc_finalPriceLabel.anchor = GridBagConstraints.WEST;
		gbc_finalPriceLabel.gridx = 1;
		gbc_finalPriceLabel.gridy = 0;
		panel_1.add(finalPriceLabel, gbc_finalPriceLabel);

	}

}
