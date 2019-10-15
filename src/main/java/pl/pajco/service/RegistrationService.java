package pl.pajco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pajco.entity.User;
import pl.pajco.model.UserDTO;
import pl.pajco.repository.UserRepository;

@Service
public class RegistrationService {

    private UserRepository userRepository;

    @Autowired
    private RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkIfEmailInDB(String email) {
        User user = userRepository.findUserByEmail(email);
        return user != null;
    }


    public void registerUser(UserDTO userDTO) {
        userRepository.save(userDTOTransferToUser(userDTO));
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
