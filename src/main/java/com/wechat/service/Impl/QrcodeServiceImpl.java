package com.wechat.service.Impl;

import com.wechat.commons.Constant;
import com.wechat.commons.HttpClientUtil;
import com.wechat.domain.model.WxUser;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.QrcodeMapper;
import com.wechat.domain.model.Qrcode;
import com.wechat.service.QrcodeService;
@Service
public class QrcodeServiceImpl implements QrcodeService{
    private int nowTime = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
    @Resource
    private QrcodeMapper qrcodeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return qrcodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Qrcode record) {
        return qrcodeMapper.insert(record);
    }

    @Override
    public int insertSelective(Qrcode record) {
        return qrcodeMapper.insertSelective(record);
    }

    /**
     *
     * @param wxUser
     * @return
     */
    @Override
    public Qrcode selectByPrimaryKey(WxUser wxUser) {

        return qrcodeMapper.selectByPrimaryKey(wxUser);
    }



    @Override
    public int updateByPrimaryKeySelective(Qrcode record) {
        return qrcodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Qrcode record) {
        return qrcodeMapper.updateByPrimaryKey(record);
    }

    /**
     * 通过openid获取二维码
     * 若该用户首次获取二维码则，直接增加一条二维码并返回该二维码数据
     * 若非首次获取则需进行判断，若库中二维码过期，应新生成二维码并更新库中ticket值
     * 若未过期则取出
     * @param wxUser
     * @return
     */
    @Override
    public Qrcode getQrcode(WxUser wxUser) {

        Qrcode qrcode = qrcodeMapper.selectByPrimaryKey(wxUser);
        System.out.println("二维码获取方法传入wxUser的值："+wxUser.toString());
        if(qrcode==null){
            qrcode = new Qrcode();
            int expire_seconds = 2592000;//设置有效时间
            qrcode = getQrTicket(qrcode,wxUser, expire_seconds);
            qrcode.setOpenid(wxUser.getOpenid());
            qrcodeMapper.insertSelective(qrcode);
        }else {
            //如果过期重新申请
            if(nowTime-qrcode.getCreateSeconds()>qrcode.getExpireSeconds()){
                int expire_seconds = 2592000;//设置有效时间
                qrcode = getQrTicket(qrcode,wxUser, expire_seconds);
                qrcodeMapper.updateByPrimaryKey(qrcode);
            }
        }

        return qrcode;
    }

    private Qrcode getQrTicket(Qrcode qrcode,WxUser wxUser,Integer expire_seconds ) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+ Constant.getAccess_token();
        String data = "{\"expire_seconds\": "+expire_seconds+", \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "+wxUser.getId()+"}}}";
        System.out.println("生成二维码需向微信服务器传递的json数据："+data);
        JSONObject jsonObject = HttpClientUtil.doPost(url, data);
        System.out.println("微信返回的二维码相关的json数据："+jsonObject.toString());
        String ticket = jsonObject.get("ticket").toString();
        qrcode.setExpireSeconds(expire_seconds);
        qrcode.setCreateSeconds(nowTime);
        qrcode.setTicket(ticket);
        return qrcode;
    }


}
