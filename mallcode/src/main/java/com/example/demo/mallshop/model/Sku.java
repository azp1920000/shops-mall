package com.example.demo.mallshop.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lenovo
 * @date 2019/11/24
 */
@Data
@Accessors(chain = true)
public class Sku implements Serializable{

    private Long skuId;
    private String skuName;
    private Float price;
    private Long categoryId;
    private Long brandId;
    private String description;
    private Date createTime;
    private Date updateTime;
    private Boolean deleted;
}
