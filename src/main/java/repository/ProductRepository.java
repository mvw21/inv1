package repository;

import domain.entity.Product;
import domain.service.ProductServiceModel;

import java.util.List;

public interface ProductRepository {
    void create(ProductServiceModel product);

    List<Product> getAll();
}
