import java.sql.*;
import java.util.ArrayList;

public class ProductServiceImpl implements ProductService{
    ProductDAOImpl productDAO;
    public ProductServiceImpl(ProductDAOImpl productDAO) throws SQLException {this.productDAO = productDAO;}

    @Override
    public void insertProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) == null) productDAO.insertProduct(product);
        else throw new RuntimeException("Product already exists");}

    @Override
    public void deleteProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) != null) productDAO.deleteProduct(product);
        else throw new RuntimeException("Product doesn't exist");}

    @Override
    public void deleteProductByID(String id) throws SQLException{
        if(productDAO.getProduct(id) != null) productDAO.deleteProductByID(id);
        else throw new RuntimeException("Product doesn't exist");}

    @Override
    public void updateProduct(Product product) throws SQLException{
        if(productDAO.getProduct(product.getId()) != null) productDAO.updateProduct(product);
        else throw new RuntimeException("Product doesn't exist");}

    @Override
    public Product getProduct(String id) throws SQLException{
        if(productDAO.getProduct(id) != null) return productDAO.getProduct(id);
        else throw new RuntimeException("Product doesn't exist");}

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException{
        ArrayList<Product> products = productDAO.getAllProducts();
        while(products.size() < 6) products.add(null);
        return products;}

    @Override
    public ArrayList<ProductPanel> getProductsByCategory(String category) throws SQLException{
        ArrayList<Product> products = productDAO.getProductsByCategory(category);
        return getProductPanelsFromProducts(products);
    }

    @Override
    public ArrayList<ProductPanel> getProductsByCategorySorted(String category , String sortByThis, int page, int numPerPage) throws SQLException{
        ArrayList<Product> products = productDAO.getProductsByCategorySorted(category,sortByThis,page,numPerPage);
        return getProductPanelsFromProducts(products);
    }

    @Override
    public ArrayList<ProductPanel> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException{
        ArrayList<Product> products = productDAO.getProductsSorted(sortByThis,page,numPerPage);
        return getProductPanelsFromProducts(products);
    }

    private ArrayList<ProductPanel> getProductPanelsFromProducts(ArrayList<Product> products) {
        ArrayList<ProductPanel> productPanels = new ArrayList<>();
        for (Product product : products) productPanels.add(new ProductPanel(product));
        while(productPanels.size() < 6) productPanels.add(new ProductPanel(null));
        return productPanels;
    }
}
