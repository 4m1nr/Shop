import java.util.HashMap;

public class Order {
    private HashMap<String,Integer> productsId;
    private final String userID;
    private final String orderID;
    String status;

    public Order(String orderId, Cart cart,String status) {
        this.orderID = orderId;
        this.userID = cart.getUserID();
        this.productsId = cart.getCartMap();
        this.status = status;
    }

    public Order(String userId, String orderId, HashMap<String, Integer> orderMap,String status) {
        this.userID = userId;
        this.orderID = orderId;
        this.productsId = orderMap;
        this.status = status;
    }


    //getter
    public HashMap<String,Integer> getOrder() {return productsId;}
    public String getUserID() {return userID;}
    public String getOrderID() {return orderID;}
    public String getStatus() {return status;}

    //setters
    public void setStatus(String status) {this.status = status;}
}
