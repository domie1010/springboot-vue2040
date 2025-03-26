package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgongjiaoxianluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgongjiaoxianluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgongjiaoxianluView;


/**
 * 公交线路评论表
 *
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface DiscussgongjiaoxianluService extends IService<DiscussgongjiaoxianluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgongjiaoxianluVO> selectListVO(Wrapper<DiscussgongjiaoxianluEntity> wrapper);
   	
   	DiscussgongjiaoxianluVO selectVO(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);
   	
   	List<DiscussgongjiaoxianluView> selectListView(Wrapper<DiscussgongjiaoxianluEntity> wrapper);
   	
   	DiscussgongjiaoxianluView selectView(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgongjiaoxianluEntity> wrapper);

   	

}

