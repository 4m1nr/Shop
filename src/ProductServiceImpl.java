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

    public ArrayList<Product> getProductsByEverything(String searchByThis,String sortByThis,int page,int numPerPage) throws SQLException{
        switch (sortByThis) {
            case ("Default") -> sortByThis = "id";
            case ("Price: Low to High") -> sortByThis = "price ASC";
            case ("Price: High to Low") -> sortByThis = "price DESC";
            case ("Rating: Low to High") -> sortByThis = "rating ASC";
            case ("Rating: High to Low") -> sortByThis = "rating DESC";
        }

        return productDAO.getProductsByEverything(searchByThis,sortByThis,page,numPerPage);
    }

    public int maxPageNum(int numPerPage,String sortByThis,String searchByThis)throws SQLException{
        return productDAO.maxPageNum(numPerPage,sortByThis,searchByThis);
    }

    public ArrayList<Product> getProductsBySearch(String searchByThis, int page, int numPerPage) throws SQLException{
        return productDAO.getProductsBySearch(searchByThis,page,numPerPage);
    }
}
