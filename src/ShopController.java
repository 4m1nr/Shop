import java.sql.SQLException;
import java.util.ArrayList;

public interface ShopController {
    public Object login(String phoneNumber, String password)throws SQLException;
    public void logout()throws SQLException;
    public Object register(String phoneNumber, String passwordFirst, String passwordSecond)throws SQLException;

    public void addProduct(String name, double price, int stock, String category, String description)throws SQLException;

    void addProduct(String productID, String name, double price, int stock,ArrayList <String>category,ArrayList<String> images, String description)throws SQLException;

    public void removeProduct(String productID)throws SQLException;
    public void updateProduct(String productID, String name, double price, int stock,ArrayList <String>category,ArrayList<String> images, String description)throws SQLException;

    public void viewCart()throws SQLException;
    public void addProductToCart(String productID, int quantity)throws SQLException;
    public void removeProductFromCart(String productID)throws SQLException;
    public void updateProductInCart(String productID, int quantity)throws SQLException;
    public void checkout()throws SQLException;

    public void viewOrders()throws SQLException;
    public void viewOrderDetails(String orderID)throws SQLException;

    public void viewProducts()throws SQLException;
    public void viewProductDetails(String productID)throws SQLException;

    public void viewProfile()throws SQLException;
    public void updateProfile(String userID, String password)throws SQLException;

    public void viewUsers()throws SQLException;
    public void viewUserDetails(String ID)throws SQLException;
    public void changeUserRole(String ID, String role)throws SQLException;
    public void removeUser(String username)throws SQLException;

    public void viewUserOrders(String userId)throws SQLException;
    public void viewUserOrderDetails(String userID, String orderID)throws SQLException;
    public void viewUserCart(String username)throws SQLException;
    public void viewUserProfile(String userId)throws SQLException;
}
