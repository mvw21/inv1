package service;

import domain.entity.User;
import domain.service.ProductServiceModel;
import domain.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import repository.UserRepository;
import utils.ValidationService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationService validationService;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationService validationService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    @Override
    public UserServiceModel register(String username, String password, String confirmedPassword, String email) {
        if (!validationService.passwordMatches(password, confirmedPassword) ||
                !validationService.isEmailValid(email) ||
                validationService.isUsernameTaken(username)) {
            return null;
        }

        String hashedPassword = DigestUtils.sha256Hex(password);
        UserServiceModel user = new UserServiceModel();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setEmail(email);

        userRepository.register(user);
        return user;
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }

        String hashedPassword = DigestUtils.sha256Hex(password);
        return user.getPassword().equals(hashedPassword);
    }
}
