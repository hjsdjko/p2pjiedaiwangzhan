package com.entity.model;

import com.entity.DaikuanchanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 贷款产品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaikuanchanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 贷款周期
     */
    private Integer daikuanzhouqiTypes;


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


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：产品编号
	 */
    public String getDaikuanchanpinUuidNumber() {
        return daikuanchanpinUuidNumber;
    }


    /**
	 * 设置：产品编号
	 */
    public void setDaikuanchanpinUuidNumber(String daikuanchanpinUuidNumber) {
        this.daikuanchanpinUuidNumber = daikuanchanpinUuidNumber;
    }
    /**
	 * 获取：产品名称
	 */
    public String getDaikuanchanpinName() {
        return daikuanchanpinName;
    }


    /**
	 * 设置：产品名称
	 */
    public void setDaikuanchanpinName(String daikuanchanpinName) {
        this.daikuanchanpinName = daikuanchanpinName;
    }
    /**
	 * 获取：产品封面
	 */
    public String getDaikuanchanpinPhoto() {
        return daikuanchanpinPhoto;
    }


    /**
	 * 设置：产品封面
	 */
    public void setDaikuanchanpinPhoto(String daikuanchanpinPhoto) {
        this.daikuanchanpinPhoto = daikuanchanpinPhoto;
    }
    /**
	 * 获取：产品类型
	 */
    public Integer getDaikuanchanpinTypes() {
        return daikuanchanpinTypes;
    }


    /**
	 * 设置：产品类型
	 */
    public void setDaikuanchanpinTypes(Integer daikuanchanpinTypes) {
        this.daikuanchanpinTypes = daikuanchanpinTypes;
    }
    /**
	 * 获取：贷款周期
	 */
    public Integer getDaikuanzhouqiTypes() {
        return daikuanzhouqiTypes;
    }


    /**
	 * 设置：贷款周期
	 */
    public void setDaikuanzhouqiTypes(Integer daikuanzhouqiTypes) {
        this.daikuanzhouqiTypes = daikuanzhouqiTypes;
    }
    /**
	 * 获取：产品金额
	 */
    public Double getFeiyongxinxiNewMoney() {
        return feiyongxinxiNewMoney;
    }


    /**
	 * 设置：产品金额
	 */
    public void setFeiyongxinxiNewMoney(Double feiyongxinxiNewMoney) {
        this.feiyongxinxiNewMoney = feiyongxinxiNewMoney;
    }
    /**
	 * 获取：产品利息
	 */
    public Double getFeiyongxinxiLixiMoney() {
        return feiyongxinxiLixiMoney;
    }


    /**
	 * 设置：产品利息
	 */
    public void setFeiyongxinxiLixiMoney(Double feiyongxinxiLixiMoney) {
        this.feiyongxinxiLixiMoney = feiyongxinxiLixiMoney;
    }
    /**
	 * 获取：产品详情
	 */
    public String getFeiyongxinxiText() {
        return feiyongxinxiText;
    }


    /**
	 * 设置：产品详情
	 */
    public void setFeiyongxinxiText(String feiyongxinxiText) {
        this.feiyongxinxiText = feiyongxinxiText;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
