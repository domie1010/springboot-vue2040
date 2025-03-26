package com.dao;

import com.entity.CheciEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheciVO;
import com.entity.view.CheciView;


/**
 * 车次
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
public interface CheciDao extends BaseMapper<CheciEntity> {
	
	List<CheciVO> selectListVO(@Param("ew") Wrapper<CheciEntity> wrapper);
	
	CheciVO selectVO(@Param("ew") Wrapper<CheciEntity> wrapper);
	
	List<CheciView> selectListView(@Param("ew") Wrapper<CheciEntity> wrapper);

	List<CheciView> selectListView(Pagination page,@Param("ew") Wrapper<CheciEntity> wrapper);

	
	CheciView selectView(@Param("ew") Wrapper<CheciEntity> wrapper);
	

}
