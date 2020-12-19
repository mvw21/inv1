package service;

import domain.entity.User;
import domain.entity.enums.Type;
import domain.service.ProductServiceModel;
import org.modelmapper.ModelMapper;
import repository.ProductRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductServiceModel create(String name, String username, String quantity, Type type) {
        if(name.isEmpty() || username.isEmpty()){
            return null;
        }

        ProductServiceModel product = new ProductServiceModel();
        product.setName(name);
        product.setQuantity(quantity);
        product.setType(type);
        product.setUser(username);

        productRepository.create(product);
        return product;
    }

    @Override
    public List<ProductServiceModel> getAll() {
        List<ProductServiceModel> products = productRepository.getAll()
                .stream()
                .map(product -> {
                    ProductServiceModel model = modelMapper.map(product, ProductServiceModel.class);
                    model.setUser(product.getUser().getUsername());
                    return model;
                })
                .collect(Collectors.toList());

        return products;
    }
}
