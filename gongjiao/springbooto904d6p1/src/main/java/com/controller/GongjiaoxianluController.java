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

import com.entity.GongjiaoxianluEntity;
import com.entity.view.GongjiaoxianluView;

import com.service.GongjiaoxianluService;
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
 * 公交线路
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-24 19:59:21
 */
@RestController
@RequestMapping("/gongjiaoxianlu")
public class GongjiaoxianluController {
    @Autowired
    private GongjiaoxianluService gongjiaoxianluService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongjiaoxianluEntity gongjiaoxianlu,
		HttpServletRequest request){
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();

		PageUtils page = gongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxianlu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongjiaoxianluEntity gongjiaoxianlu, 
		HttpServletRequest request){
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();

		PageUtils page = gongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxianlu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongjiaoxianluEntity gongjiaoxianlu){
       	EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongjiaoxianlu, "gongjiaoxianlu")); 
        return R.ok().put("data", gongjiaoxianluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongjiaoxianluEntity gongjiaoxianlu){
        EntityWrapper< GongjiaoxianluEntity> ew = new EntityWrapper< GongjiaoxianluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongjiaoxianlu, "gongjiaoxianlu")); 
		GongjiaoxianluView gongjiaoxianluView =  gongjiaoxianluService.selectView(ew);
		return R.ok("查询公交线路成功").put("data", gongjiaoxianluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongjiaoxianluEntity gongjiaoxianlu = gongjiaoxianluService.selectById(id);
		gongjiaoxianlu.setClicknum(gongjiaoxianlu.getClicknum()+1);
		gongjiaoxianlu.setClicktime(new Date());
		gongjiaoxianluService.updateById(gongjiaoxianlu);
        gongjiaoxianlu = gongjiaoxianluService.selectView(new EntityWrapper<GongjiaoxianluEntity>().eq("id", id));
        return R.ok().put("data", gongjiaoxianlu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongjiaoxianluEntity gongjiaoxianlu = gongjiaoxianluService.selectById(id);
		gongjiaoxianlu.setClicknum(gongjiaoxianlu.getClicknum()+1);
		gongjiaoxianlu.setClicktime(new Date());
		gongjiaoxianluService.updateById(gongjiaoxianlu);
        gongjiaoxianlu = gongjiaoxianluService.selectView(new EntityWrapper<GongjiaoxianluEntity>().eq("id", id));
        return R.ok().put("data", gongjiaoxianlu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongjiaoxianluEntity gongjiaoxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaoxianlu);
        gongjiaoxianluService.insert(gongjiaoxianlu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongjiaoxianluEntity gongjiaoxianlu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(gongjiaoxianlu);
        gongjiaoxianluService.insert(gongjiaoxianlu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongjiaoxianluEntity gongjiaoxianlu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongjiaoxianlu);
        gongjiaoxianluService.updateById(gongjiaoxianlu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongjiaoxianluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,GongjiaoxianluEntity gongjiaoxianlu, HttpServletRequest request,String pre){
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
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
		PageUtils page = gongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxianlu), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,GongjiaoxianluEntity gongjiaoxianlu, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "xianlu";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "gongjiaoxianlu").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<GongjiaoxianluEntity> gongjiaoxianluList = new ArrayList<GongjiaoxianluEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                gongjiaoxianluList.addAll(gongjiaoxianluService.selectList(new EntityWrapper<GongjiaoxianluEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = gongjiaoxianluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongjiaoxianlu), params), params));
        List<GongjiaoxianluEntity> pageList = (List<GongjiaoxianluEntity>)page.getList();
        if(gongjiaoxianluList.size()<limit) {
            int toAddNum = (limit-gongjiaoxianluList.size())<=pageList.size()?(limit-gongjiaoxianluList.size()):pageList.size();
            for(GongjiaoxianluEntity o1 : pageList) {
                boolean addFlag = true;
                for(GongjiaoxianluEntity o2 : gongjiaoxianluList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    gongjiaoxianluList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(gongjiaoxianluList.size()>limit) {
            gongjiaoxianluList = gongjiaoxianluList.subList(0, limit);
        }
        page.setList(gongjiaoxianluList);
        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        List<Map<String, Object>> result = gongjiaoxianluService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongjiaoxianluService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        List<Map<String, Object>> result = gongjiaoxianluService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongjiaoxianluService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<GongjiaoxianluEntity> ew = new EntityWrapper<GongjiaoxianluEntity>();
        List<Map<String, Object>> result = gongjiaoxianluService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }







}
