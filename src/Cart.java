import java.io.Serializable;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<    >();

    //getter
    public ArrayList<Product> getCart() {return products;}

    //setters
    public void addProduct(Product product) {
        products.add(product);}
    public void removeProduct(Product product) {
        products.remove(product);}
    public void removeProduct(int index) {
        products.remove(index);}
    public void removeAllProducts() {
        products.clear();}
}
