package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongjiaozhandianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongjiaozhandianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongjiaozhandianView;


/**
 * 公交站点
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface GongjiaozhandianService extends IService<GongjiaozhandianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongjiaozhandianVO> selectListVO(Wrapper<GongjiaozhandianEntity> wrapper);
   	
   	GongjiaozhandianVO selectVO(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);
   	
   	List<GongjiaozhandianView> selectListView(Wrapper<GongjiaozhandianEntity> wrapper);
   	
   	GongjiaozhandianView selectView(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongjiaozhandianEntity> wrapper);

   	

}

