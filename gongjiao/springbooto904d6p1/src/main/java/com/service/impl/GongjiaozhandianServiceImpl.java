package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.GongjiaozhandianDao;
import com.entity.GongjiaozhandianEntity;
import com.service.GongjiaozhandianService;
import com.entity.vo.GongjiaozhandianVO;
import com.entity.view.GongjiaozhandianView;

@Service("gongjiaozhandianService")
public class GongjiaozhandianServiceImpl extends ServiceImpl<GongjiaozhandianDao, GongjiaozhandianEntity> implements GongjiaozhandianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongjiaozhandianEntity> page = this.selectPage(
                new Query<GongjiaozhandianEntity>(params).getPage(),
                new EntityWrapper<GongjiaozhandianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongjiaozhandianEntity> wrapper) {
		  Page<GongjiaozhandianView> page =new Query<GongjiaozhandianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GongjiaozhandianVO> selectListVO(Wrapper<GongjiaozhandianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongjiaozhandianVO selectVO(Wrapper<GongjiaozhandianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongjiaozhandianView> selectListView(Wrapper<GongjiaozhandianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongjiaozhandianView selectView(Wrapper<GongjiaozhandianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
