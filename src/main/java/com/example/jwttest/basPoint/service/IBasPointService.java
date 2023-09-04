package com.example.jwttest.basPoint.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.basPoint.entity.BasPoint;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
public interface IBasPointService extends IService<BasPoint> {

    Page<BasPoint> selectPage(Page<BasPoint> page, BasPoint basPoint);


    int insert(BasPoint basPoint);

    int updateBasPoint(BasPoint basPoint);

    int deleteBasPoint(BasPoint basPoint);

    List<Map<String, String>> pointAndDevice();
}
