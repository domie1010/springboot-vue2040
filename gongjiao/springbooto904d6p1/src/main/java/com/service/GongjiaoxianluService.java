package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongjiaoxianluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.GongjiaoxianluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.GongjiaoxianluView;


/**
 * 公交线路
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface GongjiaoxianluService extends IService<GongjiaoxianluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongjiaoxianluVO> selectListVO(Wrapper<GongjiaoxianluEntity> wrapper);
   	
   	GongjiaoxianluVO selectVO(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);
   	
   	List<GongjiaoxianluView> selectListView(Wrapper<GongjiaoxianluEntity> wrapper);
   	
   	GongjiaoxianluView selectView(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongjiaoxianluEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GongjiaoxianluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GongjiaoxianluEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GongjiaoxianluEntity> wrapper);



}

