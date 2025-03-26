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

import com.entity.XianluEntity;
import com.entity.view.XianluView;

import com.service.XianluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 线路
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
@RestController
@RequestMapping("/xianlu")
public class XianluController {
    @Autowired
    private XianluService xianluService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianluEntity xianlu,
		HttpServletRequest request){
        EntityWrapper<XianluEntity> ew = new EntityWrapper<XianluEntity>();

		PageUtils page = xianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianlu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianluEntity xianlu, 
		HttpServletRequest request){
        EntityWrapper<XianluEntity> ew = new EntityWrapper<XianluEntity>();

		PageUtils page = xianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianlu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianluEntity xianlu){
       	EntityWrapper<XianluEntity> ew = new EntityWrapper<XianluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianlu, "xianlu")); 
        return R.ok().put("data", xianluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianluEntity xianlu){
        EntityWrapper< XianluEntity> ew = new EntityWrapper< XianluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianlu, "xianlu")); 
		XianluView xianluView =  xianluService.selectView(ew);
		return R.ok("查询线路成功").put("data", xianluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianluEntity xianlu = xianluService.selectById(id);
        return R.ok().put("data", xianlu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianluEntity xianlu = xianluService.selectById(id);
        return R.ok().put("data", xianlu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianluEntity xianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xianlu);
        xianluService.insert(xianlu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianluEntity xianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xianlu);
        xianluService.insert(xianlu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianluEntity xianlu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianlu);
        xianluService.updateById(xianlu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
