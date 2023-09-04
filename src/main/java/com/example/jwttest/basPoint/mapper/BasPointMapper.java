package com.example.jwttest.basPoint.mapper;

import com.example.jwttest.basPoint.entity.BasPoint;
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
public interface BasPointMapper extends BaseMapper<BasPoint> {

    List<Map<String, String>> pointAndDevice();
}
