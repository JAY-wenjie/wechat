package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.AttrBean;
import com.wechat.domain.model.PoductSpu;
import com.wechat.domain.model.ProductSku;
import com.wechat.service.PoductSpuService;
import com.wechat.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DetialsController {

    @Autowired
    PoductSpuService poductSpuService;
    @Autowired
    ProductSkuService productSkuService;

    @RequestMapping("getskubyspuid")
    public JsonBean getSkuBySpuId(Integer spuId){
        Map<String, Object> productSku = productSkuService.selectSkuBySpuId(spuId);
        System.out.println(productSku.toString());
        if(productSku!=null){
            List<Map<String,Object>> skuImgs = productSkuService.selectSkuImgById((Integer) productSku.get("id"));
            PoductSpu poductSpu = poductSpuService.selectByPrimaryKey(spuId);
            productSku.put("skuImgs",skuImgs);
            productSku.put("spu",poductSpu);
            return new JsonBean(0,productSku,"success");
        }
        return new JsonBean(-1,null,"网络波动获取数据失败，请退出重试！");
    }

    @RequestMapping("getspuattr")
    public JsonBean getSpuAttr(Integer spuId){
        System.out.println("进入获取属性控制层 spuId = "+spuId);
        Map<String,Object> map = new HashMap<>();
        List<ProductSku> colorList = productSkuService.selectColorsBySpuId(spuId);
        System.out.println(colorList.toString());
        if(colorList!=null){
            map.put("colorList",colorList);
            List<AttrBean> attrList = productSkuService.selectAttrBySpuId(spuId);
            map.put("attrbute",attrList);
            return new JsonBean(0,map,"success");
        }
        return new JsonBean(-1,null,"网络波动获取数据失败，请退出重试！");
    }

}
