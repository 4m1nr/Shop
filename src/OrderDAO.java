import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderDAO {
    private Connection connection;
    private Statement statement;
    private String ordersTableName = "carts";
    private String ordersItemsTableName = "cartitems";
    private String host = "jdbc:mysql://localhost:3306/shop";
    private String username = "root",password = "9376432064aA";
    OrderDAO() throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    public Order getOrder(Order order) throws SQLException {
        String orderId = order.getOrderID();
        HashMap<String,Integer> orderMap;
        String userId,status;
        String SQL = "SELECT * FROM " + ordersTableName + " WHERE order_id = " + orderId;
        String SQL2 = "SELECT * FROM " + ordersItemsTableName + " WHERE order_id = " + orderId;
        ResultSet resultSet = statement.executeQuery(SQL);

        if (resultSet.next()) {
            userId = resultSet.getString("user_id");
            status = resultSet.getString("status");
            orderMap = extractOrderMapFromRS(SQL2);
            return new Order(userId, orderId, orderMap,status);
        }else
            return null;

    }

    private HashMap<String, Integer> extractOrderMapFromRS(String sql2) throws SQLException {
        HashMap<String,Integer> orderMap = new HashMap<>();
        ResultSet resultSet = statement.executeQuery(sql2);
        while (resultSet.next())
            orderMap.put(resultSet.getString("product_id"), resultSet.getInt("quantity"));
        return orderMap;
    }

    public void changeOrderStatus(Order order) throws SQLException {
        String orderId = order.getOrderID();
        String status = order.getStatus();
        String SQL = "UPDATE " + ordersTableName + " SET status = " + status + " WHERE order_id = " + orderId;
        statement.executeUpdate(SQL);
    }

    public ArrayList<Order> getOrdersByUser(User user) throws SQLException {
        String userId = user.getId();
        ArrayList<Order> orders = new ArrayList<>();
        String SQL = "SELECT * FROM " + ordersTableName + " WHERE user_id = " + userId;
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            String orderId = resultSet.getString("order_id");
            orders.add(getOrder(new Order(userId, orderId, new HashMap<>(), resultSet.getString("status"))));
        }
        return orders;
    }
}
