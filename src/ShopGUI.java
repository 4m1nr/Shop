import javax.swing.*;
import java.sql.SQLException;

public class ShopGUI {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        ShopControllerImpl controller;
        try {
            controller = new ShopControllerImpl(
                new UserServiceImpl(new UserDAOImpl()),
                new ProductServiceImpl(new ProductDAOImpl()),
                new CartService(new CartDAO()),
                new OrderService(new OrderDAO())
        );
        controller.openLoginPanel(null);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}
