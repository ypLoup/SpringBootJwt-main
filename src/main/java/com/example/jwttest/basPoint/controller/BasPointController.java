package com.example.jwttest.basPoint.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.api.CommonResult;
import com.example.jwttest.basDict.entity.BasDict;
import com.example.jwttest.basPoint.entity.BasPoint;
import com.example.jwttest.basPoint.service.IBasPointService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
@RestController
@RequestMapping("/basPoint")
public class BasPointController {
    @Resource
    IBasPointService basPointService;

    /**
     * 分页查询点位信息
     * @param pagelimit
     * @param pageSize
     * @param basPoint
     * @return
     */
    @PostMapping("/selectPage")
    public CommonResult selectPage(int pagelimit,int pageSize,BasPoint basPoint) {
        Page<BasPoint> page =Page.of(pagelimit,pageSize);
        page = basPointService.selectPage(page,basPoint);
        return CommonResult.success(page);
    }


    /**
     * 新增点位信息
     * @param basPoint
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insertBasPoint(BasPoint basPoint) {
        int result = basPointService.insert(basPoint);
        if (result == -1) {
            return CommonResult.failed("添加失败，信息已存在！");
        }
        return CommonResult.success("添加成功");
    }


    /**
     * 更新点位信息
     * @param basPoint
     * @return
     */
    @PostMapping("/update")
    public CommonResult updateBasPoint(BasPoint basPoint) {
        int result = basPointService.updateBasPoint(basPoint);
        if (result == -1) {
            return CommonResult.failed("更新失败");
        }
        return CommonResult.success("更新成功");
    }




    /**
     * 更新点位信息
     * @param basPoint
     * @return
     */
    @PostMapping("/delete")
    public CommonResult deleteBasPoint(BasPoint basPoint) {
        int result = basPointService.deleteBasPoint(basPoint);
        if (result == -1) {
            return CommonResult.failed("删除失败");
        }
        return CommonResult.success("删除成功");
    }



    /**
     * 按点位统计设备
     * @param
     * @return
     */
    @PostMapping("/pointAndDevice")
    public CommonResult pointAndDevice() {
        List<Map<String,String>>CountInfo = new ArrayList<Map<String,String>>();
        CountInfo = basPointService.pointAndDevice();

        return CommonResult.success(CountInfo);
    }


}

