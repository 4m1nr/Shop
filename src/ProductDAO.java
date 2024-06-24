import java.util.ArrayList;

public interface ProductDAO {
    public void insertProduct(Product product);
    public void deleteProduct(Product product);
    public void updateProduct(Product product);
    public Product getProduct(String id);
    public ArrayList<Product> getAllProducts();
}
