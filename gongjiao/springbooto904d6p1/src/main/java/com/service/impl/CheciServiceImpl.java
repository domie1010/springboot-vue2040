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


import com.dao.CheciDao;
import com.entity.CheciEntity;
import com.service.CheciService;
import com.entity.vo.CheciVO;
import com.entity.view.CheciView;

@Service("checiService")
public class CheciServiceImpl extends ServiceImpl<CheciDao, CheciEntity> implements CheciService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheciEntity> page = this.selectPage(
                new Query<CheciEntity>(params).getPage(),
                new EntityWrapper<CheciEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheciEntity> wrapper) {
		  Page<CheciView> page =new Query<CheciView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CheciVO> selectListVO(Wrapper<CheciEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheciVO selectVO(Wrapper<CheciEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheciView> selectListView(Wrapper<CheciEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheciView selectView(Wrapper<CheciEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
