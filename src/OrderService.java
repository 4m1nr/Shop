import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Order getOrder(Order order) throws SQLException {
        return orderDAO.getOrder(order);
    }

    public void changeOrderStatus(Order order) throws SQLException {
        orderDAO.changeOrderStatus(order);
    }

    public ArrayList<Order> getOrdersByUser(User user) throws SQLException {
        return orderDAO.getOrdersByUser(user);
    }
    public ArrayList<Order> getAllOrders() throws SQLException {
        return orderDAO.getAllOrders();
    }
}
