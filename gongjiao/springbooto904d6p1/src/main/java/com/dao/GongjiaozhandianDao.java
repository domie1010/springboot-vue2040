package com.dao;

import com.entity.GongjiaozhandianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongjiaozhandianVO;
import com.entity.view.GongjiaozhandianView;


/**
 * 公交站点
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface GongjiaozhandianDao extends BaseMapper<GongjiaozhandianEntity> {
	
	List<GongjiaozhandianVO> selectListVO(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);
	
	GongjiaozhandianVO selectVO(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);
	
	List<GongjiaozhandianView> selectListView(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);

	List<GongjiaozhandianView> selectListView(Pagination page,@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);

	
	GongjiaozhandianView selectView(@Param("ew") Wrapper<GongjiaozhandianEntity> wrapper);
	

}
