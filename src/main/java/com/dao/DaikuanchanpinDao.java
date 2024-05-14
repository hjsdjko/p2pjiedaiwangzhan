package com.dao;

import com.entity.DaikuanchanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DaikuanchanpinView;

/**
 * 贷款产品 Dao 接口
 *
 * @author 
 */
public interface DaikuanchanpinDao extends BaseMapper<DaikuanchanpinEntity> {

   List<DaikuanchanpinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
