import java.util.ArrayList;

public class ShopControllerImpl implements ShopController{
    @Override
    public Object login(String phoneNumber, String password) {
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public Object register(String phoneNumber, String passwordFirst, String passwordSecond) {
        return null;
    }

    @Override
    public void addProduct(String name, double price, int stock, ArrayList<String> category, ArrayList<String> images, String description) {

    }

    @Override
    public void removeProduct(String productID) {

    }

    @Override
    public Object updateProduct(String productID, String name, double price, int stock, String category, String description) {

        return null;
    }

    @Override
    public void viewCart() {

    }

    @Override
    public void addProductToCart(String productID, int quantity) {

    }

    @Override
    public void removeProductFromCart(String productID) {

    }

    @Override
    public void updateProductInCart(String productID, int quantity) {

    }

    @Override
    public void checkout() {

    }

    @Override
    public void viewOrders() {

    }

    @Override
    public void viewOrderDetails(String orderID) {

    }

    @Override
    public void viewProducts() {

    }

    @Override
    public void viewProductDetails(String productID) {

    }

    @Override
    public void viewProfile() {

    }

    @Override
    public void updateProfile(String userID, String password) {

    }

    @Override
    public void viewUsers() {

    }

    @Override
    public void viewUserDetails(String ID) {

    }

    @Override
    public void changeUserRole(String ID, String role) {

    }

    @Override
    public void removeUser(String username) {

    }

    @Override
    public void viewUserOrders(String userId) {

    }

    @Override
    public void viewUserOrderDetails(String userID, String orderID) {

    }

    @Override
    public void viewUserCart(String username) {

    }

    @Override
    public void viewUserProfile(String userId) {

    }
}
