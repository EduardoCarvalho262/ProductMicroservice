package com.gft.product.command.handlers;

import com.gft.product.command.model.CreateProductCommand;
import com.gft.product.command.model.DeleteProductCommand;
import com.gft.product.command.model.UpdateProductCommand;
import com.gft.product.model.Product;
import com.gft.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCommandHandler {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Integer createHandle(CreateProductCommand command){
        Product newProduct = new Product(command.getName(), command.getValue(), command.getRating());
        newProduct.setImage(command.getImage());
        var response = productRepository.save(newProduct);

        return response.getId();
    };

    @Transactional
    public Integer deleteHandle(DeleteProductCommand command){
        Optional<Product> entity = productRepository.findById(command.getId()).isPresent() ? productRepository.findById(command.getId()) : Optional.empty();
        return entity.map(Product::getId).orElse(null);
    };


    @Transactional
    public Integer updateHandle(UpdateProductCommand command){
        Product newProduct = new Product(command.getId(),command.getName(), command.getValue(), command.getRating(), command.getImage());
        var response = productRepository.save(newProduct);

        return response.getId();
    };
}
