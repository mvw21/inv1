package repository;

import domain.entity.Product;
import domain.entity.User;
import domain.service.ProductServiceModel;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Inject
    public ProductRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper, UserRepository userRepository) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void create(ProductServiceModel product) {
        Product createdProduct = this.modelMapper.map(product, Product.class);
        User user = userRepository.findByUsername(product.getUser());
        createdProduct.setUser(user);
        entityManager.getTransaction().begin();
        entityManager.persist(createdProduct);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Product> getAll() {
       List<Product> products = this.entityManager.createQuery("SELECT p FROM Product p", Product.class)
               .getResultList();

        return products;
    }
}
