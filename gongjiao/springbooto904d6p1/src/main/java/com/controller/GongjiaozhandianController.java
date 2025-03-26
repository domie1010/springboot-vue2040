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

import com.entity.GongjiaozhandianEntity;
import com.entity.view.GongjiaozhandianView;

import com.service.GongjiaozhandianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公交站点
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:22
 */
@RestController
@RequestMapping("/gongjiaozhandian")
public class GongjiaozhandianController {
    @Autowired
    private GongjiaozhandianService gongjiaozhandianService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongjiaozhandianEntity gongjiaozhandian,
		HttpServletRequest request){
        EntityWrapper<GongjiaozhandianEntity> ew = new EntityWrapper<GongjiaozhandianEntity>();

		PageUtils page = gongjiaozhandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaozhandian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongjiaozhandianEntity gongjiaozhandian, 
		HttpServletRequest request){
        EntityWrapper<GongjiaozhandianEntity> ew = new EntityWrapper<GongjiaozhandianEntity>();

		PageUtils page = gongjiaozhandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaozhandian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongjiaozhandianEntity gongjiaozhandian){
       	EntityWrapper<GongjiaozhandianEntity> ew = new EntityWrapper<GongjiaozhandianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongjiaozhandian, "gongjiaozhandian")); 
        return R.ok().put("data", gongjiaozhandianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongjiaozhandianEntity gongjiaozhandian){
        EntityWrapper< GongjiaozhandianEntity> ew = new EntityWrapper< GongjiaozhandianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongjiaozhandian, "gongjiaozhandian")); 
		GongjiaozhandianView gongjiaozhandianView =  gongjiaozhandianService.selectView(ew);
		return R.ok("查询公交站点成功").put("data", gongjiaozhandianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongjiaozhandianEntity gongjiaozhandian = gongjiaozhandianService.selectById(id);
		gongjiaozhandian.setClicknum(gongjiaozhandian.getClicknum()+1);
		gongjiaozhandian.setClicktime(new Date());
		gongjiaozhandianService.updateById(gongjiaozhandian);
        gongjiaozhandian = gongjiaozhandianService.selectView(new EntityWrapper<GongjiaozhandianEntity>().eq("id", id));
        return R.ok().put("data", gongjiaozhandian);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongjiaozhandianEntity gongjiaozhandian = gongjiaozhandianService.selectById(id);
		gongjiaozhandian.setClicknum(gongjiaozhandian.getClicknum()+1);
		gongjiaozhandian.setClicktime(new Date());
		gongjiaozhandianService.updateById(gongjiaozhandian);
        gongjiaozhandian = gongjiaozhandianService.selectView(new EntityWrapper<GongjiaozhandianEntity>().eq("id", id));
        return R.ok().put("data", gongjiaozhandian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongjiaozhandianEntity gongjiaozhandian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaozhandian);
        gongjiaozhandianService.insert(gongjiaozhandian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongjiaozhandianEntity gongjiaozhandian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaozhandian);
        gongjiaozhandianService.insert(gongjiaozhandian);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongjiaozhandianEntity gongjiaozhandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongjiaozhandian);
        gongjiaozhandianService.updateById(gongjiaozhandian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongjiaozhandianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GongjiaozhandianEntity gongjiaozhandian, HttpServletRequest request,String pre){
        EntityWrapper<GongjiaozhandianEntity> ew = new EntityWrapper<GongjiaozhandianEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = gongjiaozhandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaozhandian), params), params));
        return R.ok().put("data", page);
    }










}
