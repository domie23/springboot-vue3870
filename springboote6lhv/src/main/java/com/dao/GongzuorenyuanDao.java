package com.dao;

import com.entity.GongzuorenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.GongzuorenyuanVO;
import com.entity.view.GongzuorenyuanView;


/**
 * 工作人员
 * 
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface GongzuorenyuanDao extends BaseMapper<GongzuorenyuanEntity> {
	
	List<GongzuorenyuanVO> selectListVO(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	GongzuorenyuanVO selectVO(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	List<GongzuorenyuanView> selectListView(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);

	List<GongzuorenyuanView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	
	GongzuorenyuanView selectView(@Param("ew") Wrapper<GongzuorenyuanEntity> wrapper);
	

}
