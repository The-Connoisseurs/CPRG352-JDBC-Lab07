package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

public class UserService {

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> userList = userDB.getAll();
        return userList;
    }

    public void insert(String email, boolean isActive, String firstName, String lastName, String password, int role) throws Exception {
        User user = new User(email, isActive, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }

    public void update(String email, boolean isActive, String firstName, String lastName, String password, int role) throws Exception {
        User user = new User(email, isActive, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        userDB.delete(email);
    }
}
