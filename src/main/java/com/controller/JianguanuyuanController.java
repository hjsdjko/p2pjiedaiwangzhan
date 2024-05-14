
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
 * 监管员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianguanuyuan")
public class JianguanuyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JianguanuyuanController.class);

    @Autowired
    private JianguanuyuanService jianguanuyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = jianguanuyuanService.queryPage(params);

        //字典表数据转换
        List<JianguanuyuanView> list =(List<JianguanuyuanView>)page.getList();
        for(JianguanuyuanView c:list){
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
        JianguanuyuanEntity jianguanuyuan = jianguanuyuanService.selectById(id);
        if(jianguanuyuan !=null){
            //entity转view
            JianguanuyuanView view = new JianguanuyuanView();
            BeanUtils.copyProperties( jianguanuyuan , view );//把实体数据重构到view中

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
    public R save(@RequestBody JianguanuyuanEntity jianguanuyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianguanuyuan:{}",this.getClass().getName(),jianguanuyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JianguanuyuanEntity> queryWrapper = new EntityWrapper<JianguanuyuanEntity>()
            .eq("username", jianguanuyuan.getUsername())
            .or()
            .eq("jianguanuyuan_phone", jianguanuyuan.getJianguanuyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianguanuyuanEntity jianguanuyuanEntity = jianguanuyuanService.selectOne(queryWrapper);
        if(jianguanuyuanEntity==null){
            jianguanuyuan.setInsertTime(new Date());
            jianguanuyuan.setCreateTime(new Date());
            jianguanuyuan.setPassword("123456");
            jianguanuyuanService.insert(jianguanuyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianguanuyuanEntity jianguanuyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jianguanuyuan:{}",this.getClass().getName(),jianguanuyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JianguanuyuanEntity> queryWrapper = new EntityWrapper<JianguanuyuanEntity>()
            .notIn("id",jianguanuyuan.getId())
            .andNew()
            .eq("username", jianguanuyuan.getUsername())
            .or()
            .eq("jianguanuyuan_phone", jianguanuyuan.getJianguanuyuanPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianguanuyuanEntity jianguanuyuanEntity = jianguanuyuanService.selectOne(queryWrapper);
        if("".equals(jianguanuyuan.getJianguanuyuanPhoto()) || "null".equals(jianguanuyuan.getJianguanuyuanPhoto())){
                jianguanuyuan.setJianguanuyuanPhoto(null);
        }
        if(jianguanuyuanEntity==null){
            jianguanuyuanService.updateById(jianguanuyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jianguanuyuanService.deleteBatchIds(Arrays.asList(ids));
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
            List<JianguanuyuanEntity> jianguanuyuanList = new ArrayList<>();//上传的东西
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
                            JianguanuyuanEntity jianguanuyuanEntity = new JianguanuyuanEntity();
//                            jianguanuyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jianguanuyuanEntity.setPassword("123456");//密码
//                            jianguanuyuanEntity.setJianguanuyuanName(data.get(0));                    //监管员姓名 要改的
//                            jianguanuyuanEntity.setJianguanuyuanPhoto("");//详情和图片
//                            jianguanuyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jianguanuyuanEntity.setJianguanuyuanPhone(data.get(0));                    //联系方式 要改的
//                            jianguanuyuanEntity.setInsertTime(date);//时间
//                            jianguanuyuanEntity.setCreateTime(date);//时间
                            jianguanuyuanList.add(jianguanuyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("jianguanuyuanPhone")){
                                    List<String> jianguanuyuanPhone = seachFields.get("jianguanuyuanPhone");
                                    jianguanuyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jianguanuyuanPhone = new ArrayList<>();
                                    jianguanuyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("jianguanuyuanPhone",jianguanuyuanPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<JianguanuyuanEntity> jianguanuyuanEntities_username = jianguanuyuanService.selectList(new EntityWrapper<JianguanuyuanEntity>().in("username", seachFields.get("username")));
                        if(jianguanuyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianguanuyuanEntity s:jianguanuyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<JianguanuyuanEntity> jianguanuyuanEntities_jianguanuyuanPhone = jianguanuyuanService.selectList(new EntityWrapper<JianguanuyuanEntity>().in("jianguanuyuan_phone", seachFields.get("jianguanuyuanPhone")));
                        if(jianguanuyuanEntities_jianguanuyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianguanuyuanEntity s:jianguanuyuanEntities_jianguanuyuanPhone){
                                repeatFields.add(s.getJianguanuyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianguanuyuanService.insertBatch(jianguanuyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JianguanuyuanEntity jianguanuyuan = jianguanuyuanService.selectOne(new EntityWrapper<JianguanuyuanEntity>().eq("username", username));
        if(jianguanuyuan==null || !jianguanuyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jianguanuyuan.getId(),username, "jianguanuyuan", "监管员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","监管员");
        r.put("username",jianguanuyuan.getJianguanuyuanName());
        r.put("tableName","jianguanuyuan");
        r.put("userId",jianguanuyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JianguanuyuanEntity jianguanuyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JianguanuyuanEntity> queryWrapper = new EntityWrapper<JianguanuyuanEntity>()
            .eq("username", jianguanuyuan.getUsername())
            .or()
            .eq("jianguanuyuan_phone", jianguanuyuan.getJianguanuyuanPhone())
            ;
        JianguanuyuanEntity jianguanuyuanEntity = jianguanuyuanService.selectOne(queryWrapper);
        if(jianguanuyuanEntity != null)
            return R.error("账户或者联系方式已经被使用");
        jianguanuyuan.setInsertTime(new Date());
        jianguanuyuan.setCreateTime(new Date());
        jianguanuyuanService.insert(jianguanuyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JianguanuyuanEntity jianguanuyuan = new JianguanuyuanEntity();
        jianguanuyuan.setPassword("123456");
        jianguanuyuan.setId(id);
        jianguanuyuan.setInsertTime(new Date());
        jianguanuyuanService.updateById(jianguanuyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JianguanuyuanEntity jianguanuyuan = jianguanuyuanService.selectOne(new EntityWrapper<JianguanuyuanEntity>().eq("username", username));
        if(jianguanuyuan!=null){
            jianguanuyuan.setPassword("123456");
            boolean b = jianguanuyuanService.updateById(jianguanuyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJianguanuyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JianguanuyuanEntity jianguanuyuan = jianguanuyuanService.selectById(id);
        if(jianguanuyuan !=null){
            //entity转view
            JianguanuyuanView view = new JianguanuyuanView();
            BeanUtils.copyProperties( jianguanuyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = jianguanuyuanService.queryPage(params);

        //字典表数据转换
        List<JianguanuyuanView> list =(List<JianguanuyuanView>)page.getList();
        for(JianguanuyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianguanuyuanEntity jianguanuyuan = jianguanuyuanService.selectById(id);
            if(jianguanuyuan !=null){


                //entity转view
                JianguanuyuanView view = new JianguanuyuanView();
                BeanUtils.copyProperties( jianguanuyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody JianguanuyuanEntity jianguanuyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianguanuyuan:{}",this.getClass().getName(),jianguanuyuan.toString());
        Wrapper<JianguanuyuanEntity> queryWrapper = new EntityWrapper<JianguanuyuanEntity>()
            .eq("username", jianguanuyuan.getUsername())
            .or()
            .eq("jianguanuyuan_phone", jianguanuyuan.getJianguanuyuanPhone())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianguanuyuanEntity jianguanuyuanEntity = jianguanuyuanService.selectOne(queryWrapper);
        if(jianguanuyuanEntity==null){
            jianguanuyuan.setInsertTime(new Date());
            jianguanuyuan.setCreateTime(new Date());
        jianguanuyuan.setPassword("123456");
        jianguanuyuanService.insert(jianguanuyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }


}
