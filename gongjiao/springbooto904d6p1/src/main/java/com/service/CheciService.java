package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheciEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheciVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheciView;


/**
 * 车次
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface CheciService extends IService<CheciEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheciVO> selectListVO(Wrapper<CheciEntity> wrapper);
   	
   	CheciVO selectVO(@Param("ew") Wrapper<CheciEntity> wrapper);
   	
   	List<CheciView> selectListView(Wrapper<CheciEntity> wrapper);
   	
   	CheciView selectView(@Param("ew") Wrapper<CheciEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheciEntity> wrapper);

   	

}

