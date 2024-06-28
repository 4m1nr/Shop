import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService {
    public void insertUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUser(String id) throws SQLException;
    public User getUserByPhoneNumber(String phoneNumber) throws SQLException;
    public ArrayList<User> getAllUsers() throws SQLException;
    public ArrayList<User> getUsersByRole(String role) throws SQLException;

}
