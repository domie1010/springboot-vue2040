package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XianluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XianluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XianluView;


/**
 * 线路
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface XianluService extends IService<XianluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianluVO> selectListVO(Wrapper<XianluEntity> wrapper);
   	
   	XianluVO selectVO(@Param("ew") Wrapper<XianluEntity> wrapper);
   	
   	List<XianluView> selectListView(Wrapper<XianluEntity> wrapper);
   	
   	XianluView selectView(@Param("ew") Wrapper<XianluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianluEntity> wrapper);

   	

}

