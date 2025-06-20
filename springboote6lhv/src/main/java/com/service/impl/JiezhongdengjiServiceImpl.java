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


import com.dao.JiezhongdengjiDao;
import com.entity.JiezhongdengjiEntity;
import com.service.JiezhongdengjiService;
import com.entity.vo.JiezhongdengjiVO;
import com.entity.view.JiezhongdengjiView;

@Service("jiezhongdengjiService")
public class JiezhongdengjiServiceImpl extends ServiceImpl<JiezhongdengjiDao, JiezhongdengjiEntity> implements JiezhongdengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiezhongdengjiEntity> page = this.selectPage(
                new Query<JiezhongdengjiEntity>(params).getPage(),
                new EntityWrapper<JiezhongdengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiezhongdengjiEntity> wrapper) {
		  Page<JiezhongdengjiView> page =new Query<JiezhongdengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiezhongdengjiVO> selectListVO(Wrapper<JiezhongdengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiezhongdengjiVO selectVO(Wrapper<JiezhongdengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiezhongdengjiView> selectListView(Wrapper<JiezhongdengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiezhongdengjiView selectView(Wrapper<JiezhongdengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
