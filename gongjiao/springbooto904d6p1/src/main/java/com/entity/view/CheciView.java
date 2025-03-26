package com.entity.view;

import com.entity.CheciEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 车次
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
@TableName("checi")
public class CheciView  extends CheciEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CheciView(){
	}
 
 	public CheciView(CheciEntity checiEntity){
 	try {
			BeanUtils.copyProperties(this, checiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
