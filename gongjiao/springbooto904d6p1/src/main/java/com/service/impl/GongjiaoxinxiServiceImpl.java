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


import com.dao.GongjiaoxinxiDao;
import com.entity.GongjiaoxinxiEntity;
import com.service.GongjiaoxinxiService;
import com.entity.vo.GongjiaoxinxiVO;
import com.entity.view.GongjiaoxinxiView;

@Service("gongjiaoxinxiService")
public class GongjiaoxinxiServiceImpl extends ServiceImpl<GongjiaoxinxiDao, GongjiaoxinxiEntity> implements GongjiaoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongjiaoxinxiEntity> page = this.selectPage(
                new Query<GongjiaoxinxiEntity>(params).getPage(),
                new EntityWrapper<GongjiaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongjiaoxinxiEntity> wrapper) {
		  Page<GongjiaoxinxiView> page =new Query<GongjiaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GongjiaoxinxiVO> selectListVO(Wrapper<GongjiaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongjiaoxinxiVO selectVO(Wrapper<GongjiaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongjiaoxinxiView> selectListView(Wrapper<GongjiaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongjiaoxinxiView selectView(Wrapper<GongjiaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
