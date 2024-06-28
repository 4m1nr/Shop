import java.sql.SQLException;
import java.util.ArrayList;

public class UserServiceImpl implements UserService{
    private UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        if (userDao.getUserByPhoneNumber(user.getPhoneNumber()) != null)
            throw new /*should be edited*/RuntimeException("User with this phone number already exists");
        else {
            User userToInsert = new User(userDao.getNewId(), user.getName(), user.getLastName(),
                    user.getPhoneNumber(), user.getEmailAddress(),
                    user.getHashedPassword(), user.getAddresses(),
                    user.getCart(), user.getRole());

            userDao.insertUser(userToInsert);
        }
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public User getUser(String id) throws SQLException {
        return userDao.getUser(id);
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) throws SQLException {
        return userDao.getUserByPhoneNumber(phoneNumber);
    }

    @Override
    public ArrayList<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public ArrayList<User> getUsersByRole(String role) throws SQLException {
        return getUsersByRole(role);
    }
}
