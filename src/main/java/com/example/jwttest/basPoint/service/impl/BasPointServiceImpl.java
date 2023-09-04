package com.example.jwttest.basPoint.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.basPoint.entity.BasPoint;
import com.example.jwttest.basPoint.mapper.BasPointMapper;
import com.example.jwttest.basPoint.service.IBasPointService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
@Service
public class BasPointServiceImpl extends ServiceImpl<BasPointMapper, BasPoint> implements IBasPointService {

    @Resource
    BasPointMapper basPointMapper;

    @Override
    public Page<BasPoint> selectPage(Page<BasPoint> page, BasPoint basPoint) {
        QueryWrapper<BasPoint> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(basPoint.getPointName()),"point_name",basPoint.getPointName());
        if (basPoint.getStatus() != null){
            queryWrapper.eq("status",basPoint.getStatus());
        }
        queryWrapper.eq(StringUtils.hasText(basPoint.getCompanyName()),"company_name",basPoint.getCompanyName());
        return page(page,queryWrapper);
    }




    @Override
    public int insert(BasPoint basPoint) {
        if (query().eq("point_code", basPoint.getPointCode()).eq("status",1).one() != null) {
            return -1;//已注册
        }
        save(basPoint);
        return 0;
    }

    @Override
    public int updateBasPoint(BasPoint basPoint) {
        if(query().eq("id",basPoint.getId()).one() == null){
            return -1;
        }
        updateById(basPoint);
        return 0;
    }

    @Override
    public int deleteBasPoint(BasPoint basPoint) {
        if(query().eq("id",basPoint.getId()).one() == null){
            return -1;
        }
        removeById(basPoint);
        return 0;
    }

    @Override
    public List<Map<String, String>> pointAndDevice() {
        return basPointMapper.pointAndDevice();
    }
}
