import java.util.ArrayList;

public class Order {
    private ArrayList<String> productsId;
    private String userID;

    public Order(String serializedOrder) {
        productsId = new ArrayList<>();
        this.setUserID(serializedOrder.split(":")[0]);
        String[] products = serializedOrder.split(":")[1].split("-");
        for (String product : products) this.addProduct(product);
    }

    public Order(Cart cart,String userID) {
        productsId = (ArrayList<String>) cart.getCart().clone();
        this.setUserID(userID);
    }

    //getter
    public ArrayList<String> getOrder() {return productsId;}
    public String getUserID() {return userID;}

    //setters
    private void addProduct(Product product)    {productsId.add(product.getId());}
    private void addProduct(String ID)          {productsId.add(ID);}
    private void removeProduct(Product product) {productsId.remove(product.getId());}
    private void removeProduct(String ID)       {productsId.remove(ID);}
    private void removeAllProducts()            {productsId.clear();}
    private void setUserID(String userID)       {this.userID = userID;}

    public String getSerializedOrder() {
        if (productsId.isEmpty()) {
            return null;
        } else {
            StringBuilder string = new StringBuilder();
            for (String product : productsId) string.append(productsId).append("-");
            return userID + ":" + string.toString();
        }
    }
}
