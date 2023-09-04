package com.example.jwttest.basDevice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.basDevice.entity.BasDevice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
public interface IBasDeviceService extends IService<BasDevice> {

    Page<BasDevice> selectPage(Page<BasDevice> page, BasDevice basDevice);

    int insert(BasDevice basDevice);

    int updateBasDevice(BasDevice basDevice);

    int deleteBasDevice(BasDevice basDevice);

    List<Map<String, String>> deviceCountInfo();

    List<Map<String, String>> deviceCountInfoByCompany();

    List<BasDevice> selectList(BasDevice basDevice);
}
