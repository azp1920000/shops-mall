package com.example.demo.mallshop.mapper;

import com.example.demo.mallshop.controller.Param.HigherSkuParam;
import com.example.demo.mallshop.controller.Param.SkuParam;
import com.example.demo.mallshop.dto.HigherSkuDTO;
import com.example.demo.mallshop.model.Sku;
import com.sun.org.apache.xpath.internal.operations.And;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by lenovo on 2019/11/24.
 */
@Mapper
public interface SkuMapper {


    @Select("select * from Sku")
    List<SkuParam> getAll();

    @Insert(value = {"INSERT INTO Sku (skuName,price,categoryId,brandId,description) VALUES (#{skuName},#{price},#{categoryId},#{brandId},#{description})"})
    @Options(useGeneratedKeys=true, keyProperty="skuId")
    int insertLine(Sku sku);

//    @Insert(value = {"INSERT INTO Sku (categoryId,brandId) VALUES (2,1)"})
//    @Options(useGeneratedKeys=true, keyProperty="SkuId")
//    int insertLine(Sku sku);

    @Delete(value = {
            "DELETE from Sku WHERE skuId = #{skuId}"
    })
    int deleteLine(@Param(value = "skuId") Long skuId);

//    @Insert({
//            "<script>",
//            "INSERT INTO",
//            "CategoryAttributeGroup(id,templateId,name,sort,createTime,deleted,updateTime)",
//            "<foreach collection='list' item='obj' open='values' separator=',' close=''>",
//            "   (#{obj.id},#{obj.templateId},#{obj.name},#{obj.sort},#{obj.createTime},#{obj.deleted},#{obj.updateTime})",
//            "</foreach>",
//            "</script>"
//    })
//    Integer createCategoryAttributeGroup(List<CategoryAttributeGroup> categoryAttributeGroups);

    @Update("UPDATE Sku SET skuName = #{skuName} WHERE skuId = #{skuId}")
    int updateLine(@Param("skuId") Long skuId,@Param("skuName")String skuName);


    @Select({
        "<script>",
            "SELECT",
            "s.SkuName,c.categoryName,s.categoryId,b.brandName,s.price",
            "FROM",
            "Sku AS s",
            "JOIN",
            "Category AS c ON s.categoryId = c.categoryId",
            "JOIN",
            "Brand AS b ON s.brandId = b.brandId",
            "WHERE  1=1",
            //范围查询，根据时间
            "<if test=\"  null != higherSkuParam.startTime and null != higherSkuParam.endTime  \">",
            "AND s.updateTime &gt;= #{higherSkuParam.startTime}",
            "AND s.updateTime &lt;= #{ higherSkuParam.endTime}",
            "</if>",
            //模糊查询，根据类别

            "<if test=\"null != higherSkuParam.categoryName and ''!=higherSkuParam.categoryName\">",
            " AND c.categoryName LIKE CONCAT('%', #{higherSkuParam.categoryName}, '%')",
            "</if>",

            //模糊查询，根据品牌

            "<if test=\"null != higherSkuParam.brandName and ''!=higherSkuParam.brandName\">",
            " AND b.brandName LIKE CONCAT('%', #{higherSkuParam.brandName}, '%')",
            "</if>",


            //模糊查询，根据商品名字
            "<if test=\"null != higherSkuParam.skuName and ''!=higherSkuParam.skuName\">",
            " AND s.skuName LIKE CONCAT('%', #{higherSkuParam.skuName}, '%')",
            "</if>",


            //根据多个类别查询
           "<if    test=\" null != higherSkuParam.categoryIds and  higherSkuParam.categoryIds.size>0\"  >",
            "AND  s.categoryId  IN",
            "<foreach collection=\"higherSkuParam.categoryIds\"  item=\"data\" index=\"index\" open=\"(\" separator=\",\" close=\")\"  >",
            "   #{data} ",
            "</foreach>",
            "</if>",
        "</script>"
    })
    List<HigherSkuDTO> higherSelect(@Param("higherSkuParam")HigherSkuParam higherSkuParam);



//           "<if   test=\" null != higherSkuParam.categoryName  and ''!=higherSkuParam.categoryName \"   >",
//            " AND  c.categoryName LIKE \"%#{higherSkuParam.categoryName}%\" ",
//            "</if>",
//           "<if test=\" null != higherSkuParam.skuName   \"    >",
//            "AND  s.skuName LIKE \"%#{higherSkuParam.skuName}%\"     ",
//            "</if>",
}
