import java.util.ArrayList;

public class Cart {
    private ArrayList<String> productsId;

    public Cart(String serializedCart) {
        productsId = new ArrayList<>();
        if (serializedCart != null){
            String[] products = serializedCart.split("-");
            for (String product : products) this.addProduct(product);
        }
    }

    //getter
    public ArrayList<String> getCart() {return productsId;}

    //setters
    public void addProduct(Product product) {
        productsId.add(product.getId());}
    public void addProduct(String ID){
        productsId.add(ID);}
    public void removeProduct(Product product) {
        productsId.remove(product.getId());}
    public void removeProduct(String ID) {
        productsId.remove(ID);}
    public void removeAllProducts() {
        productsId.clear();}

    public String getSerializedCart(){
        if (productsId.isEmpty()){
            return null;
        }else{
        StringBuilder string = new StringBuilder();
        for (String product : productsId ) string.append(productsId).append("-");
        return string.toString();
        }
    }


}
