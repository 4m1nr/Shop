import java.io.Serializable;
import java.util.ArrayList;

public class Cart {
    private ArrayList<String> products = new ArrayList<>();

    public Cart(){}
    public Cart(String serializedCart) {
        String[] products = serializedCart.split("-");
        for (int i = 0; i < products.length; i++) this.addProduct(products[i]);
    }

    //getter
    public ArrayList<String> getCart() {return products;}

    //setters
    public void addProduct(Product product) {
        products.add(product.getId());}
    public void addProduct(String ID){
        products.add(ID);}
    public void removeProduct(Product product) {
        products.remove(product.getId());}
    public void removeProduct(String ID) {
        products.remove(ID);}
    public void removeAllProducts() {
        products.clear();}

    public String getSerializedCart(){
        if (products.isEmpty()) return "";
        String string = products.get(0);
        for (int i = 1; i < products.size(); i++) string += "-" + products.get(i);
        return string;
    }


}
