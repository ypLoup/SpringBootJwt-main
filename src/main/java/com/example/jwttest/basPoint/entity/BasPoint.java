package com.example.jwttest.basPoint.entity;

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
public class BasPoint implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField("point_code")
    private String pointCode;

    /**
     * 点位名称
     */
    @TableField("point_name")
    private String pointName;

    /**
     * 立杆类型id
     */
    @TableField("ligan_type_id")
    private Integer liganTypeId;

    /**
     * 立杆类型名称
     */
    @TableField("ligan_type_name")
    private String liganTypeName;

    /**
     * 公司id
     */
    @TableField("company_id")
    private Integer companyId;

    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;

    /**
     * 地址
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
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 状态 1：启用 0：禁用
     */
    private Integer status;

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


    public String getPointCode() {
        return pointCode;
    }

    public void setPointCode(String pointCode) {
        this.pointCode = pointCode;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Integer getLiganTypeId() {
        return liganTypeId;
    }

    public void setLiganTypeId(Integer liganTypeId) {
        this.liganTypeId = liganTypeId;
    }

    public String getLiganTypeName() {
        return liganTypeName;
    }

    public void setLiganTypeName(String liganTypeName) {
        this.liganTypeName = liganTypeName;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "BasPoint{" +
        "id=" + id +
        ", pointCode=" + pointCode +
        ", pointName=" + pointName +
        ", liganTypeId=" + liganTypeId +
        ", liganTypeName=" + liganTypeName +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", address=" + address +
        ", lng=" + lng +
        ", lat=" + lat +
        ", imgUrl=" + imgUrl +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
