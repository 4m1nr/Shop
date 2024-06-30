import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopControllerImpl{
    User user;
    UserServiceImpl userService;
    ProductServiceImpl productService;
    CartService cartService;
    OrderService orderService;
    LoginFrame loginFrame;
    MainFrame mainFrame;
    private String searchByThis,sortByThis;

    public String getSearchByThis() {return searchByThis;}
    public String getSortByThis() {return sortByThis;}
    public void setSearchByThis(String searchByThis) {this.searchByThis = searchByThis;}
    public void setSortByThis(String sortByThis) {this.sortByThis = sortByThis;}

    public ShopControllerImpl(UserServiceImpl userService, ProductServiceImpl productService, CartService cartService,OrderService orderService){
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
        loginFrame = new LoginFrame();
        mainFrame = new MainFrame(this);
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
        viewProducts(1,"Default","");
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

   
    public void register(String name, String lastName, String phoneNumber, String address, String emailAddress, String password,Double balance) throws SQLException {
        User user = new User(null,name,lastName,phoneNumber,emailAddress,password, 0, new ArrayList<Address>(), new Cart("1","1",null), null);
        try {
            userService.insertUser(user);
            this.user = userService.getUserByPhoneNumber(user.getPhoneNumber());
            this.user.setCart(cartService.createCart(new Cart(this.user.getId(),3+"",null)));
            openDefaultPanel();
        } catch (RuntimeException e) {
            openRegisterPanel(e.getMessage());
        }
    }

   
    public void openRegisterPanel(String errorMessage) {
        loginFrame.setPanel(new SignupPanel(this,errorMessage));
        loginFrame.setVisible(true);
    }


   
    public void addProduct(String name, double price, String image,int stock) throws SQLException {
        productService.insertProduct(new Product(null,name,"",price,stock,null,image,null));
    }

   
    public void addProduct(String productID, String name, double price, int stock, ArrayList<String> category,ArrayList<String> images, String description) {

    }

   
    public void removeProduct(String productID) throws SQLException {
        productService.deleteProductByID(productID);
    }

   
    public void updateProduct(String productID, String name, double price,Rating rating, int stock, ArrayList<String> category, String image, String description) throws SQLException {
            productService.updateProduct(new Product(productID,name,description,price, stock, rating ,image,category));
    }

    public void viewCartByEveryThing(int page) throws SQLException {
        ArrayList<ProductInCartPanel> products = new ArrayList<>();

        HashMap<String,Integer> cartMapFromRS = cartService.extractCartMapFromRS(this.getUser(),page,sortByThis);
        cartMapFromRS.forEach((productID,quantity) -> {
            try {
                Product product = productService.getProduct(productID);
                products.add(new ProductInCartPanel(product,quantity,this));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        while (products.size() < 6) products.add(new ProductInCartPanel(null,0,this));
        mainFrame.setMainPanel(new CartPanel(this,page,products));
    }

    public int maxPageNumCart() throws SQLException{
        return cartService.maxPageNumCart(6);
    }
   
    public void viewCart() throws SQLException {
        viewCartByEveryThing(1);
    }

   
    public void addProductToCart(Product product, int quantity) throws SQLException {
        System.out.println(this.user.getCart().getCartID());
        cartService.addProductToCart(this.user.getCart(),product,quantity);
    }

   
    public void removeProductFromCart(Product product) throws SQLException {
        cartService.deleteProductFromCart(user.getCart(),product);
    }

   
    public void updateProductInCart(Product product, int quantity) throws SQLException {
        if (quantity == 0) removeProductFromCart(product);
        else if (quantity > 0)
        cartService.updateProductQuantity(user.getCart(),product,quantity);
        else return;
        viewCart();
    }

   
    public void checkout() throws SQLException {
        //TODO
        cartService.deleteCart(user.getCart());
        cartService.createCart(user.getCart());
    }

   
    public void viewOrders() {

    }

   
    public void viewOrderDetails(String orderID) {

    }

   
    public void viewProducts(int page,String sortByThis,String searchByThis) throws SQLException {
        setUser();
        this.sortByThis = sortByThis;
        this.searchByThis = searchByThis;
        ArrayList<Product> products = productService.getProductsByEverything(searchByThis,sortByThis,page,6);
        loginFrame.setVisible(false);
        mainFrame.setMainPanel(new AllProductsPanel(
                this.getProductPanelsFromProducts(products), sortByThis , page ,this));
        mainFrame.setVisible(true);
    }

    public int maxPageNum(String sortByThis,String searchByThis) throws SQLException{
        return productService.maxPageNum(6,sortByThis,searchByThis);
    }

    public void viewSearchedProducts(int page,String searchByThis) throws SQLException{
        ArrayList<Product> products = productService.getProductsBySearch(searchByThis,page,6);
        loginFrame.setVisible(false);
        mainFrame.setMainPanel(new AllProductsPanel(
                this.getProductPanelsFromProducts(products), "Default" , page ,this));
        mainFrame.setVisible(true);
    }

    public void viewProductDetails(Product product) throws SQLException {
        setUser();
        product = productService.getProduct(product.getId());
        if (user.getRole().equalsIgnoreCase("admin"))
            mainFrame.setMainPanel(new AdminEditProduct(product,this));
        else
            mainFrame.setMainPanel(new BuyProductPanel(product,this));
    }

    private ArrayList<ProductPanel> getProductPanelsFromProducts(ArrayList<Product> products) {
        ArrayList<ProductPanel> productPanels = new ArrayList<>();
        for (Product product : products) productPanels.add(new ProductPanel(product,this));
        while(productPanels.size() < 6) productPanels.add(new ProductPanel(null,this));
        return productPanels;
    }

    public int openDialog(String message,String title , int type){
        return JOptionPane.showConfirmDialog(null,message,title, JOptionPane.DEFAULT_OPTION);
    }

    private void setUser () throws SQLException {
        if (user != null){
            System.out.println("setting User");
            System.out.println(user.getCart().getUserID());
            System.out.println(user.getCart() == null);
        this.user = userService.getUser(user.getId());}
    }
   
    public void viewProfile(String error) throws SQLException {
        setUser();
        mainFrame.setMainPanel(new ProfilePanel(this,error));
    }

   
    public void updateProfile(User user,String error)throws SQLException {
        this.user = user;
        userService.updateUser(user);
        mainFrame.setMainPanel(new ProfilePanel(this,error));
    }

   
    public void viewUsers() throws SQLException {
        ArrayList <User> users = userService.getAllUsers();
        mainFrame.setMainPanel(new AdminSeeCustomers(users));
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

    public void viewAdminPanel() {
        mainFrame.setMainPanel(new AdminPanel(this));
    }

    public User getUser() throws SQLException {
        setUser();
        return this.user;
    }

    public void viewAddProductPanel() {
        mainFrame.setMainPanel(new AddProductPanel(this));
    }

    public void viewAllOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        orders = orderService.getAllOrders();
        mainFrame.setMainPanel(new AdminSeeOrdersPanel(orders));
    }

    public void upadteUserBalance(Double newBalance) throws SQLException {
        userService.updateUser(new User(this.user.getId(),null,null,null,
                null,null,
                newBalance,null,null,null));
    }
}
