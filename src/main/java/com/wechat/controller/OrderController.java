package com.wechat.controller;

import com.wechat.domain.model.*;
import com.wechat.service.OrderInfoService;
import com.wechat.service.OrderService;
import com.wechat.service.ProductCarService;
import com.wechat.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderInfoService orderInfoService;
    @Autowired
    ProductSkuService productSkuService;


@Autowired
ProductCarService productCarService;
    @RequestMapping(value = "insertorder")
    public String insertorder(HttpSession session) {
  //获取用户信息
        WxUser wxUser = (WxUser) session.getAttribute("wxuser");
        //  wxUser.setId(qr_id);

        //   int sum= (int) session.getAttribute("sum");


        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ;

        //   Timestamp.valueOf(simpleDateFormat.format(date)
//   String resultD=  simpleDateFormat.format(date);
//        java.sql.Date now= (java.sql.Date) new Date(resultD);
        Order order = new Order();
      //  order.setId(2);
        //将获取的用户信息填入订单userid
        order.setUserId(36);
        Date date = new Date();
        java.sql.Date date1=new java.sql.Date(date.getTime());
        //当前时间
        order.setCreatTime(date1);

        System.out.println("date" + date1);
//        order.setPayTime();
//        order.setEndTime(date1);
      // int sum =(int)session.getAttribute("sum");
        order.setSumPrice(66);

//添加订单表信息
      int a= orderService.insert(order);
     //   System.out.println("a" + a);
        //定义订单详情表的集合
        List<OrderInfo> orderInfoList = new ArrayList<>();
        //定义订单详情的对象
        OrderInfo orderInfo = new OrderInfo();
        //搜索购物车状态为选中的商品
        List<ProductCar> carList = productCarService.selectBystatue(0);
        for (int i = 0; i < carList.size(); i++) {
            // orderInfoList.get(i).setProductId(listSku.get(i).getId());
            //根据选中的购物车商品添加到订单详情表中
            orderInfo.setProductId(carList.get(i).getId());
            orderInfo.setOrderId(order.getId());
            orderInfo.setProductNum(carList.get(i).getProductSkuNum());
            orderInfo.setStatus(-1);
            orderInfo.setPayPrice(99);
            int b = orderInfoService.insert(orderInfo);
            System.out.println("b" + b);
      ProductSku productSku= productSkuService.selectByPrimaryKey(carList.get(i).getId());
      int amount=productSku.getAmount();
      int num=carList.get(i).getProductSkuNum();
      int amount2=amount-num;
      productSku.setAmount(amount2);
      int c=productSkuService.updateByPrimaryKeySelective(productSku);
            System.out.println("c"+c);
        }

        return "";

    }



}
