import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
    public void insertProduct(Product product) throws SQLException;
    public void deleteProduct(Product product) throws SQLException;

    void deleteProductByID(String id) throws SQLException;

    public void updateProduct(Product product) throws SQLException;
    public Product getProduct(String id) throws SQLException;
    public ArrayList<Product> getAllProducts() throws SQLException;
    public ArrayList<ProductPanel> getProductsByCategory(String category) throws SQLException;
    public ArrayList<ProductPanel> getProductsByCategorySorted(String category , String sortByThis, int page, int numPerPage) throws SQLException;
    public ArrayList<ProductPanel> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException;
}
