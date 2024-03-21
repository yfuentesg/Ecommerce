package com.blossom.test.ecommerce.controller;

import com.blossom.test.ecommerce.dto.ProductDTO;
import com.blossom.test.ecommerce.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Api(tags = "Products Controller")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    @ApiOperation("Adds a product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        ProductDTO p = productService.addProduct(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("Get all products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.listProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get a single product")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") int id) {
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deactivate a product")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deactivateProduct(id);
    }

    @PatchMapping("/{id}")
    @ApiOperation("Updates a product")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") int id, @RequestBody ProductDTO product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @GetMapping("/findFilteredProducts")
    @ApiOperation("Finds a list of product filtering by name or price or status")
    public ResponseEntity<List<ProductDTO>> findFilteredProducts(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) Double price,
                                                           @RequestParam(required = false) String status) {
        return ResponseEntity.ok(productService.listFilteredProducts(name == null ? "" : name,
                                                                     price == null ? 0.0 : price,
                                                                     status == null ? "A" : status));
    }
}
