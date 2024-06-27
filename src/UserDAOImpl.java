import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{
    Connection connection;
    Statement statement;
    String tableName = "Products";
    String host;
    String username,password;
    UserDAOImpl(Connection connection) throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    @Override
    public void insertUser(User user) throws SQLException {
        StringBuilder SQL = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
        SQL.append(user.getId()).append(", ");
        SQL.append(user.getName() + ", ");
        SQL.append(user.getLastName() + ", ");
        SQL.append(user.getPhoneNumber() + ", ");
        SQL.append(user.getEmailAddress() + ", ");
        SQL.append(user.getHashedPassword() + ", ");
        SQL.append(user.getRole() + ",");
        SQL.deleteCharAt(SQL.length() - 2);
        SQL.append(")");
        statement.executeUpdate(SQL.toString());
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        String SQL = "DELETE FROM " + tableName + " WHERE id = " + user.getId();
        statement.executeUpdate(SQL);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        StringBuilder SQL = new StringBuilder("UPDATE " + tableName + " SET ");
        if (user.getName() != null) SQL.append("name = " + user.getName() + ", ");
        if (user.getLastName() != null) SQL.append("lastName = " + user.getLastName() + ", ");
        if (user.getPhoneNumber() != null) SQL.append("phoneNumber = " + user.getPhoneNumber() + ", ");
        if (user.getEmailAddress() != null) SQL.append("emailAddress = " + user.getEmailAddress() + ", ");
        if (user.getHashedPassword() != null) SQL.append("hashedPassword = " + user.getHashedPassword() + ", ");
        if (user.getRole() != null) SQL.append("role = " + user.getRole() + ", ");
        SQL.deleteCharAt(SQL.length() - 2);
        SQL.append(" WHERE id = " + user.getId());
        statement.executeUpdate(SQL.toString());
    }

    @Override
    public User getUser(String id) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                return new User(resultSet.getString("id"), resultSet.getString("name")
                        , resultSet.getString("lastName"), resultSet.getString("phoneNumber")
                        , resultSet.getString("emailAddress"), resultSet.getString("hashedPassword")
                        , new ArrayList<Address>(),/*بعدا عوض شود*/ new Cart(), resultSet.getString("role"));
            }
        return null;
    }

    @Override
    public ArrayList<User> getAllUsers() throws SQLException {
        String SQL = "SELECT * FROM " + tableName;
        return getUsers(SQL);
    }

    @Override
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
                    , new ArrayList<Address>(),/*بعدا عوض شود*/ new Cart(), resultSet.getString("role")));
        }
        return users;
    }
}
