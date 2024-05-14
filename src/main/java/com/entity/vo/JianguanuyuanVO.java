package com.entity.vo;

import com.entity.JianguanuyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 监管员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianguanuyuan")
public class JianguanuyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
