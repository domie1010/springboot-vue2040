package com.entity.vo;

import com.entity.GongjiaozhandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 公交站点
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public class GongjiaozhandianVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 站点照片
	 */
	
	private String zhandianzhaopian;
		
	/**
	 * 公交线路
	 */
	
	private String gongjiaoxianlu;
		
	/**
	 * 道路名称
	 */
	
	private String daolumingcheng;
		
	/**
	 * 站点位置
	 */
	
	private String zhandianweizhi;
		
	/**
	 * 经过公交
	 */
	
	private String jingguogongjiao;
		
	/**
	 * 到站时间
	 */
	
	private String daozhanshijian;
		
	/**
	 * 周边站点
	 */
	
	private String zhoubianzhandian;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
				
	
	/**
	 * 设置：站点照片
	 */
	 
	public void setZhandianzhaopian(String zhandianzhaopian) {
		this.zhandianzhaopian = zhandianzhaopian;
	}
	
	/**
	 * 获取：站点照片
	 */
	public String getZhandianzhaopian() {
		return zhandianzhaopian;
	}
				
	
	/**
	 * 设置：公交线路
	 */
	 
	public void setGongjiaoxianlu(String gongjiaoxianlu) {
		this.gongjiaoxianlu = gongjiaoxianlu;
	}
	
	/**
	 * 获取：公交线路
	 */
	public String getGongjiaoxianlu() {
		return gongjiaoxianlu;
	}
				
	
	/**
	 * 设置：道路名称
	 */
	 
	public void setDaolumingcheng(String daolumingcheng) {
		this.daolumingcheng = daolumingcheng;
	}
	
	/**
	 * 获取：道路名称
	 */
	public String getDaolumingcheng() {
		return daolumingcheng;
	}
				
	
	/**
	 * 设置：站点位置
	 */
	 
	public void setZhandianweizhi(String zhandianweizhi) {
		this.zhandianweizhi = zhandianweizhi;
	}
	
	/**
	 * 获取：站点位置
	 */
	public String getZhandianweizhi() {
		return zhandianweizhi;
	}
				
	
	/**
	 * 设置：经过公交
	 */
	 
	public void setJingguogongjiao(String jingguogongjiao) {
		this.jingguogongjiao = jingguogongjiao;
	}
	
	/**
	 * 获取：经过公交
	 */
	public String getJingguogongjiao() {
		return jingguogongjiao;
	}
				
	
	/**
	 * 设置：到站时间
	 */
	 
	public void setDaozhanshijian(String daozhanshijian) {
		this.daozhanshijian = daozhanshijian;
	}
	
	/**
	 * 获取：到站时间
	 */
	public String getDaozhanshijian() {
		return daozhanshijian;
	}
				
	
	/**
	 * 设置：周边站点
	 */
	 
	public void setZhoubianzhandian(String zhoubianzhandian) {
		this.zhoubianzhandian = zhoubianzhandian;
	}
	
	/**
	 * 获取：周边站点
	 */
	public String getZhoubianzhandian() {
		return zhoubianzhandian;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
			
}
