package com.wechat.controller;

import com.wechat.domain.model.*;
import com.wechat.service.OrderService;
import com.wechat.service.PoductSpuService;
import com.wechat.service.ProductCarService;
import com.wechat.service.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * zry
 * 购物车
 */
@RestController
public class ShopCarController {
    @Autowired
    ProductCarService productCarService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductSkuService productSkuService;
    @Autowired
    PoductSpuService poductSpuService;

    /**
     * zry
     * 查询购物车信息
     *
     * @param wxUser
     * @param session
     * @return
     */
    @RequestMapping(value = "selCar", method = RequestMethod.POST)
    public List<ProductCar> selCar(WxUser wxUser, HttpSession session) {
        //获取用户信息（id）
    //    wxUser = (WxUser) session.getAttribute("Wxuser");
//根据用户id查询所绑定的该用户的购物车信息
        wxUser.setId(36);
        List<ProductCar> productCarList = productCarService.listCat(wxUser);
        //定义一个值
       // int sum = 0;
        //循环遍历购物车信息
//        for (int i = 0; i < productCarList.size(); i++) {
//            //总价等于每个商品的价钱乘以数量
//            sum = (productCarList.get(i).getListSku().get(i).getSalePrice()) * (productCarList.get(i).getProductSkuNum());
//            //获取每个商品的总价
//            sum++;
////            List<ProductCar> list=new ArrayList() ;
////            list.add(i,productCarList.get(i).getListSku().get(i).getPoductSpu().getDescribe());
////            Map<String, Objects> map=new HashMap<>();
////            map.put("list",productCarList.get(i));
//        }
        //将总价放入session 方便后面获取
    //    session.setAttribute("sum", sum);
        //返回购物车信息结合
        System.out.println(productCarList.size());

        return productCarList;
    }

    /**
     * zry
     * 点击选中之后需要展示页面的值
     *
     * @param zhi
     * @param wxUser
     * @param session
     * @return
     */
    @RequestMapping(value = "selCar2", method = RequestMethod.POST)
    public Map<String, Object> selCa0r2(String zhi, WxUser wxUser, HttpSession session) {
        //获取用户信息（id）
        System.out.println("进入");
     //   wxUser = (WxUser) session.getAttribute("Wxuser");
        zhi="1,2,3";
        List<ProductSku> listSku = new ArrayList<>();
        List<PoductSpu> listSpu = new ArrayList<>();
        ProductCar productCar = new ProductCar();
        PoductSpu poductSpu = new PoductSpu();
        //将前端的获取的字符串（举例：1,2,3）变成1 2 3 并存进入数组

        String[] zhi1 = zhi.split(",");
        //循环输出数字信息 长度为数组的长度

        for (int i = 0; i < zhi1.length; i++) {
            //根据数组的值 当做sku表的id查询 所选中的购物车商品的信息
            ProductSku productSku = productSkuService.selectByPrimaryKey(Integer.parseInt(zhi1[i]));
            //将获取的sku对象信息 存入 sku 的集合
            listSku.add(i, productSku);
            //获取选中的sku的id 并根据id值查找所对应的购物车信息数据
            productCar = productCarService.selectByPrimaryKey(listSku.get(i).getId());
            //更改状态 变为选中
            productCar.setStatue(0);
            //获取修改的skuid
            productCar.setProductSkuId(Integer.parseInt(zhi1[i]));
            //获取修改的usrid
            productCar.setUserId(productCar.getUserId());

            System.out.println("productCar.getUserId()" + productCar.getUserId());
            //获取商品数量
            productCar.setProductSkuNum(productCar.getProductSkuNum());

            System.out.println("productCar.getProductSkuNum()" + productCar.getProductSkuNum());
            //修改信息 根据skuid修改状态 其他值一样
            int a = productCarService.updateByPrimaryKeySelective(productCar);
//根据选中sku中的spuid查询spu的信息并存入spu集合
            poductSpu = poductSpuService.selectByPrimaryKey(listSku.get(i).getProductSpuId());
            listSpu.add(i, poductSpu);
            //没有选中的sku的购物车状态为1
//            System.out.println("listSku.get(i).getId"+listSku.get(i).getId());
//            productCar=productCarService.selectByskuidNot(listSku.get(i).getId());
//            productCar.setStatue(1);
//            productCar.setUserId(productCar.getUserId());
//
//            System.out.println("productCar.getUserId()" + productCar.getUserId());
//            //获取商品数量
//            productCar.setProductSkuNum(productCar.getProductSkuNum());
//            //获取修改的skuid
//            productCar.setProductSkuId(Integer.parseInt(zhi1[i]));
//            System.out.println("productCar.getProductSkuNum()" + productCar.getProductSkuNum());
//            //修改信息 根据skuid修改状态 其他值一样
//            //修改
//            int b = productCarService.updateByPrimaryKeySelective(productCar);
        }

//定义map
        Map<String, Object> map = new HashMap<>();
        //添加sku集合
        map.put("listSku", listSku);
        //添加spu集合
        map.put("listSpu", listSpu);
//
        map.put("productCar", productCar);
        //根据选中的状态的商品查询购物车信息
        List<ProductCar> listcar=productCarService.selectBystatue(0);
        //数量
        int count = 0;
        for (int i = 0; i < listcar.size(); i++) {
            count++;
        }


        //  List<ProductSku> skuList=  session.getAttribute("listSku");
        //h获取的信息存入map
        map.put("count", count);
        map.put("sum", 99);
        int jifen = (int) (99 * (0.75));
        map.put("jifen", jifen);
        map.put("listcar",listcar);
        return map;
    }

    /**
     * zry
     * 根据状态为
     * @param session
     * @return
     */
    //购物车的第三个页面
    @RequestMapping(value = "selCar3")
    public Map<String, Object> selCar3(HttpSession session) {
  //     WxUser wxUser = (WxUser) session.getAttribute("Wxuser");
        Map<String, Object> map = new HashMap<>();
      //  int sum = (int) session.getAttribute("sum");
     //   List<ProductSku> skuList = productSkuService.selectByStatus(0);
        //根据选中的状态的商品查询购物车信息
        List<ProductCar> listcar=productCarService.selectBystatue(0);
        //数量
        int count = 0;
        for (int i = 0; i < listcar.size(); i++) {
            count++;
        }


        //  List<ProductSku> skuList=  session.getAttribute("listSku");
        //h获取的信息存入map
        map.put("count", count);
        map.put("sum", 99);
        int jifen = (int) (99 * (0.75));
        map.put("jifen", jifen);
        return map;
    }


}
