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


import com.dao.LiuguandengjiDao;
import com.entity.LiuguandengjiEntity;
import com.service.LiuguandengjiService;
import com.entity.vo.LiuguandengjiVO;
import com.entity.view.LiuguandengjiView;

@Service("liuguandengjiService")
public class LiuguandengjiServiceImpl extends ServiceImpl<LiuguandengjiDao, LiuguandengjiEntity> implements LiuguandengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiuguandengjiEntity> page = this.selectPage(
                new Query<LiuguandengjiEntity>(params).getPage(),
                new EntityWrapper<LiuguandengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiuguandengjiEntity> wrapper) {
		  Page<LiuguandengjiView> page =new Query<LiuguandengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<LiuguandengjiVO> selectListVO(Wrapper<LiuguandengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LiuguandengjiVO selectVO(Wrapper<LiuguandengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LiuguandengjiView> selectListView(Wrapper<LiuguandengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiuguandengjiView selectView(Wrapper<LiuguandengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
