package com.example.jwttest.basDevice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lpf
 * @since 2023-04-04
 */
public class BasDevice implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 点位id
     */
    @TableField("point_id")
    private Integer pointId;

    /**
     * mac地址
     */
    @TableField("mac_address")
    private String macAddress;

    /**
     * 设备名称
     */
    @TableField("device_name")
    private String deviceName;

    /**
     * 所属单位id
     */
    @TableField("company_id")
    private Integer companyId;

    /**
     * 所属单位名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 设备类型id
     */
    @TableField("device_type_id")
    private Integer deviceTypeId;

    /**
     * 设备类型名称
     */
    @TableField("device_type_name")
    private String deviceTypeName;

    /**
     * 设备ip
     */
    @TableField("device_ip")
    private String deviceIp;

    /**
     * 设备地址
     */
    private String address;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 状态 1：启用 0禁用
     */
    private Integer status;

    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPointId() {
        return pointId;
    }

    public void setPointId(Integer pointId) {
        this.pointId = pointId;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BasDevice{" +
        "id=" + id +
        ", pointId=" + pointId +
        ", macAddress=" + macAddress +
        ", deviceName=" + deviceName +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", deviceTypeId=" + deviceTypeId +
        ", deivceTypeName=" + deviceTypeName +
        ", deviceIp=" + deviceIp +
        ", address=" + address +
        ", lng=" + lng +
        ", lat=" + lat +
        ", status=" + status +
        ", imgUrl=" + imgUrl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
