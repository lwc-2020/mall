package com.icis.service;

import com.icis.pojo.UserInfo;

import java.util.List;

//用户Servcie接口
public interface UserInfoService {
    //1.查询所有用户数据
    public List<UserInfo>  findAll();
    //2、根据条件查询
    public List<UserInfo> findByUserInfo(UserInfo userInfo);
    //3、保存用户方法
    public void addUser(UserInfo userInfo);
    //4、根据条件模糊查询
    public List<UserInfo> findByUserLike(UserInfo userInfo);
    //根据条件查询总记录数
    public int getCount(UserInfo userInfo);
    //根据主键更新实体全部字段，null值会被更新
    public void updateAll(UserInfo userInfo);
   //根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
   public UserInfo getUserById(UserInfo userInfo);

    public int updatePrimaryNotNull(UserInfo userInfo);

    public void deleteByName(UserInfo userInfo);

    public void deleteById(UserInfo userInfo);
}
