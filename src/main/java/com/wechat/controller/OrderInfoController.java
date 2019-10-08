package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.OrderInfo;
import com.wechat.domain.model.PoductSpu;
import com.wechat.domain.model.ProductCar;
import com.wechat.domain.model.ProductSku;
import com.wechat.service.OrderInfoService;
import com.wechat.service.PoductSpuService;
import com.wechat.service.ProductCarService;
import com.wechat.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderInfoController {
@Autowired
    OrderInfoService orderInfoService;
@Autowired
    ProductSkuService productSkuService;
    @Autowired
    PoductSpuService poductSpuService;
    @Autowired
    ProductCarService productCarService;
@RequestMapping(value = "selOrderInfo",method = RequestMethod.POST)
    public JsonBean selOrderInfo(){
    //获取全部订单
    List<OrderInfo> listinfo=orderInfoService.selAll();
        Map<String,Object> map= listmsg(listinfo);
                return new JsonBean(0,map,"success");
}
@RequestMapping(value = "selOrderInfoBystatus",method = RequestMethod.POST)
    public JsonBean selOrderInfoBystatus(int statues){
    List<OrderInfo> listinfo=orderInfoService.selByStatus(statues);
    Map<String,Object> map= listmsg(listinfo);
    return new JsonBean(0,map,"success");
}
 public Map<String,Object> listmsg( List<OrderInfo> listinfo){
     List<ProductSku> skuList=new ArrayList<>();
     List<PoductSpu> spuList=new ArrayList<>();
     List<ProductCar> carlist=new ArrayList<>();
     List listNum=new ArrayList();
     for (int i=0;i<listinfo.size();i++){
         int skuid=   listinfo.get(i).getProductId();
         ProductSku productSku= productSkuService.selectByPrimaryKey(skuid);
         skuList.add(i,productSku);
         ProductCar productCar=productCarService.selectByPrimaryKey(skuid);
         carlist.add(i,productCar);
         String listinfoNum=""+listinfo.get(i).getId()+listinfo.get(i).getOrderId()+listinfo.get(i).getProductId()+"";
         System.out.println(listinfoNum);
         listNum.add(i,listinfoNum);
     }
     for (int i=0;i<skuList.size();i++){
         int spu=skuList.get(i).getProductSpuId();
         PoductSpu poductSpu=poductSpuService.selectByPrimaryKey(spu);
         spuList.add(i,poductSpu);

     }
     Map<String,Object> map=new HashMap<>();
     map.put("listinfo",listinfo);
     map.put("skuList",skuList);
     map.put("spuList",spuList);
     map.put("carlist",carlist);
     map.put("listNum",listNum);
     return map;
 }


}
