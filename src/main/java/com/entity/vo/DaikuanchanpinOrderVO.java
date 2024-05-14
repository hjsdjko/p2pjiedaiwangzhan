package com.entity.vo;

import com.entity.DaikuanchanpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 贷款申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daikuanchanpin_order")
public class DaikuanchanpinOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 贷款产品
     */

    @TableField(value = "daikuanchanpin_id")
    private Integer daikuanchanpinId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 贷款凭证
     */

    @TableField(value = "daikuanchanpin_order_file")
    private String daikuanchanpinOrderFile;


    /**
     * 贷款备注
     */

    @TableField(value = "daikuanchanpin_order_text")
    private String daikuanchanpinOrderText;


    /**
     * 申请状态
     */

    @TableField(value = "daikuanchanpin_order_yesno_types")
    private Integer daikuanchanpinOrderYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "daikuanchanpin_order_yesno_text")
    private String daikuanchanpinOrderYesnoText;


    /**
     * 贷款时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 photoShow
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
	 * 设置：贷款产品
	 */
    public Integer getDaikuanchanpinId() {
        return daikuanchanpinId;
    }


    /**
	 * 获取：贷款产品
	 */

    public void setDaikuanchanpinId(Integer daikuanchanpinId) {
        this.daikuanchanpinId = daikuanchanpinId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：贷款凭证
	 */
    public String getDaikuanchanpinOrderFile() {
        return daikuanchanpinOrderFile;
    }


    /**
	 * 获取：贷款凭证
	 */

    public void setDaikuanchanpinOrderFile(String daikuanchanpinOrderFile) {
        this.daikuanchanpinOrderFile = daikuanchanpinOrderFile;
    }
    /**
	 * 设置：贷款备注
	 */
    public String getDaikuanchanpinOrderText() {
        return daikuanchanpinOrderText;
    }


    /**
	 * 获取：贷款备注
	 */

    public void setDaikuanchanpinOrderText(String daikuanchanpinOrderText) {
        this.daikuanchanpinOrderText = daikuanchanpinOrderText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getDaikuanchanpinOrderYesnoTypes() {
        return daikuanchanpinOrderYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setDaikuanchanpinOrderYesnoTypes(Integer daikuanchanpinOrderYesnoTypes) {
        this.daikuanchanpinOrderYesnoTypes = daikuanchanpinOrderYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getDaikuanchanpinOrderYesnoText() {
        return daikuanchanpinOrderYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setDaikuanchanpinOrderYesnoText(String daikuanchanpinOrderYesnoText) {
        this.daikuanchanpinOrderYesnoText = daikuanchanpinOrderYesnoText;
    }
    /**
	 * 设置：贷款时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：贷款时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
