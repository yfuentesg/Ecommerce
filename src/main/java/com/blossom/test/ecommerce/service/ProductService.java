package com.blossom.test.ecommerce.service;

import com.blossom.test.ecommerce.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    public ProductDTO addProduct(ProductDTO p);
    public List<ProductDTO> listProducts();
    public ProductDTO getProduct(int id);
    public ProductDTO updateProduct(int id, ProductDTO p);
    public void deactivateProduct(int id);

    public List<ProductDTO> listFilteredProducts(String name, Double price, String status);


}
