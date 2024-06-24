import java.util.ArrayList;

public interface UserDAO {
    public void insertUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public User getUser(String id);
    public ArrayList<User> getAllUsers();
    public ArrayList<User> getUsersByRole(String role);

}
