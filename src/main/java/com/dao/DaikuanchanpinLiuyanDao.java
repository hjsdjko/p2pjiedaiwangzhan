package com.dao;

import com.entity.DaikuanchanpinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaikuanchanpinLiuyanView;

/**
 * 贷款产品评论 Dao 接口
 *
 * @author 
 */
public interface DaikuanchanpinLiuyanDao extends BaseMapper<DaikuanchanpinLiuyanEntity> {

   List<DaikuanchanpinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
