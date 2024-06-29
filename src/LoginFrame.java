import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginFrame extends JFrame {
	JPanel currentPanel;

	public LoginFrame(JPanel panelToSet) {
		this.buildFrame();
        this.setPanel(panelToSet);
		this.pack();
		this.setVisible(true);
	}

	public LoginFrame() {
		this.buildFrame();
		this.setVisible(false);
	}

	private void buildFrame(){
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 386);
	}

	public void setPanel(JPanel panelToSet){
		if (currentPanel != null)
			this.remove(currentPanel);

		this.add(panelToSet);
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
