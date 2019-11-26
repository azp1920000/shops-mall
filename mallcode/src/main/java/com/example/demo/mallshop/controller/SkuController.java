package com.example.demo.mallshop.controller;


import com.example.demo.mallshop.controller.Param.HigherSkuParam;
import com.example.demo.mallshop.controller.Param.SkuParam;
import com.example.demo.mallshop.dto.HigherSkuDTO;
import com.example.demo.mallshop.mapper.SkuMapper;
import com.example.demo.mallshop.model.Sku;
import com.example.demo.mallshop.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by lenovo on 2019/11/24.
 */
@RestController
public class SkuController {
    @Autowired
    SkuService skuService;

    @RequestMapping("/bala")
    public List<SkuParam> getAll(){
        return skuService.getAll();
    }

    @PostMapping("/insert")
    public int insertLine(@RequestBody SkuParam skuParam){
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuParam,sku);
       return  skuService.insertLine(sku);
    }

//    @PostMapping("insert")
//    public int insertLine(@RequestBody Sku sku){
//        return skuService.insertLine(sku);
//    }
//    @DeleteMapping("/delete")
    @GetMapping("/delete/{skuId}")
    public int deleteLine(@PathVariable Long skuId){
        return skuService.delteLine(skuId);
    }

    @PutMapping("/update/{skuId}/{skuName}")
    public int updateLine(@PathVariable Long skuId,@PathVariable String skuName){
        return skuService.updateLine(skuId,skuName);
    }

    @PostMapping("/higherSelect")
    public List<HigherSkuDTO> higherSelect(@RequestBody HigherSkuParam higherSkuParam){
        return skuService.higherSelect(higherSkuParam);
    }
}
