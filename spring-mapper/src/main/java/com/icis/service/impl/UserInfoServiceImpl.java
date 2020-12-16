package com.icis.service.impl;

import com.icis.mapper.UserInfoMapper;
import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

//用户接口实现类
@Service
public class UserInfoServiceImpl implements UserInfoService{
    //注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;

    //查询所有用户方法
    @Override
    public List<UserInfo> findAll() {
        //查询所有用户数据
        List<UserInfo> userInfoList = this.userInfoMapper.selectAll();

        return userInfoList;
    }
//根据用户实体查询数据
    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        this.userInfoMapper.insert(userInfo);
    }

    @Override
    public List<UserInfo> findByUserLike(UserInfo userInfo) {
        //创建一个条件查询对象
        Example example=new Example(userInfo.getClass());
        //构建条件
        Example.Criteria criteria = example.createCriteria();
        //添加具体条件  两个参数 ①字段名 ② 字段值
        criteria.andLike("name","%"+userInfo.getName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public int getCount(UserInfo userInfo) {
        Example example=new Example(userInfo.getClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+userInfo.getName()+"%");

        return userInfoMapper.selectCountByExample(example);
    }

    @Override
    public void updateAll(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
//根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
    @Override
    public UserInfo getUserById(UserInfo userInfo) {
        return userInfoMapper.selectByPrimaryKey(userInfo);
    }

    @Override
    public int updatePrimaryNotNull(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void deleteByName(UserInfo userInfo) {
        userInfoMapper.delete(userInfo);
    }

    @Override
    public void deleteById(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo);
    }
}
