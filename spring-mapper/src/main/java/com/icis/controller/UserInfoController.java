package com.icis.controller;

import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//用户控制器
@RestController //@Controller+@ResponseBody
public class UserInfoController {
    //注入Service
    @Autowired
    private UserInfoService userInfoService;

    //查询所有用户数据
    @GetMapping("/findAll")
    public List<UserInfo>  findAll(){
        //调用service查询所有用户数据
        List<UserInfo> allUser = this.userInfoService.findAll();
        return allUser;

    }
    //根据用户实体查询用户
    @GetMapping("/findByUserInfo")
    public List<UserInfo> findByUserInfo(UserInfo userInfo){
        return this.userInfoService.findByUserInfo(userInfo);
    }
    //根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
    @GetMapping("/getUserById")
    public UserInfo getUserById(UserInfo userInfo){
        return this.userInfoService.getUserById(userInfo);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo){
        //调用service保存数据
        this.userInfoService.addUser(userInfo);
        return "添加成功";
    }
    @GetMapping("/findUserByLike")
    public List<UserInfo> findByLike(UserInfo userInfo){
        //根据名字模糊查询用户
        return userInfoService.findByUserLike(userInfo);
    }
    //根据模糊查询，查询总记录数
    @GetMapping("/getCount")
    public int getCount(UserInfo userInfo){
        return userInfoService.getCount(userInfo);
    }
    //根据主键更新实体全部字段，null值会被更新
    @PostMapping("/updateAllById")
    public String updateAllById(@RequestBody UserInfo userInfo){
        userInfoService.updateAll(userInfo);
        return "修改成功";
    }
    //根据主键更新属性不为null的值
    @PostMapping("/updateNotNull")
    public String updatePrimaryNotNull(@RequestBody UserInfo userInfo){
        userInfoService.updatePrimaryNotNull(userInfo);
        return "修改成功";
    }
    //根据实体属性作为条件进行删除，查询条件使用等号
    @PostMapping("/deleteBy")
    public String deleteBy(UserInfo userInfo){
        userInfoService.deleteByName(userInfo);
        return "删除成功";
    }
    //根据主键字段进行删除，方法参数必须包含完整的主键属性
    @PostMapping("/deleteById")
    public String deleteById(UserInfo userInfo){
        userInfoService.deleteById(userInfo);
        return "删除成功";
    }

}
