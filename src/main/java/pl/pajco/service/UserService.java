package pl.pajco.service;

import pl.pajco.entity.User;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);

}
