package com.dao;

import com.entity.JiezhongdianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiezhongdianVO;
import com.entity.view.JiezhongdianView;


/**
 * 接种点
 * 
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface JiezhongdianDao extends BaseMapper<JiezhongdianEntity> {
	
	List<JiezhongdianVO> selectListVO(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
	
	JiezhongdianVO selectVO(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
	
	List<JiezhongdianView> selectListView(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);

	List<JiezhongdianView> selectListView(Pagination page,@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
	
	JiezhongdianView selectView(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
	

}
