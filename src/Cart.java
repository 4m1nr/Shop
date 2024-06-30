import com.mysql.cj.conf.ConnectionUrlParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private HashMap<String,Integer> productsId;
    private String userID;
    private String cartID;

    public Cart(String userID, String cartID, HashMap<String, Integer> productsId) {
        this.userID = userID;
        this.cartID = cartID;
        this.productsId = productsId;
    }


    //getter
    public HashMap<String,Integer> getCartMap() {return productsId;}
    public String getUserID() {return userID;}
    public String getCartID() {return cartID;}

    //setters
    public void addProduct(Product product, int quantity)    {productsId.put(product.getId() ,quantity);}
    public void removeProduct(Product product) {productsId.remove(product.getId());}
    public void removeAllProducts()            {productsId.clear();}



}
