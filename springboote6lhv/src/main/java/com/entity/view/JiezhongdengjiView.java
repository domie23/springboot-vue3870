package com.entity.view;

import com.entity.JiezhongdengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 接种登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-24 09:12:48
 */
@TableName("jiezhongdengji")
public class JiezhongdengjiView  extends JiezhongdengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiezhongdengjiView(){
	}
 
 	public JiezhongdengjiView(JiezhongdengjiEntity jiezhongdengjiEntity){
 	try {
			BeanUtils.copyProperties(this, jiezhongdengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
