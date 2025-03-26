package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussgongjiaoxianluEntity;
import com.entity.view.DiscussgongjiaoxianluView;

import com.service.DiscussgongjiaoxianluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公交线路评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@RestController
@RequestMapping("/discussgongjiaoxianlu")
public class DiscussgongjiaoxianluController {
    @Autowired
    private DiscussgongjiaoxianluService discussgongjiaoxianluService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussgongjiaoxianluEntity discussgongjiaoxianlu,
		HttpServletRequest request){
        EntityWrapper<DiscussgongjiaoxianluEntity> ew = new EntityWrapper<DiscussgongjiaoxianluEntity>();

		PageUtils page = discussgongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgongjiaoxianlu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussgongjiaoxianluEntity discussgongjiaoxianlu, 
		HttpServletRequest request){
        EntityWrapper<DiscussgongjiaoxianluEntity> ew = new EntityWrapper<DiscussgongjiaoxianluEntity>();

		PageUtils page = discussgongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgongjiaoxianlu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussgongjiaoxianluEntity discussgongjiaoxianlu){
       	EntityWrapper<DiscussgongjiaoxianluEntity> ew = new EntityWrapper<DiscussgongjiaoxianluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussgongjiaoxianlu, "discussgongjiaoxianlu")); 
        return R.ok().put("data", discussgongjiaoxianluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussgongjiaoxianluEntity discussgongjiaoxianlu){
        EntityWrapper< DiscussgongjiaoxianluEntity> ew = new EntityWrapper< DiscussgongjiaoxianluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussgongjiaoxianlu, "discussgongjiaoxianlu")); 
		DiscussgongjiaoxianluView discussgongjiaoxianluView =  discussgongjiaoxianluService.selectView(ew);
		return R.ok("查询公交线路评论表成功").put("data", discussgongjiaoxianluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussgongjiaoxianluEntity discussgongjiaoxianlu = discussgongjiaoxianluService.selectById(id);
        return R.ok().put("data", discussgongjiaoxianlu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussgongjiaoxianluEntity discussgongjiaoxianlu = discussgongjiaoxianluService.selectById(id);
        return R.ok().put("data", discussgongjiaoxianlu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussgongjiaoxianluEntity discussgongjiaoxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussgongjiaoxianlu);
        discussgongjiaoxianluService.insert(discussgongjiaoxianlu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussgongjiaoxianluEntity discussgongjiaoxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussgongjiaoxianlu);
        discussgongjiaoxianluService.insert(discussgongjiaoxianlu);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussgongjiaoxianluEntity discussgongjiaoxianlu = discussgongjiaoxianluService.selectOne(new EntityWrapper<DiscussgongjiaoxianluEntity>().eq("", username));
        return R.ok().put("data", discussgongjiaoxianlu);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussgongjiaoxianluEntity discussgongjiaoxianlu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussgongjiaoxianlu);
        discussgongjiaoxianluService.updateById(discussgongjiaoxianlu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussgongjiaoxianluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussgongjiaoxianluEntity discussgongjiaoxianlu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussgongjiaoxianluEntity> ew = new EntityWrapper<DiscussgongjiaoxianluEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussgongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussgongjiaoxianlu), params), params));
        return R.ok().put("data", page);
    }










}
