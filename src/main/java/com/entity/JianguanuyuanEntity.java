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
 * 监管员
 *
 * @author 
 * @email
 */
@TableName("jianguanuyuan")
public class JianguanuyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianguanuyuanEntity() {

	}

	public JianguanuyuanEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 监管员姓名
     */
    @TableField(value = "jianguanuyuan_name")

    private String jianguanuyuanName;


    /**
     * 头像
     */
    @TableField(value = "jianguanuyuan_photo")

    private String jianguanuyuanPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @TableField(value = "jianguanuyuan_phone")

    private String jianguanuyuanPhone;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：监管员姓名
	 */
    public String getJianguanuyuanName() {
        return jianguanuyuanName;
    }
    /**
	 * 获取：监管员姓名
	 */

    public void setJianguanuyuanName(String jianguanuyuanName) {
        this.jianguanuyuanName = jianguanuyuanName;
    }
    /**
	 * 设置：头像
	 */
    public String getJianguanuyuanPhoto() {
        return jianguanuyuanPhoto;
    }
    /**
	 * 获取：头像
	 */

    public void setJianguanuyuanPhoto(String jianguanuyuanPhoto) {
        this.jianguanuyuanPhoto = jianguanuyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }
    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJianguanuyuanPhone() {
        return jianguanuyuanPhone;
    }
    /**
	 * 获取：联系方式
	 */

    public void setJianguanuyuanPhone(String jianguanuyuanPhone) {
        this.jianguanuyuanPhone = jianguanuyuanPhone;
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
        return "Jianguanuyuan{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jianguanuyuanName=" + jianguanuyuanName +
            ", jianguanuyuanPhoto=" + jianguanuyuanPhoto +
            ", sexTypes=" + sexTypes +
            ", jianguanuyuanPhone=" + jianguanuyuanPhone +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
