import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl{
    private UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    
    public void insertUser(User user) throws SQLException {
        if (userDao.getUserByPhoneNumber(user.getPhoneNumber()) != null)
            throw new /*should be edited*/RuntimeException("User with this phone number already exists");
        else {
            User userToInsert = new User(null, user.getName(), user.getLastName(),
                    user.getPhoneNumber(), user.getEmailAddress(),
                    user.getHashedPassword(), user.getAddresses(),
                    user.getCart(), user.getRole());

            userDao.insertUser(userToInsert);
        }
    }

    
    public void deleteUser(User user) throws SQLException {
        userDao.deleteUser(user);
    }

    
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    
    public User getUserByPhoneNumber(String phoneNumber) throws SQLException {
        User user = userDao.getUserByPhoneNumber(phoneNumber);
        if (user != null)
            return user;
        else
            throw new RuntimeException("User not found");
    }


    
    public User getUser(String id) throws SQLException {
        User user = userDao.getUser(id);
        if (user == null)
            throw new RuntimeException("User not found");
        else
            return user;
    }

    
    public ArrayList<User> getAllUsers() throws SQLException {
        return null;
    }

    
    public ArrayList<User> getUsersByRole(String role) throws SQLException {
        return null;
    }
}
