package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 公交动态
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@TableName("gongjiaodongtai")
public class GongjiaodongtaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongjiaodongtaiEntity() {
		
	}
	
	public GongjiaodongtaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 公交站点
	 */
					
	private String gongjiaozhandian;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 人流量
	 */
					
	private String renliuliang;
	
	/**
	 * 拥堵情况
	 */
					
	private String yongduqingkuang;
	
	/**
	 * 动态详情
	 */
					
	private String dongtaixiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：公交站点
	 */
	public void setGongjiaozhandian(String gongjiaozhandian) {
		this.gongjiaozhandian = gongjiaozhandian;
	}
	/**
	 * 获取：公交站点
	 */
	public String getGongjiaozhandian() {
		return gongjiaozhandian;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：人流量
	 */
	public void setRenliuliang(String renliuliang) {
		this.renliuliang = renliuliang;
	}
	/**
	 * 获取：人流量
	 */
	public String getRenliuliang() {
		return renliuliang;
	}
	/**
	 * 设置：拥堵情况
	 */
	public void setYongduqingkuang(String yongduqingkuang) {
		this.yongduqingkuang = yongduqingkuang;
	}
	/**
	 * 获取：拥堵情况
	 */
	public String getYongduqingkuang() {
		return yongduqingkuang;
	}
	/**
	 * 设置：动态详情
	 */
	public void setDongtaixiangqing(String dongtaixiangqing) {
		this.dongtaixiangqing = dongtaixiangqing;
	}
	/**
	 * 获取：动态详情
	 */
	public String getDongtaixiangqing() {
		return dongtaixiangqing;
	}

}
