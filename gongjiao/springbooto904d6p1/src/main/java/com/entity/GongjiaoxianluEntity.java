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
 * 公交线路
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
@TableName("gongjiaoxianlu")
public class GongjiaoxianluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongjiaoxianluEntity() {
		
	}
	
	public GongjiaoxianluEntity(T t) {
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
	 * 公交车号
	 */
					
	private String gongjiaochehao;
	
	/**
	 * 路线图片
	 */
					
	private String luxiantupian;
	
	/**
	 * 车次
	 */
					
	private String checi;
	
	/**
	 * 线路
	 */
					
	private String xianlu;
	
	/**
	 * 始发站点
	 */
					
	private String shifazhandian;
	
	/**
	 * 票价
	 */
					
	private String piaojia;
	
	/**
	 * 途径站点
	 */
					
	private String tujingzhandian;
	
	/**
	 * 终点站点
	 */
					
	private String zhongdianzhandian;
	
	/**
	 * 换乘信息
	 */
					
	private String huanchengxinxi;
	
	/**
	 * 运行时间
	 */
					
	private String yunxingshijian;
	
	/**
	 * 路线详情
	 */
					
	private String luxianxiangqing;
	
	/**
	 * 更新时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date gengxinshijian;
	
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
	 * 评论数
	 */
					
	private Integer discussnum;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：公交车号
	 */
	public void setGongjiaochehao(String gongjiaochehao) {
		this.gongjiaochehao = gongjiaochehao;
	}
	/**
	 * 获取：公交车号
	 */
	public String getGongjiaochehao() {
		return gongjiaochehao;
	}
	/**
	 * 设置：路线图片
	 */
	public void setLuxiantupian(String luxiantupian) {
		this.luxiantupian = luxiantupian;
	}
	/**
	 * 获取：路线图片
	 */
	public String getLuxiantupian() {
		return luxiantupian;
	}
	/**
	 * 设置：车次
	 */
	public void setCheci(String checi) {
		this.checi = checi;
	}
	/**
	 * 获取：车次
	 */
	public String getCheci() {
		return checi;
	}
	/**
	 * 设置：线路
	 */
	public void setXianlu(String xianlu) {
		this.xianlu = xianlu;
	}
	/**
	 * 获取：线路
	 */
	public String getXianlu() {
		return xianlu;
	}
	/**
	 * 设置：始发站点
	 */
	public void setShifazhandian(String shifazhandian) {
		this.shifazhandian = shifazhandian;
	}
	/**
	 * 获取：始发站点
	 */
	public String getShifazhandian() {
		return shifazhandian;
	}
	/**
	 * 设置：票价
	 */
	public void setPiaojia(String piaojia) {
		this.piaojia = piaojia;
	}
	/**
	 * 获取：票价
	 */
	public String getPiaojia() {
		return piaojia;
	}
	/**
	 * 设置：途径站点
	 */
	public void setTujingzhandian(String tujingzhandian) {
		this.tujingzhandian = tujingzhandian;
	}
	/**
	 * 获取：途径站点
	 */
	public String getTujingzhandian() {
		return tujingzhandian;
	}
	/**
	 * 设置：终点站点
	 */
	public void setZhongdianzhandian(String zhongdianzhandian) {
		this.zhongdianzhandian = zhongdianzhandian;
	}
	/**
	 * 获取：终点站点
	 */
	public String getZhongdianzhandian() {
		return zhongdianzhandian;
	}
	/**
	 * 设置：换乘信息
	 */
	public void setHuanchengxinxi(String huanchengxinxi) {
		this.huanchengxinxi = huanchengxinxi;
	}
	/**
	 * 获取：换乘信息
	 */
	public String getHuanchengxinxi() {
		return huanchengxinxi;
	}
	/**
	 * 设置：运行时间
	 */
	public void setYunxingshijian(String yunxingshijian) {
		this.yunxingshijian = yunxingshijian;
	}
	/**
	 * 获取：运行时间
	 */
	public String getYunxingshijian() {
		return yunxingshijian;
	}
	/**
	 * 设置：路线详情
	 */
	public void setLuxianxiangqing(String luxianxiangqing) {
		this.luxianxiangqing = luxianxiangqing;
	}
	/**
	 * 获取：路线详情
	 */
	public String getLuxianxiangqing() {
		return luxianxiangqing;
	}
	/**
	 * 设置：更新时间
	 */
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
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
	/**
	 * 设置：评论数
	 */
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
	/**
	 * 设置：收藏数
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
