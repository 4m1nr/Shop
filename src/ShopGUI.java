import javax.swing.*;

public class ShopGUI {

    public static void main(String[] args) {
        ShopController controller = new ShopControllerImpl();
        new LoginFrame(new LoginPanel(controller));
    }

}
