import java.util.ArrayList;

public interface ShopController {
    public Object login(String phoneNumber, String password);
    public void logout();
    public Object register(String phoneNumber, String passwordFirst, String passwordSecond);

    public void addProduct(String name, double price, int stock, String category, String description);

    void addProduct(String productID, String name, double price, int stock, String category, String description);

    public void removeProduct(String productID);
    public Object updateProduct(String productID, String name, double price, int stock, String category, String description);

    public void viewCart();
    public void addProductToCart(String productID, int quantity);
    public void removeProductFromCart(String productID);
    public void updateProductInCart(String productID, int quantity);
    public void checkout();

    public void viewOrders();
    public void viewOrderDetails(String orderID);

    public void viewProducts();
    public void viewProductDetails(String productID);

    public void viewProfile();
    public void updateProfile(String userID, String password);

    public void viewUsers();
    public void viewUserDetails(String ID);
    public void changeUserRole(String ID, String role);
    public void removeUser(String username);

    public void viewUserOrders(String userId);
    public void viewUserOrderDetails(String userID, String orderID);
    public void viewUserCart(String username);
    public void viewUserProfile(String userId);
}
