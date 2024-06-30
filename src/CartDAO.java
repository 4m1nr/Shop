import java.sql.*;
import java.util.HashMap;

public class CartDAO {
    private Connection connection;
    private Statement statement;
    private String cartsTableName = "carts";
    private String cartsItemsTableName = "cartitems";
    private String host = "jdbc:mysql://localhost:3306/shop";
    private String username = "root",password = "9376432064aA";
    CartDAO() throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    public Cart getCart(Cart cart) throws SQLException {
        String cartId = cart.getCartID();
        HashMap<String,Integer> cartMap;
        String userId;
        String SQL = "SELECT * FROM " + cartsTableName + " WHERE cart_id = " + cartId;
        String SQL2 = "SELECT * FROM " + cartsItemsTableName + " WHERE cart_id = " + cartId;
        ResultSet resultSet = statement.executeQuery(SQL);

        if (resultSet.next()) {
            userId = resultSet.getString("user_id");
            cartMap = extractCartMapFromRS(SQL2);
            return new Cart(userId, cartId, cartMap);
        }else
            return null;

    }

    private HashMap<String,Integer> extractCartMapFromRS(String SQL) throws SQLException {
        HashMap<String,Integer> cartMap = new HashMap<>();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next())
            cartMap.put(resultSet.getString("product_id"), resultSet.getInt("quantity"));
        return cartMap;
    }

    public void deleteCart(Cart cart) throws SQLException {
        String cartId = cart.getCartID();
        String SQL = "DELETE FROM " + cartsTableName + " WHERE cart_id = " + cartId;
        String SQL2 = "DELETE FROM " + cartsItemsTableName + " WHERE cart_id = " + cartId;
        statement.executeUpdate(SQL);
        statement.executeUpdate(SQL2);
    }
    public void createCart(Cart cart) throws SQLException {
        String SQL = "INSERT INTO " + cartsTableName + " (cart_id, user_id) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, cart.getCartID());
        preparedStatement.setString(2, cart.getUserID());
        preparedStatement.executeUpdate();
    }

    public void addProductToCart(Cart cart, Product product, int quantity) throws SQLException {
        String SQL = "INSERT INTO " + cartsItemsTableName + " (cart_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, cart.getCartID());
        preparedStatement.setString(2, product.getId());
        preparedStatement.setInt(3, quantity);
        preparedStatement.executeUpdate();
    }

    public void deleteProductFromCart(Cart cart, Product product) throws SQLException {
        String SQL = "DELETE FROM " + cartsItemsTableName + " WHERE cart_id = " + cart.getCartID() + " AND product_id = " + product.getId();
        statement.executeUpdate(SQL);
    }

    public void updateProductQuantity(Cart cart, Product product, int quantity) throws SQLException {
        String SQL = "UPDATE " + cartsItemsTableName + " SET quantity = " + quantity + " WHERE cart_id = " + cart.getCartID() + " AND product_id = " + product.getId();
        statement.executeUpdate(SQL);
    }
}
