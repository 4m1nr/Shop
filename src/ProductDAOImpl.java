import java.sql.*;
import java.util.ArrayList;

public class ProductDAOImpl implements ProductDAO{
    Connection connection;
    Statement statement;
    String tableName = "Products";
    String host;
    String username,password;
    ProductDAOImpl(Connection connection) throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        StringBuilder SQL = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
        SQL.append(product.getId()).append(", ");
        SQL.append(product.getName() + ", ");
        SQL.append(product.getDescription() + ", ");
        SQL.append(product.getPrice() + ", ");
        SQL.append(product.getStock() + ", ");
        SQL.deleteCharAt(SQL.length() - 2);
        SQL.append(")");
        statement.executeUpdate(SQL.toString());
    }

    @Override
    public void deleteProduct(Product product) throws SQLException {
        String SQL = "DELETE FROM " + tableName + " WHERE id = " + product.getId();
        statement.executeUpdate(SQL);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        StringBuilder SQL = new StringBuilder("UPDATE " + tableName + " SET ");
        if (product.getName() != null) SQL.append("name = " + product.getName() + ", ");
        if (product.getDescription() != null) SQL.append("description = " + product.getDescription() + ", ");
        if (product.getPrice() != 0) SQL.append("price = " + product.getPrice() + ", ");
        if (product.getStock() != 0) SQL.append("stock = " + product.getStock() + ", ");
        SQL.deleteCharAt(SQL.length() - 2);
        SQL.append(" WHERE id = " + product.getId());
        statement.executeUpdate(SQL.toString());
    }

    @Override
    public Product getProduct(String id) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                return new Product(resultSet.getString("id"), resultSet.getString("name"),
                        resultSet.getString("description"), resultSet.getDouble("price"),
                        resultSet.getInt("stock"), new ArrayList<String>(), new ArrayList<String>());
            }
        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException {
        String SQL = "SELECT * FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(SQL);
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(new Product(resultSet.getString("id"), resultSet.getString("name"),
                    resultSet.getString("description"), resultSet.getDouble("price"),
                    resultSet.getInt("stock"), new ArrayList<String>(), new ArrayList<String>()));
        }
        return products;
    }
    @Override
    public ArrayList<Product> getProductsByCategory(String category) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE category = " + category;
        ResultSet resultSet = statement.executeQuery(SQL);
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(new Product(resultSet.getString("id"), resultSet.getString("name"),
                    resultSet.getString("description"), resultSet.getDouble("price"),
                    resultSet.getInt("stock"), new ArrayList<String>(), new ArrayList<String>()));
        }
        return products;
    }

    @Override
    public ArrayList<Product> getProductsByCategorySorted(String category, String sortByThis, int page, int numPerPage) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE category = " + category + " ORDER BY " + sortByThis + " LIMIT " +
                ((page - 1) * numPerPage) + /*check if needed*/1 + ", " + numPerPage;

        ResultSet resultSet = statement.executeQuery(SQL);
        ArrayList<Product> products = new ArrayList<>();

        while (resultSet.next())
            products.add(new Product(resultSet.getString("id"), resultSet.getString("name"),
                    resultSet.getString("description"), resultSet.getDouble("price"),
                    resultSet.getInt("stock"), new ArrayList<String>(), new ArrayList<String>()));

        return products;
    }

    @Override
    public ArrayList<Product> getProductsSorted(String sortByThis, int page, int numPerPage) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " ORDER BY " + sortByThis + " LIMIT " +
                ((page - 1) * numPerPage) + /*check if needed*/1  + ", " + numPerPage;

        ResultSet resultSet = statement.executeQuery(SQL);
        ArrayList<Product> products = new ArrayList<>();

        while (resultSet.next())
            products.add(new Product(resultSet.getString("id"), resultSet.getString("name"),
                    resultSet.getString("description"), resultSet.getDouble("price"),
                    resultSet.getInt("stock"), new ArrayList<String>(), new ArrayList<String>()));

        return products;
    }
}
