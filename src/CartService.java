import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CartService {
    private CartDAO cartDAO;
    public CartService(CartDAO cartDAO) {
        this.cartDAO = cartDAO;
    }
    public Cart getCart(Cart cart) throws SQLException {
        return cartDAO.getCart(cart);
    }

    public void deleteCart(Cart cart) throws SQLException {
        cartDAO.deleteCart(cart);
    }
    public void createCart(Cart cart) throws SQLException {
       cartDAO.createCart(cart);
    }

    public void addProductToCart(Cart cart, Product product, int quantity) throws SQLException {
        cartDAO.addProductToCart(cart, product, quantity);
    }

    public void deleteProductFromCart(Cart cart, Product product) throws SQLException {
        cartDAO.deleteProductFromCart(cart, product);
    }

    public void updateProductQuantity(Cart cart, Product product, int quantity) throws SQLException {
        cartDAO.updateProductQuantity(cart, product, quantity);
    }
}
