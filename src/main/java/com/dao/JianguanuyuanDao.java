package com.dao;

import com.entity.JianguanuyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianguanuyuanView;

/**
 * 监管员 Dao 接口
 *
 * @author 
 */
public interface JianguanuyuanDao extends BaseMapper<JianguanuyuanEntity> {

   List<JianguanuyuanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
