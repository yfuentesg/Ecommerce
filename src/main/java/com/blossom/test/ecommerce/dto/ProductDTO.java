package com.blossom.test.ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;
    private Date creationDate;
    private String status;
}
