import java.util.ArrayList;

public class Order {
    private ArrayList<String> productsId;

    public Order(String serializedOrder) {
        productsId = new ArrayList<>();
        if (serializedOrder != null){
            String[] products = serializedOrder.split("-");
            for (String product : products) this.addProduct(product);
        }
    }

    public Order(Cart cart) {productsId = (ArrayList<String>) cart.getCart().clone();}

    public Order() {
        productsId = new ArrayList<>();
    }

    //getter
    public ArrayList<String> getOrder() {return productsId;}

    //setters
    private void addProduct(Product product)    {productsId.add(product.getId());}
    private void addProduct(String ID)          {productsId.add(ID);}
    private void removeProduct(Product product) {productsId.remove(product.getId());}
    private void removeProduct(String ID)       {productsId.remove(ID);}
    private void removeAllProducts()            {productsId.clear();}

    public String getSerializedOrder() {
        if (productsId.isEmpty()) {
            return null;
        } else {
            StringBuilder string = new StringBuilder();
            for (String product : productsId) string.append(productsId).append("-");
            return string.toString();
        }
    }
}
