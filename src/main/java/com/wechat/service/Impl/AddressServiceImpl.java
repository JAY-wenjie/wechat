package com.wechat.service.Impl;

import com.wechat.domain.mapper.PcaProvincesMapper;
import com.wechat.domain.mapper.UserAddressMapper;
import com.wechat.domain.model.PcaProvinces;
import com.wechat.domain.model.UserAddress;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.wechat.domain.mapper.AddressMapper;
import com.wechat.domain.model.Address;
import com.wechat.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    @Resource
    private AddressMapper addressMapper;

    @Resource
    private UserAddressMapper userAddressMapper;

    @Resource
    private PcaProvincesMapper pcaProvincesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {

        return addressMapper.insertSelective(record);
    }

    @Override
    public Address selectByPrimaryKey(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询所有省份
     * @return
     */
    @Override
    public List<PcaProvinces> selectAllProvinces() {
        return pcaProvincesMapper.selectAll();
    }


}
