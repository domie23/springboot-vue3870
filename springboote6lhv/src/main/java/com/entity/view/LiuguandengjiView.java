package com.entity.view;

import com.entity.LiuguandengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 留观登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
@TableName("liuguandengji")
public class LiuguandengjiView  extends LiuguandengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LiuguandengjiView(){
	}
 
 	public LiuguandengjiView(LiuguandengjiEntity liuguandengjiEntity){
 	try {
			BeanUtils.copyProperties(this, liuguandengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
