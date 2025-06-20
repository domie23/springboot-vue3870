package com.dao;

import com.entity.LiuguandengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LiuguandengjiVO;
import com.entity.view.LiuguandengjiView;


/**
 * 留观登记
 * 
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface LiuguandengjiDao extends BaseMapper<LiuguandengjiEntity> {
	
	List<LiuguandengjiVO> selectListVO(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
	
	LiuguandengjiVO selectVO(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
	
	List<LiuguandengjiView> selectListView(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);

	List<LiuguandengjiView> selectListView(Pagination page,@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
	
	LiuguandengjiView selectView(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
	

}
