import java.sql.SQLException;

public class ShopControllerImpl implements ShopController{
    User user;

    UserServiceImpl userService;
    ProductServiceImpl productService;

    public ShopControllerImpl(UserServiceImpl userService,ProductServiceImpl productService){
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public void login(String phoneNumber, String password) throws SQLException {
        try {
            user = userService.getUserByPhoneNumber(phoneNumber);
        } catch (RuntimeException e) {
            new LoginFrame(new LoginPanel(this,e.getMessage()));
        }
        new MainFrame();
    }

    public void openLoginPanel(){
        new LoginFrame(new LoginPanel(this,null));
    }


    @Override
    public void logout() throws SQLException{
        this.user = null;
        new LoginFrame(new LoginPanel(this));
    }

    @Override
    public Object register(String phoneNumber, String passwordFirst, String passwordSecond) {

    }

    @Override
    public void openRegisterPanel() {
        new LoginFrame(new SignupPanel(this));
    }


    @Override
    public void addProduct(String name, double price, int stock, String category, String description) {

    }

    @Override
    public void addProduct(String productID, String name, double price, int stock, ArrayList<String> category,ArrayList<String> images, String description) {

    }

    @Override
    public void removeProduct(String productID) throws SQLException {
        productService.deleteProductByID(productID);
    }

    @Override
    public void updateProduct(String productID, String name, double price, int stock, ArrayList<String> category,ArrayList<String> images, String description) throws SQLException {
            productService.updateProduct(new Product(productID,name,description,price,stock,images,category));
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
