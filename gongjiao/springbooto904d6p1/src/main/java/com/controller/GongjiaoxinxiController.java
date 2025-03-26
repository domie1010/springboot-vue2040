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

import com.entity.GongjiaoxinxiEntity;
import com.entity.view.GongjiaoxinxiView;

import com.service.GongjiaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 公交信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@RestController
@RequestMapping("/gongjiaoxinxi")
public class GongjiaoxinxiController {
    @Autowired
    private GongjiaoxinxiService gongjiaoxinxiService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongjiaoxinxiEntity gongjiaoxinxi,
		HttpServletRequest request){
        EntityWrapper<GongjiaoxinxiEntity> ew = new EntityWrapper<GongjiaoxinxiEntity>();

		PageUtils page = gongjiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongjiaoxinxiEntity gongjiaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<GongjiaoxinxiEntity> ew = new EntityWrapper<GongjiaoxinxiEntity>();

		PageUtils page = gongjiaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongjiaoxinxiEntity gongjiaoxinxi){
       	EntityWrapper<GongjiaoxinxiEntity> ew = new EntityWrapper<GongjiaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongjiaoxinxi, "gongjiaoxinxi")); 
        return R.ok().put("data", gongjiaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongjiaoxinxiEntity gongjiaoxinxi){
        EntityWrapper< GongjiaoxinxiEntity> ew = new EntityWrapper< GongjiaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongjiaoxinxi, "gongjiaoxinxi")); 
		GongjiaoxinxiView gongjiaoxinxiView =  gongjiaoxinxiService.selectView(ew);
		return R.ok("查询公交信息成功").put("data", gongjiaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongjiaoxinxiEntity gongjiaoxinxi = gongjiaoxinxiService.selectById(id);
        return R.ok().put("data", gongjiaoxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongjiaoxinxiEntity gongjiaoxinxi = gongjiaoxinxiService.selectById(id);
        return R.ok().put("data", gongjiaoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongjiaoxinxiEntity gongjiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaoxinxi);
        gongjiaoxinxiService.insert(gongjiaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongjiaoxinxiEntity gongjiaoxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaoxinxi);
        gongjiaoxinxiService.insert(gongjiaoxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongjiaoxinxiEntity gongjiaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongjiaoxinxi);
        gongjiaoxinxiService.updateById(gongjiaoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongjiaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
