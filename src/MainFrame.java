import java.awt.*;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	JPanel currentPanel;
	HeaderPanel headerPanel;
	private JPanel contentPane;
	ShopControllerImpl controller;
	User user;



	public MainFrame(ShopControllerImpl controller) {
		this.controller = controller;
        try {
            this.user = controller.getUser();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        buildFrame();
	}

	private void buildFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout contentPaneGBLayout = new GridBagLayout();
		contentPaneGBLayout.columnWidths = new int[]{562, 0};
		contentPaneGBLayout.rowHeights = new int[]{50, 400, 0};
		contentPaneGBLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPaneGBLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(contentPaneGBLayout);

		headerPanel = new HeaderPanel(controller);
		headerPanel.updateAdmin();
		GridBagConstraints headerGBC = new GridBagConstraints();
		headerGBC.fill = GridBagConstraints.BOTH;
		headerGBC.insets = new Insets(0, 0, 5, 0);
		headerGBC.gridx = 0;
		headerGBC.gridy = 0;
		contentPane.add(headerPanel, headerGBC);
	}

	public void setMainPanel(JPanel panelToSet){
		if (currentPanel != null)
			this.contentPane.remove(currentPanel);

		GridBagConstraints MainPanelGBC = new GridBagConstraints();
		MainPanelGBC.fill = GridBagConstraints.BOTH;
		MainPanelGBC.gridx = 0;
		MainPanelGBC.gridy = 1;

		contentPane.add(panelToSet, MainPanelGBC);
		currentPanel = panelToSet;
		headerPanel.updateAdmin();
		this.repaintAndRevalidate();
	}

	public JPanel getPanel(){
		return currentPanel;
	}

	public void repaintAndRevalidate(){
		this.revalidate();
		this.repaint();
	}
}
