package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiezhongdengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiezhongdengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiezhongdengjiView;


/**
 * 接种登记
 *
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
public interface JiezhongdengjiService extends IService<JiezhongdengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiezhongdengjiVO> selectListVO(Wrapper<JiezhongdengjiEntity> wrapper);
   	
   	JiezhongdengjiVO selectVO(@Param("ew") Wrapper<JiezhongdengjiEntity> wrapper);
   	
   	List<JiezhongdengjiView> selectListView(Wrapper<JiezhongdengjiEntity> wrapper);
   	
   	JiezhongdengjiView selectView(@Param("ew") Wrapper<JiezhongdengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiezhongdengjiEntity> wrapper);
   	

}

