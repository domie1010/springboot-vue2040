package com.dao;

import com.entity.GongjiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongjiaoxinxiVO;
import com.entity.view.GongjiaoxinxiView;


/**
 * 公交信息
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface GongjiaoxinxiDao extends BaseMapper<GongjiaoxinxiEntity> {
	
	List<GongjiaoxinxiVO> selectListVO(@Param("ew") Wrapper<GongjiaoxinxiEntity> wrapper);
	
	GongjiaoxinxiVO selectVO(@Param("ew") Wrapper<GongjiaoxinxiEntity> wrapper);
	
	List<GongjiaoxinxiView> selectListView(@Param("ew") Wrapper<GongjiaoxinxiEntity> wrapper);

	List<GongjiaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongjiaoxinxiEntity> wrapper);

	
	GongjiaoxinxiView selectView(@Param("ew") Wrapper<GongjiaoxinxiEntity> wrapper);
	

}
