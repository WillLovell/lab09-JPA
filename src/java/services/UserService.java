package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Dynamic Duo
 */
public class UserService {

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;

    }

    public void insert(String email, Boolean active, String fName, String lName, String pass, Role role) throws Exception {
        User user = new User(email, active, fName, lName, pass, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);

    }

    public void update(String email, Boolean active, String fName, String lName, String pass, int role) throws Exception {
        User user = new User();
        UserDB userDB = new UserDB();
        userDB.update(user);

    }

    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }

}
