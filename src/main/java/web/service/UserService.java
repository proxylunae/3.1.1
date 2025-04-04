package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    void add(User user);
    User getUserById(Long id);
    List<User> listUsers();
    void update(User user);
    void delete(Long id);
    void createUser(String name, byte age);
    void updateUser(Long id, String name, byte age);
}
