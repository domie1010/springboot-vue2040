package com.dao;

import com.entity.GongjiaoxianluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongjiaoxianluVO;
import com.entity.view.GongjiaoxianluView;


/**
 * 公交线路
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface GongjiaoxianluDao extends BaseMapper<GongjiaoxianluEntity> {
	
	List<GongjiaoxianluVO> selectListVO(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);
	
	GongjiaoxianluVO selectVO(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);
	
	List<GongjiaoxianluView> selectListView(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);

	List<GongjiaoxianluView> selectListView(Pagination page,@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);

	
	GongjiaoxianluView selectView(@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongjiaoxianluEntity> wrapper);



}
