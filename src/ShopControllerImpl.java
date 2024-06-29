import java.sql.SQLException;
import java.util.ArrayList;

public class ShopControllerImpl{
    User user;
    UserServiceImpl userService;
    ProductServiceImpl productService;
    LoginFrame loginFrame;
    MainFrame mainFrame;
    private String searchByThis,sortByThis;

    public String getSearchByThis() {return searchByThis;}
    public String getSortByThis() {return sortByThis;}
    public void setSearchByThis(String searchByThis) {this.searchByThis = searchByThis;}
    public void setSortByThis(String sortByThis) {this.sortByThis = sortByThis;}

    public ShopControllerImpl(UserServiceImpl userService, ProductServiceImpl productService){
        this.userService = userService;
        this.productService = productService;
        loginFrame = new LoginFrame();
        mainFrame = new MainFrame(user,this);
    }

    public void login(String phoneNumber, String password) throws SQLException {
        User user = null;
        try {
            user = userService.getUserByPhoneNumber(phoneNumber);
        } catch (RuntimeException e) {
            openLoginPanel(e.getMessage());
        }
        if (user != null) {
            if (user.checkPassword(password)) {
                this.user = user;
                openDefaultPanel();
            } else
                openLoginPanel("password incorrect");
        }
    }

    public void openDefaultPanel() throws SQLException {
        viewProducts(1,"Default");
    }

    public void openLoginPanel(String errorMessage){
        mainFrame.setVisible(false);
        loginFrame.setPanel(new LoginPanel(this,errorMessage));
        loginFrame.setVisible(true);
    }

    public void logout() throws SQLException{
        this.user = null;
        openLoginPanel(null);
    }

   
    public Object register(String name, String lastName, String phoneNumber, String address, String emailAddress, String password,Double balance) throws SQLException {
        User user = new User(null,name,lastName,phoneNumber,emailAddress,password, 0, new ArrayList<Address>(), new Cart(), null);
        try {
            userService.insertUser(user);
            if (user != null)
                this.user = user;
                openDefaultPanel();
        } catch (RuntimeException e) {
            openRegisterPanel(e.getMessage());
        }
        return null;
    }

   
    public void openRegisterPanel(String errorMessage) {
        loginFrame.setPanel(new SignupPanel(this,errorMessage));
        loginFrame.setVisible(true);
    }


   
    public void addProduct(String name, double price, int stock, String category, String description) {

    }

   
    public void addProduct(String productID, String name, double price, int stock, ArrayList<String> category,ArrayList<String> images, String description) {

    }

   
    public void removeProduct(String productID) throws SQLException {
        productService.deleteProductByID(productID);
    }

   
    public void updateProduct(String productID, String name, double price,Rating rating, int stock, ArrayList<String> category, ArrayList<String> images, String description) throws SQLException {
            productService.updateProduct(new Product(productID,name,description,price, stock, rating ,images,category));
    }

   
    public void viewCart() {

    }

   
    public void addProductToCart(String productID, int quantity) {

    }

   
    public void removeProductFromCart(String productID) {

    }

   
    public void updateProductInCart(String productID, int quantity) {

    }

   
    public void checkout() {

    }

   
    public void viewOrders() {

    }

   
    public void viewOrderDetails(String orderID) {

    }

   
    public void viewProducts(int page,String sortByThis,String searchByThis) throws SQLException {
        this.sortByThis = sortByThis;
        this.searchByThis = searchByThis;
        ArrayList<Product> products = productService.getProductsByEverything(searchByThis,sortByThis,page,6);
        loginFrame.setVisible(false);
        mainFrame.setMainPanel(new AllProductsPanel(
                this.getProductPanelsFromProducts(products), sortByThis , page ,this));
        mainFrame.setVisible(true);
    }

    public void viewSearchedProducts(int page,String searchByThis) throws SQLException{
        ArrayList<Product> products = productService.getProductsBySearch(searchByThis,page,6);
        loginFrame.setVisible(false);
        mainFrame.setMainPanel(new AllProductsPanel(
                this.getProductPanelsFromProducts(products), "Default" , page ,this));
        mainFrame.setVisible(true);
    }

    public void viewProductDetails(Product product) throws SQLException {
        product = productService.getProduct(product.getId());
        mainFrame.setMainPanel(new BuyProductPanel(product , this));
    }

    private ArrayList<ProductPanel> getProductPanelsFromProducts(ArrayList<Product> products) {
        ArrayList<ProductPanel> productPanels = new ArrayList<>();
        for (Product product : products) productPanels.add(new ProductPanel(product,this));
        while(productPanels.size() < 6) productPanels.add(new ProductPanel(null,this));
        return productPanels;
    }

   
    public void viewProfile() {

    }

   
    public void updateProfile(String userID, String password) {

    }

   
    public void viewUsers() {

    }

   
    public void viewUserDetails(String ID) {

    }

   
    public void changeUserRole(String ID, String role) {

    }

   
    public void removeUser(String username) {

    }

   
    public void viewUserOrders(String userId) {

    }

   
    public void viewUserOrderDetails(String userID, String orderID) {

    }

   
    public void viewUserCart(String username) {

    }

   
    public void viewUserProfile(String userId) {

    }
}
