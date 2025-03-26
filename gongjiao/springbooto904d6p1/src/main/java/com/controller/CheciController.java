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

import com.entity.CheciEntity;
import com.entity.view.CheciView;

import com.service.CheciService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 车次
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
@RestController
@RequestMapping("/checi")
public class CheciController {
    @Autowired
    private CheciService checiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CheciEntity checi,
		HttpServletRequest request){
        EntityWrapper<CheciEntity> ew = new EntityWrapper<CheciEntity>();

		PageUtils page = checiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, checi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CheciEntity checi, 
		HttpServletRequest request){
        EntityWrapper<CheciEntity> ew = new EntityWrapper<CheciEntity>();

		PageUtils page = checiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, checi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CheciEntity checi){
       	EntityWrapper<CheciEntity> ew = new EntityWrapper<CheciEntity>();
      	ew.allEq(MPUtil.allEQMapPre( checi, "checi")); 
        return R.ok().put("data", checiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CheciEntity checi){
        EntityWrapper< CheciEntity> ew = new EntityWrapper< CheciEntity>();
 		ew.allEq(MPUtil.allEQMapPre( checi, "checi")); 
		CheciView checiView =  checiService.selectView(ew);
		return R.ok("查询车次成功").put("data", checiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CheciEntity checi = checiService.selectById(id);
        return R.ok().put("data", checi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CheciEntity checi = checiService.selectById(id);
        return R.ok().put("data", checi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CheciEntity checi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(checi);
        checiService.insert(checi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CheciEntity checi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(checi);
        checiService.insert(checi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CheciEntity checi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(checi);
        checiService.updateById(checi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        checiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
