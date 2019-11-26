package com.example.demo.mallshop.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by lenovo on 2019/11/25.
 */
@Data
public class SkuDTO {
    private Long skuId;
    private String skuName;
    private float price;
    private Long categroyId;
    private Long brandId;
    private String description;
    private Date updateTime;
}
