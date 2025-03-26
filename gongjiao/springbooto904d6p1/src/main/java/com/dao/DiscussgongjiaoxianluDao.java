package com.dao;

import com.entity.DiscussgongjiaoxianluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgongjiaoxianluVO;
import com.entity.view.DiscussgongjiaoxianluView;


/**
 * 公交线路评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
public interface DiscussgongjiaoxianluDao extends BaseMapper<DiscussgongjiaoxianluEntity> {
	
	List<DiscussgongjiaoxianluVO> selectListVO(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);
	
	DiscussgongjiaoxianluVO selectVO(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);
	
	List<DiscussgongjiaoxianluView> selectListView(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);

	List<DiscussgongjiaoxianluView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);

	
	DiscussgongjiaoxianluView selectView(@Param("ew") Wrapper<DiscussgongjiaoxianluEntity> wrapper);
	

}
