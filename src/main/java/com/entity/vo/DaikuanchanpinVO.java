package com.entity.vo;

import com.entity.DaikuanchanpinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 贷款产品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daikuanchanpin")
public class DaikuanchanpinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
