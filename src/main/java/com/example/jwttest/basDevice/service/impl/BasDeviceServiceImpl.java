package com.example.jwttest.basDevice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.basDevice.entity.BasDevice;
import com.example.jwttest.basDevice.mapper.BasDeviceMapper;
import com.example.jwttest.basDevice.service.IBasDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jwttest.basPoint.entity.BasPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
@Service
public class BasDeviceServiceImpl extends ServiceImpl<BasDeviceMapper, BasDevice> implements IBasDeviceService {

    @Resource
    BasDeviceMapper basDeviceMapper;

    @Override
    public Page<BasDevice> selectPage(Page<BasDevice> page, BasDevice basDevice) {
        QueryWrapper<BasDevice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(basDevice.getDeviceName()),"device_name",basDevice.getDeviceName());
        queryWrapper.eq(StringUtils.hasText(basDevice.getCompanyName()),"company_name",basDevice.getCompanyName());
        if (basDevice.getStatus() != null){
            queryWrapper.eq("status",basDevice.getStatus());
        }
        if(basDevice.getCompanyId() != null){
            queryWrapper.eq("company_id",basDevice.getCompanyId());
        }

        if (basDevice.getPointId() != null){
            queryWrapper.eq("point_id",basDevice.getPointId());
        }
        return page(page,queryWrapper);
    }

    @Override
    public int insert(BasDevice basDevice) {
        if (query().eq("device_ip", basDevice.getDeviceIp()).eq("status",1).one() != null) {
            return -1;//已注册
        }
        save(basDevice);
        return 0;
    }

    @Override
    public int updateBasDevice(BasDevice basDevice) {
        if(query().eq("id",basDevice.getId()).one()== null){
            return -1;
        }
        updateById(basDevice);
        return 0;
    }

    @Override
    public int deleteBasDevice(BasDevice basDevice) {
        if(query().eq("id",basDevice.getId()).one() == null){
            return -1;
        }
        removeById(basDevice);
        return 0;
    }

    @Override
    public List<Map<String, String>> deviceCountInfo() {
        return basDeviceMapper.deviceCountInfo();
    }

    @Override
    public List<Map<String, String>> deviceCountInfoByCompany() {
        return basDeviceMapper.deviceCountInfoByCompany();
    }

    @Override
    public List<BasDevice> selectList(BasDevice basDevice) {
        QueryWrapper<BasDevice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(basDevice.getDeviceName()),"device_name",basDevice.getDeviceName());
        queryWrapper.eq(StringUtils.hasText(basDevice.getCompanyName()),"company_name",basDevice.getCompanyName());
        if (basDevice.getStatus() != null){
            queryWrapper.eq("status",basDevice.getStatus());
        }
        if(basDevice.getCompanyId() != null){
            queryWrapper.eq("company_id",basDevice.getCompanyId());
        }

        if (basDevice.getPointId() != null){
            queryWrapper.eq("point_id",basDevice.getPointId());
        }
        if (basDevice.getCreateTime() != null){
            queryWrapper.likeLeft("create_time",basDevice.getCreateTime());
        }
        return list(queryWrapper) ;
    }
}
