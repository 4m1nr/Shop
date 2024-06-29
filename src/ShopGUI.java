import javax.swing.*;

public class ShopGUI {

    public static void main(String[] args) {
        try {

        ShopControllerImpl controller = new ShopControllerImpl(
                new UserServiceImpl(new UserDAOImpl()),
                new ProductServiceImpl(new ProductDAOImpl())
        );
        controller.openLoginPanel(null);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}
