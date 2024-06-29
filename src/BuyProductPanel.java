import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyProductPanel extends JPanel {
	private JTextField rateTextField;
	private JTextField countTextField;
	Product product;


	public BuyProductPanel(Product product) {

		buildPanel();
		
		JLabel imageLabel = new JLabel(/*product.getImages().get(0)*/);
		imageLabel.setIcon(null);
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.gridwidth = 2;
		gbc_imageLabel.insets = new Insets(0, 0, 5, 0);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		add(imageLabel, gbc_imageLabel);
		
		JPanel ratePanel = new JPanel();
		GridBagConstraints gbc_ratePanel = new GridBagConstraints();
		gbc_ratePanel.insets = new Insets(0, 0, 0, 5);
		gbc_ratePanel.fill = GridBagConstraints.BOTH;
		gbc_ratePanel.gridx = 0;
		gbc_ratePanel.gridy = 1;
		add(ratePanel, gbc_ratePanel);
		GridBagLayout gbl_ratePanel = new GridBagLayout();
		gbl_ratePanel.columnWidths = new int[]{0, 0, 0};
		gbl_ratePanel.rowHeights = new int[]{0, 0, 0};
		gbl_ratePanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_ratePanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		ratePanel.setLayout(gbl_ratePanel);
		
		JLabel productRateLabel = new JLabel("Product rate:");
		productRateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_productRateLabel = new GridBagConstraints();
		gbc_productRateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_productRateLabel.anchor = GridBagConstraints.EAST;
		gbc_productRateLabel.gridx = 0;
		gbc_productRateLabel.gridy = 0;
		ratePanel.add(productRateLabel, gbc_productRateLabel);
		
		JLabel rateLabel = new JLabel("Rate label");
		rateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rateLabel = new GridBagConstraints();
		gbc_rateLabel.insets = new Insets(0, 0, 5, 0);
		gbc_rateLabel.anchor = GridBagConstraints.WEST;
		gbc_rateLabel.gridx = 1;
		gbc_rateLabel.gridy = 0;
		ratePanel.add(rateLabel, gbc_rateLabel);
		
		rateTextField = new JTextField(/*product.getRating()*/);
		rateTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rateTextField = new GridBagConstraints();
		gbc_rateTextField.insets = new Insets(0, 0, 0, 5);
		gbc_rateTextField.anchor = GridBagConstraints.EAST;
		gbc_rateTextField.gridx = 0;
		gbc_rateTextField.gridy = 1;
		ratePanel.add(rateTextField, gbc_rateTextField);
		rateTextField.setColumns(2);
		
		JButton rateButton = new JButton("Rate!");
		rateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rate=Integer.parseInt(rateTextField.getText());
				//To do: har balayi khasti sare rate biar BDSM!!
			}
		});
		rateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_rateButton = new GridBagConstraints();
		gbc_rateButton.anchor = GridBagConstraints.WEST;
		gbc_rateButton.gridx = 1;
		gbc_rateButton.gridy = 1;
		ratePanel.add(rateButton, gbc_rateButton);
		
		JPanel pricePanel = new JPanel();
		GridBagConstraints gbc_pricePanel = new GridBagConstraints();
		gbc_pricePanel.fill = GridBagConstraints.BOTH;
		gbc_pricePanel.gridx = 1;
		gbc_pricePanel.gridy = 1;
		add(pricePanel, gbc_pricePanel);
		GridBagLayout gbl_pricePanel = new GridBagLayout();
		gbl_pricePanel.columnWidths = new int[]{0, 0, 0};
		gbl_pricePanel.rowHeights = new int[]{52, 43, 0};
		gbl_pricePanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_pricePanel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pricePanel.setLayout(gbl_pricePanel);
		
		JLabel productPriceLabel = new JLabel("Product price:");
		productPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_productPriceLabel = new GridBagConstraints();
		gbc_productPriceLabel.anchor = GridBagConstraints.EAST;
		gbc_productPriceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_productPriceLabel.gridx = 0;
		gbc_productPriceLabel.gridy = 0;
		pricePanel.add(productPriceLabel, gbc_productPriceLabel);
		
		JLabel priceLabel = new JLabel(product.getPrice() + "");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.WEST;
		gbc_priceLabel.insets = new Insets(0, 0, 5, 0);
		gbc_priceLabel.gridx = 1;
		gbc_priceLabel.gridy = 0;
		pricePanel.add(priceLabel, gbc_priceLabel);
		
		countTextField = new JTextField();
		countTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_countTextField = new GridBagConstraints();
		gbc_countTextField.anchor = GridBagConstraints.EAST;
		gbc_countTextField.insets = new Insets(0, 0, 0, 5);
		gbc_countTextField.gridx = 0;
		gbc_countTextField.gridy = 1;
		pricePanel.add(countTextField, gbc_countTextField);
		countTextField.setColumns(2);
		
		JButton addToBasketButton = new JButton("Add to Cart");
		addToBasketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=Integer.parseInt(countTextField.getText());
				int wholePrice=(Integer.parseInt(priceLabel.getText()))*count;
				
				//To do: count: teEdade kharid     wholePrice: gheymate kol
			}
		});
		addToBasketButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_addToBasketButton = new GridBagConstraints();
		gbc_addToBasketButton.anchor = GridBagConstraints.WEST;
		gbc_addToBasketButton.gridx = 1;
		gbc_addToBasketButton.gridy = 1;
		pricePanel.add(addToBasketButton, gbc_addToBasketButton);
	}

	public void buildPanel(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{234, 0, 0};
		gridBagLayout.rowHeights = new int[]{303, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}

}
