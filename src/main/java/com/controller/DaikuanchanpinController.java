
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 贷款产品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/daikuanchanpin")
public class DaikuanchanpinController {
    private static final Logger logger = LoggerFactory.getLogger(DaikuanchanpinController.class);

    @Autowired
    private DaikuanchanpinService daikuanchanpinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JianguanuyuanService jianguanuyuanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("监管员".equals(role))
            params.put("jianguanuyuanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = daikuanchanpinService.queryPage(params);

        //字典表数据转换
        List<DaikuanchanpinView> list =(List<DaikuanchanpinView>)page.getList();
        for(DaikuanchanpinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaikuanchanpinEntity daikuanchanpin = daikuanchanpinService.selectById(id);
        if(daikuanchanpin !=null){
            //entity转view
            DaikuanchanpinView view = new DaikuanchanpinView();
            BeanUtils.copyProperties( daikuanchanpin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,daikuanchanpin:{}",this.getClass().getName(),daikuanchanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DaikuanchanpinEntity> queryWrapper = new EntityWrapper<DaikuanchanpinEntity>()
            .eq("daikuanchanpin_uuid_number", daikuanchanpin.getDaikuanchanpinUuidNumber())
            .eq("daikuanchanpin_name", daikuanchanpin.getDaikuanchanpinName())
            .eq("daikuanchanpin_types", daikuanchanpin.getDaikuanchanpinTypes())
            .eq("daikuanzhouqi_types", daikuanchanpin.getDaikuanzhouqiTypes())
            .eq("feiyongxinxi_text", daikuanchanpin.getFeiyongxinxiText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaikuanchanpinEntity daikuanchanpinEntity = daikuanchanpinService.selectOne(queryWrapper);
        if(daikuanchanpinEntity==null){
            daikuanchanpin.setInsertTime(new Date());
            daikuanchanpin.setCreateTime(new Date());
            daikuanchanpinService.insert(daikuanchanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,daikuanchanpin:{}",this.getClass().getName(),daikuanchanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<DaikuanchanpinEntity> queryWrapper = new EntityWrapper<DaikuanchanpinEntity>()
            .notIn("id",daikuanchanpin.getId())
            .andNew()
            .eq("daikuanchanpin_uuid_number", daikuanchanpin.getDaikuanchanpinUuidNumber())
            .eq("daikuanchanpin_name", daikuanchanpin.getDaikuanchanpinName())
            .eq("daikuanchanpin_types", daikuanchanpin.getDaikuanchanpinTypes())
            .eq("daikuanzhouqi_types", daikuanchanpin.getDaikuanzhouqiTypes())
            .eq("feiyongxinxi_text", daikuanchanpin.getFeiyongxinxiText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaikuanchanpinEntity daikuanchanpinEntity = daikuanchanpinService.selectOne(queryWrapper);
        if("".equals(daikuanchanpin.getDaikuanchanpinPhoto()) || "null".equals(daikuanchanpin.getDaikuanchanpinPhoto())){
                daikuanchanpin.setDaikuanchanpinPhoto(null);
        }
        if(daikuanchanpinEntity==null){
            daikuanchanpinService.updateById(daikuanchanpin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        daikuanchanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<DaikuanchanpinEntity> daikuanchanpinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            DaikuanchanpinEntity daikuanchanpinEntity = new DaikuanchanpinEntity();
//                            daikuanchanpinEntity.setDaikuanchanpinUuidNumber(data.get(0));                    //产品编号 要改的
//                            daikuanchanpinEntity.setDaikuanchanpinName(data.get(0));                    //产品名称 要改的
//                            daikuanchanpinEntity.setDaikuanchanpinPhoto("");//详情和图片
//                            daikuanchanpinEntity.setDaikuanchanpinTypes(Integer.valueOf(data.get(0)));   //产品类型 要改的
//                            daikuanchanpinEntity.setDaikuanzhouqiTypes(Integer.valueOf(data.get(0)));   //贷款周期 要改的
//                            daikuanchanpinEntity.setFeiyongxinxiNewMoney(data.get(0));                    //产品金额 要改的
//                            daikuanchanpinEntity.setFeiyongxinxiLixiMoney(data.get(0));                    //产品利息 要改的
//                            daikuanchanpinEntity.setFeiyongxinxiText(data.get(0));                    //产品详情 要改的
//                            daikuanchanpinEntity.setInsertTime(date);//时间
//                            daikuanchanpinEntity.setCreateTime(date);//时间
                            daikuanchanpinList.add(daikuanchanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //产品编号
                                if(seachFields.containsKey("daikuanchanpinUuidNumber")){
                                    List<String> daikuanchanpinUuidNumber = seachFields.get("daikuanchanpinUuidNumber");
                                    daikuanchanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> daikuanchanpinUuidNumber = new ArrayList<>();
                                    daikuanchanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("daikuanchanpinUuidNumber",daikuanchanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //产品编号
                        List<DaikuanchanpinEntity> daikuanchanpinEntities_daikuanchanpinUuidNumber = daikuanchanpinService.selectList(new EntityWrapper<DaikuanchanpinEntity>().in("daikuanchanpin_uuid_number", seachFields.get("daikuanchanpinUuidNumber")));
                        if(daikuanchanpinEntities_daikuanchanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DaikuanchanpinEntity s:daikuanchanpinEntities_daikuanchanpinUuidNumber){
                                repeatFields.add(s.getDaikuanchanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [产品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        daikuanchanpinService.insertBatch(daikuanchanpinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = daikuanchanpinService.queryPage(params);

        //字典表数据转换
        List<DaikuanchanpinView> list =(List<DaikuanchanpinView>)page.getList();
        for(DaikuanchanpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DaikuanchanpinEntity daikuanchanpin = daikuanchanpinService.selectById(id);
            if(daikuanchanpin !=null){


                //entity转view
                DaikuanchanpinView view = new DaikuanchanpinView();
                BeanUtils.copyProperties( daikuanchanpin , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody DaikuanchanpinEntity daikuanchanpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,daikuanchanpin:{}",this.getClass().getName(),daikuanchanpin.toString());
        Wrapper<DaikuanchanpinEntity> queryWrapper = new EntityWrapper<DaikuanchanpinEntity>()
            .eq("daikuanchanpin_uuid_number", daikuanchanpin.getDaikuanchanpinUuidNumber())
            .eq("daikuanchanpin_name", daikuanchanpin.getDaikuanchanpinName())
            .eq("daikuanchanpin_types", daikuanchanpin.getDaikuanchanpinTypes())
            .eq("daikuanzhouqi_types", daikuanchanpin.getDaikuanzhouqiTypes())
            .eq("feiyongxinxi_text", daikuanchanpin.getFeiyongxinxiText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DaikuanchanpinEntity daikuanchanpinEntity = daikuanchanpinService.selectOne(queryWrapper);
        if(daikuanchanpinEntity==null){
            daikuanchanpin.setInsertTime(new Date());
            daikuanchanpin.setCreateTime(new Date());
        daikuanchanpinService.insert(daikuanchanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
