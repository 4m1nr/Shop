import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{
    Connection connection;
    Statement statement;
    String tableName = "Users";
    String host = "jdbc:mysql://localhost:3306/shop";
    String username = "root",password = "9376432064aA";
    UserDAOImpl() throws SQLException {
        this.connection = DriverManager.getConnection(host,username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    @Override
    public void insertUser(User user) throws SQLException {
        String SQL = "INSERT INTO " + tableName +
                " (Name, LastName, PhoneNumber, EmailAddress, HashedPassword, Role, Cart, Address)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getPhoneNumber());
        preparedStatement.setString(4, user.getEmailAddress());
        preparedStatement.setString(5, user.getHashedPassword());
        preparedStatement.setString(6, "USER");
        preparedStatement.setNull(7, java.sql.Types.VARCHAR);
        preparedStatement.setString(8, "USER");
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        String SQL = "DELETE FROM " + tableName + " WHERE id = " + user.getId();
        statement.executeUpdate(SQL);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        StringBuilder SQL = new StringBuilder("UPDATE " + tableName + " SET ");

        if (user.getName() != null)             SQL.append("name = " + user.getName() + ", ");
        if (user.getLastName() != null)         SQL.append("lastName = " + user.getLastName() + ", ");
        if (user.getPhoneNumber() != null)      SQL.append("phoneNumber = " + user.getPhoneNumber() + ", ");
        if (user.getEmailAddress() != null)     SQL.append("emailAddress = " + user.getEmailAddress() + ", ");
        if (user.getHashedPassword() != null)   SQL.append("hashedPassword = " + user.getHashedPassword() + ", ");
        if (user.getRole() != null)             SQL.append("role = " + user.getRole() + ", ");

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
    public User getUserByPhoneNumber(String phoneNumber) throws SQLException {
        String SQL = "SELECT * FROM " + tableName + " WHERE PhoneNumber = " + phoneNumber;
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

    @Override
    public String getNewId() throws SQLException {
        int id;

        String SQL = "SELECT id FROM " + tableName + "LIMIT 1";
        ResultSet resultSet = statement.executeQuery(SQL);
        id = resultSet.getInt("id") + 1;
        resultSet.close();

        SQL = "UPDATE " + tableName + " SET id = " + id + " LIMIT 1";
        statement.executeUpdate(SQL);

        return Integer.toString(id);
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
        resultSet.close();
        return users;
    }
}
