package com.entity.view;

import com.entity.DaikuanchanpinLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 贷款产品评论
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("daikuanchanpin_liuyan")
public class DaikuanchanpinLiuyanView extends DaikuanchanpinLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 daikuanchanpin
			/**
			* 产品编号
			*/
			private String daikuanchanpinUuidNumber;
			/**
			* 产品名称
			*/
			private String daikuanchanpinName;
			/**
			* 产品封面
			*/
			private String daikuanchanpinPhoto;
			/**
			* 产品类型
			*/
			private Integer daikuanchanpinTypes;
				/**
				* 产品类型的值
				*/
				private String daikuanchanpinValue;
			/**
			* 贷款周期
			*/
			private Integer daikuanzhouqiTypes;
				/**
				* 贷款周期的值
				*/
				private String daikuanzhouqiValue;
			/**
			* 产品金额
			*/
			private Double feiyongxinxiNewMoney;
			/**
			* 产品利息
			*/
			private Double feiyongxinxiLixiMoney;
			/**
			* 产品详情
			*/
			private String feiyongxinxiText;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public DaikuanchanpinLiuyanView() {

	}

	public DaikuanchanpinLiuyanView(DaikuanchanpinLiuyanEntity daikuanchanpinLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, daikuanchanpinLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set daikuanchanpin

					/**
					* 获取： 产品编号
					*/
					public String getDaikuanchanpinUuidNumber() {
						return daikuanchanpinUuidNumber;
					}
					/**
					* 设置： 产品编号
					*/
					public void setDaikuanchanpinUuidNumber(String daikuanchanpinUuidNumber) {
						this.daikuanchanpinUuidNumber = daikuanchanpinUuidNumber;
					}

					/**
					* 获取： 产品名称
					*/
					public String getDaikuanchanpinName() {
						return daikuanchanpinName;
					}
					/**
					* 设置： 产品名称
					*/
					public void setDaikuanchanpinName(String daikuanchanpinName) {
						this.daikuanchanpinName = daikuanchanpinName;
					}

					/**
					* 获取： 产品封面
					*/
					public String getDaikuanchanpinPhoto() {
						return daikuanchanpinPhoto;
					}
					/**
					* 设置： 产品封面
					*/
					public void setDaikuanchanpinPhoto(String daikuanchanpinPhoto) {
						this.daikuanchanpinPhoto = daikuanchanpinPhoto;
					}

					/**
					* 获取： 产品类型
					*/
					public Integer getDaikuanchanpinTypes() {
						return daikuanchanpinTypes;
					}
					/**
					* 设置： 产品类型
					*/
					public void setDaikuanchanpinTypes(Integer daikuanchanpinTypes) {
						this.daikuanchanpinTypes = daikuanchanpinTypes;
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
					* 获取： 贷款周期
					*/
					public Integer getDaikuanzhouqiTypes() {
						return daikuanzhouqiTypes;
					}
					/**
					* 设置： 贷款周期
					*/
					public void setDaikuanzhouqiTypes(Integer daikuanzhouqiTypes) {
						this.daikuanzhouqiTypes = daikuanzhouqiTypes;
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

					/**
					* 获取： 产品金额
					*/
					public Double getFeiyongxinxiNewMoney() {
						return feiyongxinxiNewMoney;
					}
					/**
					* 设置： 产品金额
					*/
					public void setFeiyongxinxiNewMoney(Double feiyongxinxiNewMoney) {
						this.feiyongxinxiNewMoney = feiyongxinxiNewMoney;
					}

					/**
					* 获取： 产品利息
					*/
					public Double getFeiyongxinxiLixiMoney() {
						return feiyongxinxiLixiMoney;
					}
					/**
					* 设置： 产品利息
					*/
					public void setFeiyongxinxiLixiMoney(Double feiyongxinxiLixiMoney) {
						this.feiyongxinxiLixiMoney = feiyongxinxiLixiMoney;
					}

					/**
					* 获取： 产品详情
					*/
					public String getFeiyongxinxiText() {
						return feiyongxinxiText;
					}
					/**
					* 设置： 产品详情
					*/
					public void setFeiyongxinxiText(String feiyongxinxiText) {
						this.feiyongxinxiText = feiyongxinxiText;
					}

























				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
