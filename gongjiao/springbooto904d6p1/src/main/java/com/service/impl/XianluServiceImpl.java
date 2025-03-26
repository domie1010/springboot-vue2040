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


import com.dao.XianluDao;
import com.entity.XianluEntity;
import com.service.XianluService;
import com.entity.vo.XianluVO;
import com.entity.view.XianluView;

@Service("xianluService")
public class XianluServiceImpl extends ServiceImpl<XianluDao, XianluEntity> implements XianluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianluEntity> page = this.selectPage(
                new Query<XianluEntity>(params).getPage(),
                new EntityWrapper<XianluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianluEntity> wrapper) {
		  Page<XianluView> page =new Query<XianluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XianluVO> selectListVO(Wrapper<XianluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XianluVO selectVO(Wrapper<XianluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XianluView> selectListView(Wrapper<XianluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianluView selectView(Wrapper<XianluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
