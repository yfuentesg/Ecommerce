package com.blossom.test.ecommerce.mapper;

import com.blossom.test.ecommerce.database.model.Product;
import com.blossom.test.ecommerce.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product p) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(p.getId());
        productDTO.setName(p.getName());
        productDTO.setStatus(p.getStatus());
        productDTO.setPrice(p.getPrice());
        productDTO.setCreationDate(p.getCreationDate());
        return productDTO;
    }

    public Product toEntity(ProductDTO pDto) {
        Product product = new Product();
        product.setId(pDto.getId());
        product.setName(pDto.getName());
        product.setStatus(pDto.getStatus());
        product.setPrice(pDto.getPrice());
        product.setCreationDate(pDto.getCreationDate());
        return product;
    }
}
