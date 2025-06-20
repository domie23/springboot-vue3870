package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LiuguandengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LiuguandengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LiuguandengjiView;


/**
 * 留观登记
 *
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface LiuguandengjiService extends IService<LiuguandengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiuguandengjiVO> selectListVO(Wrapper<LiuguandengjiEntity> wrapper);
   	
   	LiuguandengjiVO selectVO(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
   	
   	List<LiuguandengjiView> selectListView(Wrapper<LiuguandengjiEntity> wrapper);
   	
   	LiuguandengjiView selectView(@Param("ew") Wrapper<LiuguandengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiuguandengjiEntity> wrapper);
   	

}

