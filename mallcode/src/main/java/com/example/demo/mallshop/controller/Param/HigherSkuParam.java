package com.example.demo.mallshop.controller.Param;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2019/11/26.
 */
@Data
@Accessors(chain = true)

public class HigherSkuParam implements Serializable{
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private String skuName;
    private String categoryName;
    private List<Long> categoryIds;
    private String brandName;

}
