import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class AdminSeeOrdersPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	Double sum;
	/**
	 * Create the panel.
	 */
	public AdminSeeOrdersPanel(ArrayList<Order> orders) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 2, 75, 82, 10, 0};
		gridBagLayout.rowHeights = new int[]{25, 358, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		String[] columnNames = { "Customer ID", "Final price", "Verified" };
		String[][] data;
		data = new String[orders.size()][3];
		orders.forEach(order -> {
			data[orders.indexOf(order)][0] = order.getUserID();
			data[orders.indexOf(order)][1] = order.getPrice() + "\t\t\t";
			data[orders.indexOf(order)][2] = order.getStatus() + "\t\t\t";
		});

		sum = 0.0;
		orders.forEach(order -> {
			sum += order.getPrice();
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		JTable table_1 = new JTable(data, columnNames);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel sumLabel = new JLabel("Sum:");
		GridBagConstraints gbc_sumLabel = new GridBagConstraints();
		gbc_sumLabel.insets = new Insets(0, 0, 0, 5);
		gbc_sumLabel.gridx = 0;
		gbc_sumLabel.gridy = 0;
		panel.add(sumLabel, gbc_sumLabel);
		
		JLabel sumForRealLabel = new JLabel(sum + "");
		GridBagConstraints gbc_sumForRealLabel = new GridBagConstraints();
		gbc_sumForRealLabel.anchor = GridBagConstraints.WEST;
		gbc_sumForRealLabel.gridx = 1;
		gbc_sumForRealLabel.gridy = 0;
		panel.add(sumForRealLabel, gbc_sumForRealLabel);

	}

}
