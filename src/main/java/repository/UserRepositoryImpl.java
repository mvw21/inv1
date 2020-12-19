package repository;

import domain.entity.User;
import domain.service.UserServiceModel;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getResultList();

        if(users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public void register(UserServiceModel user) {
        User newUser = modelMapper.map(user, User.class);
        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();
    }
}
