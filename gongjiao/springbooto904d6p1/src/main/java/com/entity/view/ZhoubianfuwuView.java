package com.entity.view;

import com.entity.ZhoubianfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 周边服务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@TableName("zhoubianfuwu")
public class ZhoubianfuwuView  extends ZhoubianfuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhoubianfuwuView(){
	}
 
 	public ZhoubianfuwuView(ZhoubianfuwuEntity zhoubianfuwuEntity){
 	try {
			BeanUtils.copyProperties(this, zhoubianfuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
