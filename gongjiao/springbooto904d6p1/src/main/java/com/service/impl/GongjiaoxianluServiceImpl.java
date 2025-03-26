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


import com.dao.GongjiaoxianluDao;
import com.entity.GongjiaoxianluEntity;
import com.service.GongjiaoxianluService;
import com.entity.vo.GongjiaoxianluVO;
import com.entity.view.GongjiaoxianluView;

@Service("gongjiaoxianluService")
public class GongjiaoxianluServiceImpl extends ServiceImpl<GongjiaoxianluDao, GongjiaoxianluEntity> implements GongjiaoxianluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongjiaoxianluEntity> page = this.selectPage(
                new Query<GongjiaoxianluEntity>(params).getPage(),
                new EntityWrapper<GongjiaoxianluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongjiaoxianluEntity> wrapper) {
		  Page<GongjiaoxianluView> page =new Query<GongjiaoxianluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<GongjiaoxianluVO> selectListVO(Wrapper<GongjiaoxianluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public GongjiaoxianluVO selectVO(Wrapper<GongjiaoxianluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<GongjiaoxianluView> selectListView(Wrapper<GongjiaoxianluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongjiaoxianluView selectView(Wrapper<GongjiaoxianluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GongjiaoxianluEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GongjiaoxianluEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GongjiaoxianluEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
