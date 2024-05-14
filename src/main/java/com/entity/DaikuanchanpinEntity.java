package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 贷款产品
 *
 * @author 
 * @email
 */
@TableName("daikuanchanpin")
public class DaikuanchanpinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaikuanchanpinEntity() {

	}

	public DaikuanchanpinEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 产品编号
     */
    @TableField(value = "daikuanchanpin_uuid_number")

    private String daikuanchanpinUuidNumber;


    /**
     * 产品名称
     */
    @TableField(value = "daikuanchanpin_name")

    private String daikuanchanpinName;


    /**
     * 产品封面
     */
    @TableField(value = "daikuanchanpin_photo")

    private String daikuanchanpinPhoto;


    /**
     * 产品类型
     */
    @TableField(value = "daikuanchanpin_types")

    private Integer daikuanchanpinTypes;


    /**
     * 贷款周期
     */
    @TableField(value = "daikuanzhouqi_types")

    private Integer daikuanzhouqiTypes;


    /**
     * 产品金额
     */
    @TableField(value = "feiyongxinxi_new_money")

    private Double feiyongxinxiNewMoney;


    /**
     * 产品利息
     */
    @TableField(value = "feiyongxinxi_lixi_money")

    private Double feiyongxinxiLixiMoney;


    /**
     * 产品详情
     */
    @TableField(value = "feiyongxinxi_text")

    private String feiyongxinxiText;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：产品编号
	 */
    public String getDaikuanchanpinUuidNumber() {
        return daikuanchanpinUuidNumber;
    }
    /**
	 * 获取：产品编号
	 */

    public void setDaikuanchanpinUuidNumber(String daikuanchanpinUuidNumber) {
        this.daikuanchanpinUuidNumber = daikuanchanpinUuidNumber;
    }
    /**
	 * 设置：产品名称
	 */
    public String getDaikuanchanpinName() {
        return daikuanchanpinName;
    }
    /**
	 * 获取：产品名称
	 */

    public void setDaikuanchanpinName(String daikuanchanpinName) {
        this.daikuanchanpinName = daikuanchanpinName;
    }
    /**
	 * 设置：产品封面
	 */
    public String getDaikuanchanpinPhoto() {
        return daikuanchanpinPhoto;
    }
    /**
	 * 获取：产品封面
	 */

    public void setDaikuanchanpinPhoto(String daikuanchanpinPhoto) {
        this.daikuanchanpinPhoto = daikuanchanpinPhoto;
    }
    /**
	 * 设置：产品类型
	 */
    public Integer getDaikuanchanpinTypes() {
        return daikuanchanpinTypes;
    }
    /**
	 * 获取：产品类型
	 */

    public void setDaikuanchanpinTypes(Integer daikuanchanpinTypes) {
        this.daikuanchanpinTypes = daikuanchanpinTypes;
    }
    /**
	 * 设置：贷款周期
	 */
    public Integer getDaikuanzhouqiTypes() {
        return daikuanzhouqiTypes;
    }
    /**
	 * 获取：贷款周期
	 */

    public void setDaikuanzhouqiTypes(Integer daikuanzhouqiTypes) {
        this.daikuanzhouqiTypes = daikuanzhouqiTypes;
    }
    /**
	 * 设置：产品金额
	 */
    public Double getFeiyongxinxiNewMoney() {
        return feiyongxinxiNewMoney;
    }
    /**
	 * 获取：产品金额
	 */

    public void setFeiyongxinxiNewMoney(Double feiyongxinxiNewMoney) {
        this.feiyongxinxiNewMoney = feiyongxinxiNewMoney;
    }
    /**
	 * 设置：产品利息
	 */
    public Double getFeiyongxinxiLixiMoney() {
        return feiyongxinxiLixiMoney;
    }
    /**
	 * 获取：产品利息
	 */

    public void setFeiyongxinxiLixiMoney(Double feiyongxinxiLixiMoney) {
        this.feiyongxinxiLixiMoney = feiyongxinxiLixiMoney;
    }
    /**
	 * 设置：产品详情
	 */
    public String getFeiyongxinxiText() {
        return feiyongxinxiText;
    }
    /**
	 * 获取：产品详情
	 */

    public void setFeiyongxinxiText(String feiyongxinxiText) {
        this.feiyongxinxiText = feiyongxinxiText;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Daikuanchanpin{" +
            "id=" + id +
            ", daikuanchanpinUuidNumber=" + daikuanchanpinUuidNumber +
            ", daikuanchanpinName=" + daikuanchanpinName +
            ", daikuanchanpinPhoto=" + daikuanchanpinPhoto +
            ", daikuanchanpinTypes=" + daikuanchanpinTypes +
            ", daikuanzhouqiTypes=" + daikuanzhouqiTypes +
            ", feiyongxinxiNewMoney=" + feiyongxinxiNewMoney +
            ", feiyongxinxiLixiMoney=" + feiyongxinxiLixiMoney +
            ", feiyongxinxiText=" + feiyongxinxiText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
