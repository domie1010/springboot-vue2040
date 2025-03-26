package com.entity.view;

import com.entity.GongjiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 公交信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@TableName("gongjiaoxinxi")
public class GongjiaoxinxiView  extends GongjiaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongjiaoxinxiView(){
	}
 
 	public GongjiaoxinxiView(GongjiaoxinxiEntity gongjiaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, gongjiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
