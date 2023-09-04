package com.example.jwttest.basDevice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.api.CommonResult;
import com.example.jwttest.basDevice.entity.BasDevice;
import com.example.jwttest.basDevice.service.IBasDeviceService;
import com.example.jwttest.basPoint.entity.BasPoint;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RequestMapping("/basDevice")
public class BasDeviceController {

    @Resource
    IBasDeviceService basDeviceService;


    /**
     * 分页查询设备信息
     * @param pagelimit
     * @param pageSize
     * @param basDevice
     * @return
     */
    @PostMapping("/selectPage")
    public CommonResult selectPage(int pagelimit, int pageSize, BasDevice basDevice) {
        Page<BasDevice> page =Page.of(pagelimit,pageSize);
        page = basDeviceService.selectPage(page,basDevice);
        return CommonResult.success(page);
    }


    /**
     * 新增设备信息
     * @param basDevice
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insertBasDevice(BasDevice basDevice) {
        int result = basDeviceService.insert(basDevice);
        if (result == -1) {
            return CommonResult.failed("添加失败，信息已存在！");
        }
        return CommonResult.success("添加成功");
    }


    /**
     * 更新设备信息
     * @param basDevice
     * @return
     */
    @PostMapping("/update")
    public CommonResult updateBasDevice(BasDevice basDevice) {
        int result = basDeviceService.updateBasDevice(basDevice);
        if (result == -1) {
            return CommonResult.failed("更新失败");
        }
        return CommonResult.success("更新成功");
    }



    /**
     * 更新设备信息
     * @param basDevice
     * @return
     */
    @PostMapping("/delete")
    public CommonResult deleteBasDevice(BasDevice basDevice) {
        int result = basDeviceService.deleteBasDevice(basDevice);
        if (result == -1) {
            return CommonResult.failed("删除失败");
        }
        return CommonResult.success("删除成功");
    }


    /**
     * 设备统计信息
     * @param
     * @return
     */
    @PostMapping("/deviceCountInfo")
    public CommonResult deviceCountInfo() {
        List<Map<String,String>>CountInfo = new ArrayList<Map<String,String>>();
        CountInfo = basDeviceService.deviceCountInfo();
        return CommonResult.success(CountInfo);
    }

    /**
     * 按单位统计设备信息
     * @param
     * @return
     */
    @PostMapping("/deviceCountInfoByCompany")
    public CommonResult deviceCountInfoByCompany() {
        List<Map<String,String>>CountInfo = new ArrayList<Map<String,String>>();
        CountInfo = basDeviceService.deviceCountInfoByCompany();
        return CommonResult.success(CountInfo);
    }


    /**
     * 查询设备信息
     *
     *
     * @param basDevice
     * @return
     */
    @PostMapping("/selectList")
    public CommonResult selectList(BasDevice basDevice) {
        List<BasDevice> basDeviceList = new ArrayList<>();
        basDeviceList = basDeviceService.selectList(basDevice);
        return CommonResult.success(basDeviceList);
    }



}

