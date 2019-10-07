package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.PoductSpu;
import com.wechat.domain.model.ProductSku;
import com.wechat.service.PoductSpuService;
import com.wechat.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 首页展示
 * @author 文杰
 */
@RestController
public class IndexController {
    @Autowired
    PoductSpuService poductSpuService;
    @Autowired
    ProductSkuService productSkuService;

    @RequestMapping("getproduct")
    public JsonBean getProduct(){
        List<PoductSpu> poductSpuList = poductSpuService.selectAllProductSpu();
        if(poductSpuList!=null){
            System.out.println("查到的商品："+poductSpuList.get(0).getProductSku().toString());
            return new JsonBean(0,poductSpuList,"success");
        }
        return new JsonBean(-1,null,"网络波动获取数据失败，请退出重试！");
    }

    @RequestMapping("getskubyid")
    public JsonBean getSkuByid(Integer skuId){
        ProductSku productSku = productSkuService.selectByPrimaryKey(skuId);
        if(productSku!=null){
            return new JsonBean(0,productSku,"success");
        }
        return new JsonBean(-1,null,"网络波动获取数据失败，请退出重试！");
    }

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
}
