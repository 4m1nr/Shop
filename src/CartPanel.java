import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class CartPanel extends JPanel {


	public CartPanel(ShopControllerImpl controller,int page,ArrayList<ProductInCartPanel> panels1) {


		setBackground(new Color(0, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{15, 528, 15, 0};
		gridBagLayout.rowHeights = new int[]{0, 15, 10, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);


		String sort[]={"Default", "Rate", "Price: low to high", "Price: high to low"};
		JComboBox comboBox = new JComboBox(sort);
		comboBox.setSelectedItem("Default");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//To do: rearranging panels array: if (comboBox.getSelectedIndex()==0 or ==1 or..)...

				//JPanel products= new AllProductsPanel(panels, sort[comboBox.getSelectedIndex()]);
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{166, 166, 166, 0};
		gbl_panel.rowHeights = new int[]{168, 168, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);


		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panels1.get(0), gbc_panel_1);


		//JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panels1.get(1), gbc_panel_2);

		//JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		panel.add(panels1.get(2), gbc_panel_3);

		//JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel.add(panels1.get(3), gbc_panel_4);

		//JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 1;
		panel.add(panels1.get(4), gbc_panel_5);

		//JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 1;
		panel.add(panels1.get(5), gbc_panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 3;
		add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);

		JButton btnNewButton_1 = new JButton("previous");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					/*if(page > 1)*/
					controller.viewCartByEveryThing(page-1);
				}
				catch (SQLException ex){
					throw new RuntimeException(ex.getMessage());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 0;
		panel_7.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton = new JButton("next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					/*if(page < controller.maxPageNum(controller.getSortByThis(), controller.getSearchByThis()))*/
					controller.viewCartByEveryThing(page+1);
				}
				catch (SQLException ex){
					throw new RuntimeException(ex.getMessage());
				}
			}
		});

		JButton buyButton = new JButton("Buy");
		GridBagConstraints gbc_buyButton = new GridBagConstraints();
		gbc_buyButton.insets = new Insets(0, 0, 0, 5);
		gbc_buyButton.gridx = 1;
		gbc_buyButton.gridy = 0;
		panel_7.add(buyButton, gbc_buyButton);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_7.add(btnNewButton, gbc_btnNewButton);

		if (page == 1)
			btnNewButton_1.setVisible(false);
		try {
			if (page >= controller.maxPageNumCart());
				btnNewButton.setVisible(false);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
