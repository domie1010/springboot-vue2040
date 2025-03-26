package com.dao;

import com.entity.GongjiaodongtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongjiaodongtaiVO;
import com.entity.view.GongjiaodongtaiView;


/**
 * 公交动态
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface GongjiaodongtaiDao extends BaseMapper<GongjiaodongtaiEntity> {
	
	List<GongjiaodongtaiVO> selectListVO(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);
	
	GongjiaodongtaiVO selectVO(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);
	
	List<GongjiaodongtaiView> selectListView(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);

	List<GongjiaodongtaiView> selectListView(Pagination page,@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);

	
	GongjiaodongtaiView selectView(@Param("ew") Wrapper<GongjiaodongtaiEntity> wrapper);
	

}
