package com.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LiuguandengjiEntity;
import com.entity.view.LiuguandengjiView;

import com.service.LiuguandengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 留观登记
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
@RestController
@RequestMapping("/liuguandengji")
public class LiuguandengjiController {
    @Autowired
    private LiuguandengjiService liuguandengjiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiuguandengjiEntity liuguandengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			liuguandengji.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			liuguandengji.setRenyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LiuguandengjiEntity> ew = new EntityWrapper<LiuguandengjiEntity>();
		PageUtils page = liuguandengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuguandengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiuguandengjiEntity liuguandengji, 
		HttpServletRequest request){
        EntityWrapper<LiuguandengjiEntity> ew = new EntityWrapper<LiuguandengjiEntity>();
		PageUtils page = liuguandengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuguandengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiuguandengjiEntity liuguandengji){
       	EntityWrapper<LiuguandengjiEntity> ew = new EntityWrapper<LiuguandengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liuguandengji, "liuguandengji")); 
        return R.ok().put("data", liuguandengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiuguandengjiEntity liuguandengji){
        EntityWrapper< LiuguandengjiEntity> ew = new EntityWrapper< LiuguandengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liuguandengji, "liuguandengji")); 
		LiuguandengjiView liuguandengjiView =  liuguandengjiService.selectView(ew);
		return R.ok("查询留观登记成功").put("data", liuguandengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiuguandengjiEntity liuguandengji = liuguandengjiService.selectById(id);
        return R.ok().put("data", liuguandengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiuguandengjiEntity liuguandengji = liuguandengjiService.selectById(id);
        return R.ok().put("data", liuguandengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LiuguandengjiEntity liuguandengji, HttpServletRequest request){
    	liuguandengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuguandengji);
        liuguandengjiService.insert(liuguandengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LiuguandengjiEntity liuguandengji, HttpServletRequest request){
    	liuguandengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuguandengji);
        liuguandengjiService.insert(liuguandengji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LiuguandengjiEntity liuguandengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liuguandengji);
        liuguandengjiService.updateById(liuguandengji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        liuguandengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<LiuguandengjiEntity> wrapper = new EntityWrapper<LiuguandengjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("gongzuorenyuan")) {
			wrapper.eq("renyuanzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = liuguandengjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
