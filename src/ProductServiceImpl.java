import java.sql.*;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService{
    ProductDAOImpl productDAO;
    public ProductServiceImpl(ProductDAOImpl productDAO) throws SQLException {this.productDAO = productDAO;}

    @Override
    public void insertProduct(Product product) throws SQLException{
        productDAO.insertProduct(product);}

    @Override
    public void deleteProduct(Product product) throws SQLException{
        productDAO.deleteProduct(product);}

    @Override
    public void deleteProductByID(String id) throws SQLException{
        productDAO.deleteProductByID(id);}

    @Override
    public void updateProduct(Product product) throws SQLException{
        productDAO.updateProduct(product);}

    @Override
    public Product getProduct(String id) throws SQLException{
        return productDAO.getProduct(id);}

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException{
        return productDAO.getAllProducts();}

    @Override
    public ArrayList<Product> getProductsByCategory(String category) throws SQLException{
        return productDAO.getProductsByCategory(category);}

    @Override
    public ArrayList<Product> getProductsByCategorySorted(String category ,String sortByThis,int page,int numPerPage) throws SQLException{
        return productDAO.getProductsByCategorySorted(category,sortByThis,page,numPerPage);}

    @Override
    public ArrayList<Product> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException{
        return productDAO.getProductsSorted(sortByThis,page,numPerPage);
    }
}
