package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongjiaodongtaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongjiaodongtaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongjiaodongtaiView;


/**
 * 公交动态
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface GongjiaodongtaiService extends IService<GongjiaodongtaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongjiaodongtaiVO> selectListVO(Wrapper<GongjiaodongtaiEntity> wrapper);
   	
   	GongjiaodongtaiVO selectVO(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);
   	
   	List<GongjiaodongtaiView> selectListView(Wrapper<GongjiaodongtaiEntity> wrapper);
   	
   	GongjiaodongtaiView selectView(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongjiaodongtaiEntity> wrapper);

   	

}

