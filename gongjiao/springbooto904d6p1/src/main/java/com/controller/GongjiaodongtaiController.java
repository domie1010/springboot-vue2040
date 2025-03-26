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

import com.entity.GongjiaodongtaiEntity;
import com.entity.view.GongjiaodongtaiView;

import com.service.GongjiaodongtaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公交动态
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@RestController
@RequestMapping("/gongjiaodongtai")
public class GongjiaodongtaiController {
    @Autowired
    private GongjiaodongtaiService gongjiaodongtaiService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongjiaodongtaiEntity gongjiaodongtai,
		HttpServletRequest request){
        EntityWrapper<GongjiaodongtaiEntity> ew = new EntityWrapper<GongjiaodongtaiEntity>();

		PageUtils page = gongjiaodongtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaodongtai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongjiaodongtaiEntity gongjiaodongtai, 
		HttpServletRequest request){
        EntityWrapper<GongjiaodongtaiEntity> ew = new EntityWrapper<GongjiaodongtaiEntity>();

		PageUtils page = gongjiaodongtaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaodongtai), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongjiaodongtaiEntity gongjiaodongtai){
       	EntityWrapper<GongjiaodongtaiEntity> ew = new EntityWrapper<GongjiaodongtaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongjiaodongtai, "gongjiaodongtai")); 
        return R.ok().put("data", gongjiaodongtaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongjiaodongtaiEntity gongjiaodongtai){
        EntityWrapper< GongjiaodongtaiEntity> ew = new EntityWrapper< GongjiaodongtaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongjiaodongtai, "gongjiaodongtai")); 
		GongjiaodongtaiView gongjiaodongtaiView =  gongjiaodongtaiService.selectView(ew);
		return R.ok("查询公交动态成功").put("data", gongjiaodongtaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongjiaodongtaiEntity gongjiaodongtai = gongjiaodongtaiService.selectById(id);
        return R.ok().put("data", gongjiaodongtai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongjiaodongtaiEntity gongjiaodongtai = gongjiaodongtaiService.selectById(id);
        return R.ok().put("data", gongjiaodongtai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongjiaodongtaiEntity gongjiaodongtai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaodongtai);
        gongjiaodongtaiService.insert(gongjiaodongtai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongjiaodongtaiEntity gongjiaodongtai, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaodongtai);
        gongjiaodongtaiService.insert(gongjiaodongtai);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongjiaodongtaiEntity gongjiaodongtai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongjiaodongtai);
        gongjiaodongtaiService.updateById(gongjiaodongtai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongjiaodongtaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
