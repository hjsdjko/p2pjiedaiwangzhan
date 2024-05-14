package com.entity.model;

import com.entity.DaikuanchanpinOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 贷款申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaikuanchanpinOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 贷款产品
     */
    private Integer daikuanchanpinId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 贷款凭证
     */
    private String daikuanchanpinOrderFile;


    /**
     * 贷款备注
     */
    private String daikuanchanpinOrderText;


    /**
     * 申请状态
     */
    private Integer daikuanchanpinOrderYesnoTypes;


    /**
     * 申请结果
     */
    private String daikuanchanpinOrderYesnoText;


    /**
     * 贷款时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：贷款产品
	 */
    public Integer getDaikuanchanpinId() {
        return daikuanchanpinId;
    }


    /**
	 * 设置：贷款产品
	 */
    public void setDaikuanchanpinId(Integer daikuanchanpinId) {
        this.daikuanchanpinId = daikuanchanpinId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：贷款凭证
	 */
    public String getDaikuanchanpinOrderFile() {
        return daikuanchanpinOrderFile;
    }


    /**
	 * 设置：贷款凭证
	 */
    public void setDaikuanchanpinOrderFile(String daikuanchanpinOrderFile) {
        this.daikuanchanpinOrderFile = daikuanchanpinOrderFile;
    }
    /**
	 * 获取：贷款备注
	 */
    public String getDaikuanchanpinOrderText() {
        return daikuanchanpinOrderText;
    }


    /**
	 * 设置：贷款备注
	 */
    public void setDaikuanchanpinOrderText(String daikuanchanpinOrderText) {
        this.daikuanchanpinOrderText = daikuanchanpinOrderText;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getDaikuanchanpinOrderYesnoTypes() {
        return daikuanchanpinOrderYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setDaikuanchanpinOrderYesnoTypes(Integer daikuanchanpinOrderYesnoTypes) {
        this.daikuanchanpinOrderYesnoTypes = daikuanchanpinOrderYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getDaikuanchanpinOrderYesnoText() {
        return daikuanchanpinOrderYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setDaikuanchanpinOrderYesnoText(String daikuanchanpinOrderYesnoText) {
        this.daikuanchanpinOrderYesnoText = daikuanchanpinOrderYesnoText;
    }
    /**
	 * 获取：贷款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：贷款时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
