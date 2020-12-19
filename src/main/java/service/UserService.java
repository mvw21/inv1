package service;

import domain.service.ProductServiceModel;
import domain.service.UserServiceModel;

public interface UserService {

    UserServiceModel register(String username, String password, String confirmedPassword, String email);

    boolean login(String username, String password);

}
