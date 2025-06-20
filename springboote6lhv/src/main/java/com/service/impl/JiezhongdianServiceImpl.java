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


import com.dao.JiezhongdianDao;
import com.entity.JiezhongdianEntity;
import com.service.JiezhongdianService;
import com.entity.vo.JiezhongdianVO;
import com.entity.view.JiezhongdianView;

@Service("jiezhongdianService")
public class JiezhongdianServiceImpl extends ServiceImpl<JiezhongdianDao, JiezhongdianEntity> implements JiezhongdianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiezhongdianEntity> page = this.selectPage(
                new Query<JiezhongdianEntity>(params).getPage(),
                new EntityWrapper<JiezhongdianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiezhongdianEntity> wrapper) {
		  Page<JiezhongdianView> page =new Query<JiezhongdianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiezhongdianVO> selectListVO(Wrapper<JiezhongdianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiezhongdianVO selectVO(Wrapper<JiezhongdianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiezhongdianView> selectListView(Wrapper<JiezhongdianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiezhongdianView selectView(Wrapper<JiezhongdianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
