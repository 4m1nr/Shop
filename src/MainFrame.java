import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	JPanel currentPanel;
	private JPanel contentPane;


	public MainFrame() {
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

		HeaderPanel headerPanel = new HeaderPanel();
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

		this.update();
	}

	public JPanel getPanel(){
		return currentPanel;
	}

	public void update(){
		this.revalidate();
		this.repaint();
	}
}
