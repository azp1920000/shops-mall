package com.example.demo.mallshop.service;


import com.example.demo.mallshop.controller.Param.HigherSkuParam;
import com.example.demo.mallshop.controller.Param.SkuParam;
import com.example.demo.mallshop.dto.HigherSkuDTO;
import com.example.demo.mallshop.mapper.SkuMapper;
import com.example.demo.mallshop.model.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/11/24.
 */
@Service
public class SkuService {
    @Autowired
    SkuMapper skuMapper;

    public List<SkuParam> getAll(){
        return skuMapper.getAll();
    }

    public int insertLine(Sku sku){
        return skuMapper.insertLine(sku);
    }

    public int delteLine(Long skuId){
        return skuMapper.deleteLine(skuId);
    }

    public int updateLine(Long skuId,String skuName){
        return skuMapper.updateLine(skuId,skuName);
    }

    public List<HigherSkuDTO> higherSelect(HigherSkuParam higherSkuParam){
        return skuMapper.higherSelect(higherSkuParam);
    }
}
