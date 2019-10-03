package com.wechat.service;

import com.wechat.domain.model.Qrcode;
import com.wechat.domain.model.WxUser;

public interface QrcodeService{


    int deleteByPrimaryKey(Integer id);

    int insert(Qrcode record);

    int insertSelective(Qrcode record);

    Qrcode selectByPrimaryKey(WxUser wxUser);


    int updateByPrimaryKeySelective(Qrcode record);

    int updateByPrimaryKey(Qrcode record);

    Qrcode getQrcode(WxUser wxUser);

}
