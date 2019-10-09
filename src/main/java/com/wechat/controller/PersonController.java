package com.wechat.controller;

import com.wechat.commons.JsonBean;
import com.wechat.domain.model.Address;
import com.wechat.domain.model.PcaProvinces;
import com.wechat.domain.model.UserAddress;
import com.wechat.domain.model.WxUser;
import com.wechat.service.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;
import java.util.Map;

/**
 * 个人中心控制层
 *
 * @author 文杰
 */
@RestController
public class PersonController {
    @Autowired
    WxUserService wxUserService;

    @Autowired
    UsereScoreService usereScoreService;

    @Autowired
    ScoreInfoService scoreInfoService;

    @Autowired
    AddressService addressService;

    @Autowired
    UserAddressService userAddressService;

    /**
     * 返回个人信息
     *
     * @param session
     * @return
     * @author 文杰
     */
    @RequestMapping("showpersoninfo")
    public JsonBean showPersonInfo(HttpSession session) {
        WxUser wxUser = (WxUser) session.getAttribute("wxUser");
        if (wxUser != null) {
            System.out.println("showPersonInfo获取到的session数据" + wxUser.toString());
            wxUser.setScore(usereScoreService.selectByUserId(wxUser).getScore());
            wxUser.setScoreInfoList(scoreInfoService.selectByScoreId(usereScoreService.selectByUserId(wxUser).getId()));
            System.out.println(wxUser.getScoreInfoList().toString());
            return new JsonBean(0, wxUser, "success");
        }
        return new JsonBean(-1, null, "session中没有对象");
    }

    /**
     * 获取所有省份
     *@author 文杰
     * @return
     */
    @RequestMapping("getallprovinces")
    public JsonBean getAllProvinces() {
        List<PcaProvinces> pcaProvincesList = addressService.selectAllProvinces();
        if (pcaProvincesList != null) {
            System.out.println("获取省份成功");
            return new JsonBean(0, pcaProvincesList, "success");
        }
        return new JsonBean(-1, null, "网络连接失败请重试！");
    }

    /**
     * 添加地址
     * @author 文杰
     * @param address
     * @return
     */
    @RequestMapping("setaddress")
    public JsonBean setAddress(Address address,HttpSession session) {
        int result =  addressService.insert(address);
        if ( result> 0) {
            UserAddress userAddress = new UserAddress();
            WxUser wxUser = (WxUser)session.getAttribute("wxUser");
//            WxUser wxUser = new WxUser();
//            wxUser.setId(1);
            userAddress.setAdressId(address.getId());
            userAddress.setUserId(wxUser.getId());
            userAddressService.insert(userAddress);
            return new JsonBean(0, null, "success");
        }
        return new JsonBean(-1, null, "地址添加失败请重试");
    }

    /**
     * 获取该用户的地址
     * @author 文杰
     * @param session
     * @return
     */
    @RequestMapping("getaddress")
    public JsonBean getAddress(HttpSession session) {
        WxUser wxUser = (WxUser) session.getAttribute("wxUser");
        //WxUser wxUser = new WxUser();
        //wxUser.setId(1);
        List<Map<String,Object>> addressList= userAddressService.selectUserAddress(wxUser);
        if ( addressList!=null) {
            return new JsonBean(0, addressList, "success");
        }
        return new JsonBean(-1, null, "地址查询失败请重试");
    }

}
