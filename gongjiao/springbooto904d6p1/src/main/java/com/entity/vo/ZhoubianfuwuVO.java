package com.entity.vo;

import com.entity.ZhoubianfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 周边服务
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public class ZhoubianfuwuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 服务类型
	 */
	
	private String fuwuleixing;
		
	/**
	 * 周边详情
	 */
	
	private String zhoubianxiangqing;
				
	
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
	 * 设置：服务类型
	 */
	 
	public void setFuwuleixing(String fuwuleixing) {
		this.fuwuleixing = fuwuleixing;
	}
	
	/**
	 * 获取：服务类型
	 */
	public String getFuwuleixing() {
		return fuwuleixing;
	}
				
	
	/**
	 * 设置：周边详情
	 */
	 
	public void setZhoubianxiangqing(String zhoubianxiangqing) {
		this.zhoubianxiangqing = zhoubianxiangqing;
	}
	
	/**
	 * 获取：周边详情
	 */
	public String getZhoubianxiangqing() {
		return zhoubianxiangqing;
	}
			
}
