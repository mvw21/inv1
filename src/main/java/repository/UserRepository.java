package repository;

import domain.entity.User;
import domain.service.UserServiceModel;

public interface UserRepository {

    User findByUsername(String username);

    void register(UserServiceModel user);
}
