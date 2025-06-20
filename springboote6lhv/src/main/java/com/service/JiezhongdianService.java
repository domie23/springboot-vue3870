package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiezhongdianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiezhongdianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiezhongdianView;


/**
 * 接种点
 *
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface JiezhongdianService extends IService<JiezhongdianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiezhongdianVO> selectListVO(Wrapper<JiezhongdianEntity> wrapper);
   	
   	JiezhongdianVO selectVO(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
   	
   	List<JiezhongdianView> selectListView(Wrapper<JiezhongdianEntity> wrapper);
   	
   	JiezhongdianView selectView(@Param("ew") Wrapper<JiezhongdianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiezhongdianEntity> wrapper);
   	

}

