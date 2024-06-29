import javax.swing.*;
import java.sql.SQLException;

public class ShopGUI {

    public static void main(String[] args) {
        ShopControllerImpl controller;
        try {
            controller = new ShopControllerImpl(
                new UserServiceImpl(new UserDAOImpl()),
                new ProductServiceImpl(new ProductDAOImpl())
        );
        controller.openLoginPanel(null);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

}
