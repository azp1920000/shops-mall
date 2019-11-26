package com.example.demo.mallshop.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by lenovo on 2019/11/26.
 */
@Data
public class HigherSkuDTO {

    private String skuName;
    private String categoryName;
    private Long categoryId;//categoryId
    private String brandName;
    private float price;
}
