import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;

public class LoginFrame extends JFrame {

	public LoginFrame(JPanel panelToAdd) {
		this.buildFrame();
        this.add(panelToAdd);
		this.pack();
		this.setVisible(true);
	}

	private void buildFrame(){
		setMinimumSize(new Dimension(500, 350));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 386);
	}

}
