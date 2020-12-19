package service;

import domain.entity.User;
import domain.entity.enums.Type;
import domain.service.ProductServiceModel;

import java.util.List;

public interface ProductService {
   ProductServiceModel create(String name, String username, String quantity, Type type);

    List<ProductServiceModel> getAll();
}
