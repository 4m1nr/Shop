import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProductPanel(Product product) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//To do
			}
		});
		
		String productName = product.getName();
		String productRate = String.format("%0.1d",product.getRating().getAverage());
		Icon imageIcon=new ImageIcon(product.getImages().get(0));
		
		setBackground(new Color(128, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("product icon");
		lblNewLabel.setBounds(10, 10, 280, 168);
		lblNewLabel.setIcon(imageIcon); //To do
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(productName); //To do
		lblNewLabel_1.setBounds(10, 188, 280, 57); 
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(productRate); //To do
		lblNewLabel_2.setBounds(10, 255, 280, 35);
		add(lblNewLabel_2);

	}
}
