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

    public HashMap<String,Integer> extractCartMapFromRS(User user,int page,String sortByThis) throws SQLException {
        switch (sortByThis) {
            case ("Default") -> sortByThis = "product_id";
            case ("Price: Low to High") -> sortByThis = "price ASC";
            case ("Price: High to Low") -> sortByThis = "price DESC";
            case ("Rating: Low to High") -> sortByThis = "rating ASC";
            case ("Rating: High to Low") -> sortByThis = "rating DESC";
        }

        return cartDAO.extractCartMapFromRS(user, page, sortByThis);
    }

    public int maxPageNumCart(int numPerPage)throws SQLException{
        return cartDAO.maxPageNumCart(numPerPage);
    }

    public Cart createCart(Cart cart) throws SQLException {
       return cartDAO.createCart(cart);
    }

    public void addProductToCart(Cart cart, Product product, int quantity) throws SQLException {
        System.out.println(cart.getCartID());
        cartDAO.addProductToCart(cart, product, quantity);
    }

    public void deleteProductFromCart(Cart cart, Product product) throws SQLException {
        cartDAO.deleteProductFromCart(cart, product);
    }

    public void updateProductQuantity(Cart cart, Product product, int quantity) throws SQLException {
        cartDAO.updateProductQuantity(cart, product, quantity);
    }
}
