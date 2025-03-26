package com.dao;

import com.entity.XianluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianluVO;
import com.entity.view.XianluView;


/**
 * 线路
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface XianluDao extends BaseMapper<XianluEntity> {
	
	List<XianluVO> selectListVO(@Param("ew") Wrapper<XianluEntity> wrapper);
	
	XianluVO selectVO(@Param("ew") Wrapper<XianluEntity> wrapper);
	
	List<XianluView> selectListView(@Param("ew") Wrapper<XianluEntity> wrapper);

	List<XianluView> selectListView(Pagination page,@Param("ew") Wrapper<XianluEntity> wrapper);

	
	XianluView selectView(@Param("ew") Wrapper<XianluEntity> wrapper);
	

}
