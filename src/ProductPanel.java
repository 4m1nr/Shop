import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.sql.SQLException;

public class ProductPanel extends JPanel {
	ShopControllerImpl controller;

	public ProductPanel(Product product, ShopControllerImpl controller) {
		this.controller = controller;
		buildPanel();
		if (product != null) {
			String productName = product.getName();
			String productRate = /*String.format("%0.1f", product.getRating().getAverage());*/5 + "";
			Icon imageIcon = new ImageIcon(/*roduct.getImages().get(0)*/);
			String productPrice = product.getPrice() + "";


			JLabel iconLabel = new JLabel();
			iconLabel.setIcon(imageIcon);
			GridBagConstraints gbc_iconLabel = new GridBagConstraints();
			gbc_iconLabel.fill = GridBagConstraints.VERTICAL;
			gbc_iconLabel.insets = new Insets(0, 0, 5, 0);
			gbc_iconLabel.gridx = 0;
			gbc_iconLabel.gridy = 0;
			add(iconLabel, gbc_iconLabel);

			JLabel nameLabel = new JLabel(productName);
			GridBagConstraints gbc_nameLabel = new GridBagConstraints();
			gbc_nameLabel.fill = GridBagConstraints.BOTH;
			gbc_nameLabel.insets = new Insets(0, 0, 5, 0);
			gbc_nameLabel.gridx = 0;
			gbc_nameLabel.gridy = 1;
			add(nameLabel, gbc_nameLabel);

			JLabel rateLabel = new JLabel(productRate);
			GridBagConstraints gbc_rateLabel = new GridBagConstraints();
			gbc_rateLabel.insets = new Insets(0, 0, 5, 0);
			gbc_rateLabel.fill = GridBagConstraints.BOTH;
			gbc_rateLabel.gridx = 0;
			gbc_rateLabel.gridy = 2;
			add(rateLabel, gbc_rateLabel);

			JLabel priceLabel = new JLabel(productPrice);
			GridBagConstraints gbc_priceLabel = new GridBagConstraints();
			gbc_priceLabel.gridx = 0;
			gbc_priceLabel.gridy = 3;
			add(priceLabel, gbc_priceLabel);

			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
                    try {
                        controller.viewProductDetails(product);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
			});
		}

	}

	private void buildPanel(){
		setBackground(new Color(128, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{280, 0};
		gridBagLayout.rowHeights = new int[]{277, 25, 25, 25, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
}
