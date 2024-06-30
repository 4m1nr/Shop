import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JLabel;

public class AdminSeeOrdersPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public AdminSeeOrdersPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 2, 75, 74, 10, 0};
		gridBagLayout.rowHeights = new int[]{10, 0, 358, 15, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		String[] columnNames = { "Customer ID", "Final price", "Verified" };
		String data[][] = new String[25][3];
		//Hint for Amin: data[i][0] is customer ID, data[i][1] is Final Price, data[i][2] is verified or not (pul dade ya na),
		
		JLabel lblNewLabel = new JLabel("Customer ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Price");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Verified");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 1;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		JTable table = new JTable(data, columnNames);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		add(table, gbc_table);
		
		JButton previousButton = new JButton("Previous");
		GridBagConstraints gbc_previousButton = new GridBagConstraints();
		gbc_previousButton.insets = new Insets(0, 0, 0, 5);
		gbc_previousButton.gridx = 1;
		gbc_previousButton.gridy = 3;
		add(previousButton, gbc_previousButton);
		
		JButton nextButton = new JButton("Next");
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.insets = new Insets(0, 0, 0, 5);
		gbc_nextButton.gridx = 3;
		gbc_nextButton.gridy = 3;
		add(nextButton, gbc_nextButton);

	}

}
