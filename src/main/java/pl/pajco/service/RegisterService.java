package pl.pajco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pajco.entity.User;
import pl.pajco.model.UserDTO;
import pl.pajco.repository.UserRepository;

@Service
public class RegisterService {

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    private RegisterService(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public boolean checkIfEmailInDB(String email) {
        User user = userRepository.findUserByEmail(email);
        return user != null;
    }

    public boolean checkIfNickInDB(String nick) {
        User user = userRepository.findUserByNick(nick);
        return user != null;
    }

    public void registerUser(UserDTO userDTO) {
        userService.saveUser(userDTOTransferToUser(userDTO));
    }

    public User userDTOTransferToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setNick(userDTO.getNick());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }



}
