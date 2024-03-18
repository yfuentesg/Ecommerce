package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.database.model.Product;
import com.blossom.test.ecommerce.dto.ProductDTO;
import com.blossom.test.ecommerce.mapper.ProductMapper;
import com.blossom.test.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ProductDTO addProduct(ProductDTO p) {
        p.setCreationDate(new Date());
        p.setStatus("A");
        Product pr = productMapper.toEntity(p);
        productRepository.save(pr);

        return productMapper.toDTO(pr);
    }

    @Override
    public List<ProductDTO> listProducts() {
        return productRepository.findAll().stream().map(productMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(int id) {
        Optional<Product> currentProduct = productRepository.findById(id);

        return currentProduct.map(product -> productMapper.toDTO(product)).orElse(null);

    }

    @Override
    public ProductDTO updateProduct(int id, ProductDTO p) {
        Product currentProduct = productRepository.findById(id).orElse(null);

        if (currentProduct == null) {
            return null;
        }

        currentProduct.setName(p.getName() == null ? currentProduct.getName() : p.getName());
        currentProduct.setPrice(p.getPrice() == null ? currentProduct.getPrice() : p.getPrice());
        currentProduct.setStatus(p.getStatus() == null ? currentProduct.getStatus() : p.getStatus());
        productRepository.save(currentProduct);

        return productMapper.toDTO(currentProduct);
    }

    @Override
    public void deactivateProduct(int id) {
        Product currentProduct = productRepository.findById(id).orElse(null);

        if (currentProduct != null) {
            currentProduct.setStatus("I");
            productRepository.save(currentProduct);
        }
    }
}
