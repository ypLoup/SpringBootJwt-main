package com.example.jwttest.basDevice.mapper;

import com.example.jwttest.basDevice.entity.BasDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
public interface BasDeviceMapper extends BaseMapper<BasDevice> {

    List<Map<String, String>> deviceCountInfo();

    List<Map<String, String>> deviceCountInfoByCompany();
}
