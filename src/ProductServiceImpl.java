import java.sql.*;
import java.util.ArrayList;

public class ProductServiceImpl{
    ProductDAOImpl productDAO;
    public ProductServiceImpl(ProductDAOImpl productDAO) throws SQLException {this.productDAO = productDAO;}

    
    public void insertProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) == null) productDAO.insertProduct(product);
        else throw new RuntimeException("Product already exists");}

    
    public void deleteProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) != null) productDAO.deleteProduct(product);
        else throw new RuntimeException("Product doesn't exist");}

    
    public void deleteProductByID(String id) throws SQLException{
        if(productDAO.getProduct(id) != null) productDAO.deleteProductByID(id);
        else throw new RuntimeException("Product doesn't exist");}

    
    public void updateProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) != null) productDAO.updateProduct(product);
        else throw new RuntimeException("Product doesn't exist");}

    
    public Product getProduct(String id) throws SQLException{
        if(productDAO.getProduct(id) != null) return productDAO.getProduct(id);
        else throw new RuntimeException("Product doesn't exist");}

    
    public ArrayList<Product> getAllProducts() throws SQLException{
        return productDAO.getAllProducts();
    }

    
    public ArrayList<Product> getProductsByCategory(String category) throws SQLException{
        return productDAO.getProductsByCategory(category);
    }

    
    public ArrayList<Product> getProductsByCategorySorted(String category , String sortByThis, int page, int numPerPage) throws SQLException{
        return productDAO.getProductsByCategorySorted(category,sortByThis,page,numPerPage);
    }

    
    public ArrayList<Product> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException{
        return productDAO.getProductsSorted(sortByThis,page,numPerPage);
    }
}
