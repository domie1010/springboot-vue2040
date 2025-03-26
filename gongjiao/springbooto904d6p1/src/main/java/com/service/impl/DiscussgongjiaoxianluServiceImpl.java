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


import com.dao.DiscussgongjiaoxianluDao;
import com.entity.DiscussgongjiaoxianluEntity;
import com.service.DiscussgongjiaoxianluService;
import com.entity.vo.DiscussgongjiaoxianluVO;
import com.entity.view.DiscussgongjiaoxianluView;

@Service("discussgongjiaoxianluService")
public class DiscussgongjiaoxianluServiceImpl extends ServiceImpl<DiscussgongjiaoxianluDao, DiscussgongjiaoxianluEntity> implements DiscussgongjiaoxianluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgongjiaoxianluEntity> page = this.selectPage(
                new Query<DiscussgongjiaoxianluEntity>(params).getPage(),
                new EntityWrapper<DiscussgongjiaoxianluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgongjiaoxianluEntity> wrapper) {
		  Page<DiscussgongjiaoxianluView> page =new Query<DiscussgongjiaoxianluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussgongjiaoxianluVO> selectListVO(Wrapper<DiscussgongjiaoxianluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgongjiaoxianluVO selectVO(Wrapper<DiscussgongjiaoxianluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgongjiaoxianluView> selectListView(Wrapper<DiscussgongjiaoxianluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgongjiaoxianluView selectView(Wrapper<DiscussgongjiaoxianluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
