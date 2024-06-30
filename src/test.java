import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(null);

        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 300, 300);
        panel.setVisible(true);
        panel.setBackground(Color.CYAN);
        URL url;
        try {
             url = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScn1fENC_uYvSu1-LTY_BJu2NfBh7Uz08frg&s");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        JLabel label = new JLabel(new ImageIcon(url));
        label.setBounds(0, 0, 150, 150);
        label.setBackground(Color.BLUE);
        label.setVisible(true);

        frame.add(label);

        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);

    }
}
