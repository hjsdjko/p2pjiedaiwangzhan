package com.entity.view;

import com.entity.DaikuanchanpinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 贷款产品
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("daikuanchanpin")
public class DaikuanchanpinView extends DaikuanchanpinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 产品类型的值
		*/
		private String daikuanchanpinValue;
		/**
		* 贷款周期的值
		*/
		private String daikuanzhouqiValue;



	public DaikuanchanpinView() {

	}

	public DaikuanchanpinView(DaikuanchanpinEntity daikuanchanpinEntity) {
		try {
			BeanUtils.copyProperties(this, daikuanchanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 产品类型的值
			*/
			public String getDaikuanchanpinValue() {
				return daikuanchanpinValue;
			}
			/**
			* 设置： 产品类型的值
			*/
			public void setDaikuanchanpinValue(String daikuanchanpinValue) {
				this.daikuanchanpinValue = daikuanchanpinValue;
			}
			/**
			* 获取： 贷款周期的值
			*/
			public String getDaikuanzhouqiValue() {
				return daikuanzhouqiValue;
			}
			/**
			* 设置： 贷款周期的值
			*/
			public void setDaikuanzhouqiValue(String daikuanzhouqiValue) {
				this.daikuanzhouqiValue = daikuanzhouqiValue;
			}












}
