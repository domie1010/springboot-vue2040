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


import com.dao.GongjiaodongtaiDao;
import com.entity.GongjiaodongtaiEntity;
import com.service.GongjiaodongtaiService;
import com.entity.vo.GongjiaodongtaiVO;
import com.entity.view.GongjiaodongtaiView;

@Service("gongjiaodongtaiService")
public class GongjiaodongtaiServiceImpl extends ServiceImpl<GongjiaodongtaiDao, GongjiaodongtaiEntity> implements GongjiaodongtaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongjiaodongtaiEntity> page = this.selectPage(
                new Query<GongjiaodongtaiEntity>(params).getPage(),
                new EntityWrapper<GongjiaodongtaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongjiaodongtaiEntity> wrapper) {
		  Page<GongjiaodongtaiView> page =new Query<GongjiaodongtaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GongjiaodongtaiVO> selectListVO(Wrapper<GongjiaodongtaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongjiaodongtaiVO selectVO(Wrapper<GongjiaodongtaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongjiaodongtaiView> selectListView(Wrapper<GongjiaodongtaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongjiaodongtaiView selectView(Wrapper<GongjiaodongtaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
