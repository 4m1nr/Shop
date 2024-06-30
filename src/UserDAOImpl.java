import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserDAOImpl{
    private Connection connection;
    private Statement statement;
    private String tableName = "Users";
    private String host = "jdbc:mysql://localhost:3306/shop";
    private String username = "root",password = "9376432064aA";
    UserDAOImpl() throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void insertUser(User user) throws SQLException {
        String SQL = "INSERT INTO " + tableName +
                " (Name, LastName, PhoneNumber, EmailAddress, Balance, HashedPassword, Role, Cart, Address)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPhoneNumber());
        preparedStatement.setString(4, user.getEmailAddress());
        preparedStatement.setString(5, String.valueOf(user.getBalance()));
        preparedStatement.setString(6, user.getHashedPassword());
        preparedStatement.setString(7, "USER");
        preparedStatement.setNull(8, java.sql.Types.VARCHAR);
        preparedStatement.setString(9, "USER");
        preparedStatement.executeUpdate();
    }


    public void deleteUser(User user) throws SQLException {
        String SQL = "DELETE FROM " + tableName + " WHERE id = " + user.getId();
        statement.executeUpdate(SQL);
    }


    public void updateUser(User user) throws SQLException {
        StringBuilder SQL = new StringBuilder("UPDATE " + tableName + " SET ");

        if (user.getName() != null)             SQL.append("name = '" + user.getName() + "', ");
        if (user.getLastName() != null)         SQL.append("lastName = '" + user.getLastName() + "', ");
        if (user.getPhoneNumber() != null)      SQL.append("phoneNumber = '" + user.getPhoneNumber() + "', ");
        if (user.getEmailAddress() != null)     SQL.append("emailAddress = '" + user.getEmailAddress() + "', ");
        if (user.getHashedPassword() != null)   SQL.append("hashedPassword = '" + user.getHashedPassword() + "', ");
        if (user.getBalance() != -1)            SQL.append("balance = '" + user.getBalance() + "', ");
        if (user.getRole() != null)             SQL.append("role = '" + user.getRole() + "', ");

        SQL.deleteCharAt(SQL.length() - 2);
        SQL.append(" WHERE id = " + user.getId());
        statement.executeUpdate(SQL.toString());
    }


    public User getUser(String id) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE id = " + id;

        return extractUserFromRS(SQL);
    }


    public User getUserByPhoneNumber(String phoneNumber) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE PhoneNumber = " + phoneNumber;

        return extractUserFromRS(SQL);
    }

    private User extractUserFromRS(String SQL) throws SQLException {
        ResultSet resultSet = statement.executeQuery(SQL);

        if (resultSet.next()) {
            return new User(resultSet.getString("id"), resultSet.getString("name")
                    , resultSet.getString("lastName"), resultSet.getString("phoneNumber")
                    , resultSet.getString("emailAddress"), resultSet.getString("hashedPassword")
                    , Double.parseDouble(resultSet.getString("balance"))
                    , new ArrayList<Address>(),new Cart(resultSet.getString("id"), resultSet.getString("cart"), new HashMap<>())
                    ,resultSet.getString("role"));
        }
        return null;
    }


    public ArrayList<User> getAllUsers() throws SQLException {
        String SQL = "SELECT * FROM " + tableName;
        return getUsers(SQL);
    }


    public ArrayList<User> getUsersByRole(String role) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + "WHERE role = " + role;
        return getUsers(SQL);
    }

    private ArrayList<User> getUsers(String SQL) throws SQLException {
        ResultSet resultSet = statement.executeQuery(SQL);
        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next()) {
            users.add(new User(resultSet.getString("id"), resultSet.getString("name")
                    , resultSet.getString("lastName"), resultSet.getString("phoneNumber")
                    , resultSet.getString("emailAddress"), resultSet.getString("hashedPassword")
                    , Double.parseDouble(resultSet.getString("balance"))
                    , new ArrayList<Address>(),new Cart(resultSet.getString("id"), resultSet.getString("cart"), new HashMap<>())
                    , resultSet.getString("role")));
        }
        resultSet.close();
        return users;
    }
}
