package com.entity.model;

import com.entity.GongjiaodongtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 公交动态
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public class GongjiaodongtaiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
