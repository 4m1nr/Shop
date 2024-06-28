import java.sql.*;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService{
    ProductDAOImpl productDAO;
    public ProductServiceImpl(Connection connection) throws SQLException {
        this.productDAO = new ProductDAOImpl(connection);}

    @Override
    public void insertProduct(Product product) throws SQLException{
        productDAO.insertProduct(product);}

    @Override
    public void deleteProduct(Product product) throws SQLException{
        productDAO.deleteProduct(product);}

    @Override
    public void updateProduct(Product product) throws SQLException{
        productDAO.updateProduct(product);}

    @Override
    public Product getProduct(String id) throws SQLException{
        return getProduct(id);}

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException{
        return productDAO.getAllProducts();}

    @Override
    public ArrayList<Product> getProductsByCategory(String category) throws SQLException{
        return getProductsByCategory(category);}

    @Override
    public ArrayList<Product> getProductsByCategorySorted(String category ,String sortByThis,int page,int numPerPage) throws SQLException{
        return getProductsByCategorySorted(category,sortByThis,page,numPerPage);}

    @Override
    public ArrayList<Product> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException{
        return getProductsSorted(sortByThis,page,numPerPage);
    }
}
