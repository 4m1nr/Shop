import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
    public void insertProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product getProduct(String id) throws SQLException;
    public ArrayList<Product> getAllProducts() throws SQLException;
    public ArrayList<Product> getProductsByCategory(String category) throws SQLException;
    public ArrayList<Product> getProductsByCategorySorted(String category ,String sortByThis,int page,int numPerPage) throws SQLException;
    public ArrayList<Product> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException;
}
