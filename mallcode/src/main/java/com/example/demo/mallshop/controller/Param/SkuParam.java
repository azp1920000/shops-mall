package com.example.demo.mallshop.controller.Param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lenovo on 2019/11/25.
 */
@Data
@Accessors(chain = true)
public class SkuParam implements Serializable{
    private Long skuId;
    private String skuName;
    private Float price;
    private Long categoryId;
    private Long brandId;
    private String description;

}
